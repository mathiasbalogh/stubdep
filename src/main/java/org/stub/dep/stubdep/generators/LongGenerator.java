package org.stub.dep.stubdep.generators;

import org.stub.dep.stubdep.annotations.NumberAnnotationAudit;
import org.stub.dep.stubdep.generators.postprocessors.NumberPostProcessor;

import java.lang.reflect.Field;
import java.util.Random;

public class LongGenerator implements RandomDataGenerator<Long> {

    NumberPostProcessor numberPostProcessor = new NumberPostProcessor();

    @Override
    public Long generate(Field field) {
        var annotationAudit = new NumberAnnotationAudit(field);

        long generatedValue = new Random().nextLong(annotationAudit.min(), annotationAudit.max() == Long.MAX_VALUE ? annotationAudit.max() : annotationAudit.max() + 1);

        return (Long) numberPostProcessor.processAnnotations(generatedValue, annotationAudit);
    }
}
