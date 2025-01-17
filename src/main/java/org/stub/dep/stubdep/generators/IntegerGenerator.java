package org.stub.dep.stubdep.generators;

import org.stub.dep.stubdep.annotations.NumberAnnotationAudit;
import org.stub.dep.stubdep.generators.postprocessors.NumberPostProcessor;

import java.lang.reflect.Field;
import java.util.Random;

public class IntegerGenerator implements RandomDataGenerator<Integer> {

    NumberPostProcessor numberPostProcessor = new NumberPostProcessor();

    @Override
    public Integer generate(Field field) {
        var annotationAudit = new NumberAnnotationAudit(field);

        int generatedValue = new Random().nextInt((int) annotationAudit.min(), annotationAudit.max() == Long.MAX_VALUE ? Integer.MAX_VALUE : (int) annotationAudit.max() + 1);

        return (Integer) numberPostProcessor.processAnnotations(generatedValue, annotationAudit);
    }
}
