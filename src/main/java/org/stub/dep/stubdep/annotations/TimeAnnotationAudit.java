package org.stub.dep.stubdep.annotations;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;

import java.lang.reflect.Field;

public record TimeAnnotationAudit(
        boolean future,
        boolean past
) {
    public TimeAnnotationAudit(Field field) {
        this(
                field.isAnnotationPresent(Future.class) || field.isAnnotationPresent(FutureOrPresent.class),
                field.isAnnotationPresent(Past.class) || field.isAnnotationPresent(PastOrPresent.class)
        );
    }
}
