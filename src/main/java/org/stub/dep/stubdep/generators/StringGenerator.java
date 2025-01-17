package org.stub.dep.stubdep.generators;

import org.stub.dep.stubdep.annotations.StringAnnotationAudit;
import org.apache.commons.lang3.RandomStringUtils;

import java.lang.reflect.Field;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringGenerator implements RandomDataGenerator<String> {

    @Override
    public String generate(Field field) {
        var stringAnnotationAudit = new StringAnnotationAudit(field);
        var random = new Random();
        var minLength = stringAnnotationAudit.size().min();
        var maxLength = stringAnnotationAudit.size().max();

        String generatedString = RandomStringUtils.randomAlphanumeric(minLength + random.nextInt(maxLength - minLength + 1));

        if (stringAnnotationAudit.notBlank() || stringAnnotationAudit.notEmpty()) {
            generatedString = generatedString.trim().isEmpty() ? "defaultValue" : generatedString;
        }

        if (stringAnnotationAudit.regexPattern() != null) {
            boolean matched = false;
            for (int i = 0; i < 5; i++) {
                generatedString = RandomStringUtils.randomAlphanumeric(1000);
                var pattern = Pattern.compile(stringAnnotationAudit.regexPattern());
                Matcher matcher = pattern.matcher(generatedString);

                if (matcher.find()) {
                    generatedString = stringAnnotationAudit.sizeAnnotated() ? matcher.group().substring(0, maxLength) : matcher.group();
                    matched = true;
                    break;
                }
            }

            if (!matched) {
                generatedString = "exampleMatch";
            }
        }

        if (stringAnnotationAudit.email()) {
            generatedString = RandomStringUtils.randomAlphanumeric(random.nextInt(4, 15)) + "@stubdep.com";
        }

        return generatedString;
    }
}
