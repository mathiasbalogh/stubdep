package org.stub.dep.stubdep.generators;

import org.stub.dep.stubdep.annotations.NumberAnnotationAudit;
import org.stub.dep.stubdep.generators.postprocessors.NumberPostProcessor;

import java.lang.reflect.Field;
import java.util.Random;

public class FloatGenerator implements RandomDataGenerator<Float> {

    NumberPostProcessor numberPostProcessor = new NumberPostProcessor();

    @Override
    public Float generate(Field field) {
        var annotationAudit = new NumberAnnotationAudit(field);

        float generatedValue = new Random().nextFloat((float) annotationAudit.min(), annotationAudit.max() == Long.MAX_VALUE ? Float.MAX_VALUE : (float) annotationAudit.max());

        return (Float) numberPostProcessor.processAnnotations(generatedValue, annotationAudit);
    }

}
