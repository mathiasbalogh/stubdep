package org.stub.dep.stubdep.generators;

import org.stub.dep.stubdep.annotations.NumberAnnotationAudit;
import org.stub.dep.stubdep.generators.postprocessors.NumberPostProcessor;

import java.lang.reflect.Field;
import java.util.Random;

public class DoubleGenerator implements RandomDataGenerator<Double> {

    NumberPostProcessor numberPostProcessor = new NumberPostProcessor();

    @Override
    public Double generate(Field field) {
        var annotationAudit = new NumberAnnotationAudit(field);

        double generatedValue = new Random().nextDouble((double) annotationAudit.min(), annotationAudit.max() == Long.MAX_VALUE ? Double.MAX_VALUE : (double) annotationAudit.max());

        return (Double) numberPostProcessor.processAnnotations(generatedValue, annotationAudit);
    }
}
