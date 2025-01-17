package org.stub.dep.stubdep.generators.postprocessors;

import org.stub.dep.stubdep.annotations.NumberAnnotationAudit;

import java.math.BigDecimal;

public class NumberPostProcessor {

    public Number processAnnotations(Number generatedValue, NumberAnnotationAudit annotationAudit) {
        BigDecimal value = (generatedValue instanceof Float || generatedValue instanceof Double)
                ? BigDecimal.valueOf(generatedValue.doubleValue())
                : new BigDecimal(generatedValue.toString());

        if (annotationAudit.positive() && value.compareTo(BigDecimal.ZERO) <= 0) {
            value = value.abs().add(BigDecimal.ONE);
        }
        if (annotationAudit.positiveOrZero() && value.compareTo(BigDecimal.ZERO) < 0) {
            value = value.abs();
        }
        if (annotationAudit.negative() && value.compareTo(BigDecimal.ZERO) >= 0) {
            value = value.negate().subtract(BigDecimal.ONE);
        }
        if (annotationAudit.negativeOrZero() && value.compareTo(BigDecimal.ZERO) > 0) {
            value = value.negate();
        }

        return convertToTargetType(generatedValue, value);
    }

    private Number convertToTargetType(Number generatedValue, BigDecimal value) {
        if (generatedValue instanceof Integer) {
            return value.intValue();
        } else if (generatedValue instanceof Double) {
            return value.doubleValue();
        } else if (generatedValue instanceof Long) {
            return value.longValue();
        } else if (generatedValue instanceof Float) {
            return value.floatValue();
        } else if (generatedValue instanceof Short) {
            return value.shortValue();
        } else if (generatedValue instanceof BigDecimal) {
            return value;
        } else {
            throw new IllegalArgumentException("Unsupported target type: " + generatedValue.getClass().getName());
        }
    }
}
