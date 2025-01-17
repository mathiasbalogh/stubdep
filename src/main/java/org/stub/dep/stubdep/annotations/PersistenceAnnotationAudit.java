package org.stub.dep.stubdep.annotations;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.lang.reflect.Field;

public record PersistenceAnnotationAudit(
        boolean isForeignKeyAnnotated
) {
    public PersistenceAnnotationAudit(Field field) {
        this(field.isAnnotationPresent(OneToMany.class) || field.isAnnotationPresent(OneToOne.class) || field.isAnnotationPresent(ManyToMany.class) || field.isAnnotationPresent(ManyToOne.class));
    }
}
