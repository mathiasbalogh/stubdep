package org.stub.dep.stubdep.annotations;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Negative;
import jakarta.validation.constraints.NegativeOrZero;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.lang.reflect.Field;
import java.util.Arrays;

public record NumberAnnotationAudit(
        long min,
        long max,
        String decimalMin,
        String decimalMax,
        DigitAudit digits,
        boolean decimalMinAnnotated,
        boolean decimalMaxAnnotated,
        boolean digitsAnnotated,
        boolean positive,
        boolean positiveOrZero,
        boolean negative,
        boolean negativeOrZero
) {
    public NumberAnnotationAudit(Field field) {
        this(Arrays.stream(field.getAnnotations()).filter(annotation -> annotation instanceof Min).map(annotation -> ((Min) annotation).value()).findFirst().orElse(0L),
             Arrays.stream(field.getAnnotations()).filter(annotation -> annotation instanceof Max).map(annotation -> ((Max) annotation).value()).findFirst().orElse(Long.MAX_VALUE),
             Arrays.stream(field.getAnnotations()).filter(annotation -> annotation instanceof DecimalMin).map(annotation -> ((DecimalMin) annotation).value()).findFirst().orElse("0.00"),
             Arrays.stream(field.getAnnotations()).filter(annotation -> annotation instanceof DecimalMax).map(annotation -> ((DecimalMax) annotation).value()).findFirst().orElse("10000.00"),
             Arrays.stream(field.getAnnotations()).filter(annotation -> annotation instanceof Digits).map(annotation -> new DigitAudit(((Digits) annotation).integer(), ((Digits) annotation).fraction())).findFirst().orElse(new DigitAudit(7, 2)),
             field.isAnnotationPresent(DecimalMin.class),
             field.isAnnotationPresent(DecimalMax.class),
             field.isAnnotationPresent(Digits.class),
             field.isAnnotationPresent(Positive.class),
             field.isAnnotationPresent(PositiveOrZero.class),
             field.isAnnotationPresent(Negative.class),
             field.isAnnotationPresent(NegativeOrZero.class));
    }

    public record DigitAudit(
            int integer,
            int fraction
    ) {}
}