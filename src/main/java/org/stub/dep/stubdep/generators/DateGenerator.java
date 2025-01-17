package org.stub.dep.stubdep.generators;

import org.stub.dep.stubdep.annotations.TimeAnnotationAudit;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.Random;

public class DateGenerator implements RandomDataGenerator<Date> {

    @Override
    public Date generate(Field field) {
        TimeAnnotationAudit annotationAudit = new TimeAnnotationAudit(field);
        Random random = new Random();
        long now = System.currentTimeMillis();

        long offset = random.nextInt(1, 7) * 24 * 60 * 60 * 1000L;
        Date generatedDate = new Date(now);

        if (annotationAudit.past()) {
            generatedDate = new Date(now - offset);
        } else if (annotationAudit.future()) {
            generatedDate = new Date(now + offset);
        }

        return generatedDate;
    }
}
