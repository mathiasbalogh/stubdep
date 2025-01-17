package org.stub.dep.stubdep.generators;

import org.stub.dep.stubdep.annotations.TimeAnnotationAudit;

import java.lang.reflect.Field;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class InstantGenerator implements RandomDataGenerator<Instant> {
    @Override
    public Instant generate(Field field) {
        var timeAnnotationAudit = new TimeAnnotationAudit(field);

        Instant generatedInstant = Instant.now();

        if (timeAnnotationAudit.future()) {
            generatedInstant = generatedInstant.plus(1, ChronoUnit.DAYS);
        } else if (timeAnnotationAudit.past()) {
            generatedInstant = generatedInstant.minus(1, ChronoUnit.DAYS);
        }

        return generatedInstant;
    }

}
