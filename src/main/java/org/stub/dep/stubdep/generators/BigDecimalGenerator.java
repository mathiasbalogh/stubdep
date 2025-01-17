package org.stub.dep.stubdep.generators;

import org.stub.dep.stubdep.annotations.NumberAnnotationAudit;
import org.stub.dep.stubdep.generators.postprocessors.NumberPostProcessor;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Random;

public class BigDecimalGenerator implements RandomDataGenerator<BigDecimal> {

    NumberPostProcessor numberPostProcessor = new NumberPostProcessor();

    @Override
    public BigDecimal generate(Field field) {
        var annotationAudit = new NumberAnnotationAudit(field);
        var random = new Random();

        var min = new BigDecimal(annotationAudit.decimalMin());
        var max = new BigDecimal(annotationAudit.decimalMax());

        var integerCount = annotationAudit.decimalMaxAnnotated() ? annotationAudit.decimalMax().split("\\.")[0].length() : annotationAudit.digits().integer();
        var fractionCount = annotationAudit.decimalMaxAnnotated() ? annotationAudit.decimalMax().split("\\.")[1].length() : annotationAudit.digits().fraction();

        StringBuilder integerPart = new StringBuilder();
        for (int i = 0; i <= random.nextInt(integerCount); i++) {
            integerPart.append(random.nextInt(10));
        }

        StringBuilder fractionalPart = new StringBuilder();
        for (int i = 0; i <= fractionCount; i++) {
            fractionalPart.append(random.nextInt(10));
        }

        BigDecimal generated = new BigDecimal(integerPart + "." + fractionalPart);

        if (annotationAudit.decimalMinAnnotated() && generated.compareTo(min) < 0) {
            generated = min;
        }
        if (annotationAudit.decimalMaxAnnotated() && generated.compareTo(max) > 0) {
            generated = max;
        }

        return (BigDecimal) numberPostProcessor.processAnnotations(generated, annotationAudit);
    }
}
