package org.stub.dep.stubdep.annotations;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;

public record StringAnnotationAudit(
       StringSize size,
       String regexPattern,
       boolean notBlank,
       boolean notEmpty,
       boolean sizeAnnotated,
       boolean email
) {

    public StringAnnotationAudit(Field field) {
        this(
                Arrays.stream(field.getAnnotations()).filter(annotation -> annotation instanceof Size).map(annotation -> new StringSize(((Size) annotation).min(), ((Size) annotation).max())).findFirst().orElse(new StringSize(1, 20)),
                Arrays.stream(field.getAnnotations()).filter(annotation -> annotation instanceof Pattern).map(annotation -> ((Pattern) annotation).regexp()).findFirst().orElse(null),
                field.isAnnotationPresent(NotBlank.class),
                field.isAnnotationPresent(NotEmpty.class),
                field.isAnnotationPresent(Size.class),
                field.isAnnotationPresent(Email.class)
        );
    }

    public record StringSize(
            int min,
            int max
    ) {}
}
