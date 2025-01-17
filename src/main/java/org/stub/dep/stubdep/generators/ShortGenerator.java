package org.stub.dep.stubdep.generators;

import org.stub.dep.stubdep.annotations.NumberAnnotationAudit;
import org.stub.dep.stubdep.generators.postprocessors.NumberPostProcessor;

import java.lang.reflect.Field;
import java.util.Random;

public class ShortGenerator implements RandomDataGenerator<Short>{

    NumberPostProcessor numberPostProcessor = new NumberPostProcessor();

    @Override
    public Short generate(Field field) {
        var annotationAudit = new NumberAnnotationAudit(field);

        short generatedValue = (short) new Random().nextInt((int) annotationAudit.min(), annotationAudit.max() == Long.MAX_VALUE ? Short.MAX_VALUE : (short) annotationAudit.max() + 1);

        return (Short) numberPostProcessor.processAnnotations(generatedValue, annotationAudit);
    }

}
