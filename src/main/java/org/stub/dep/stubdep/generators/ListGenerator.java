package org.stub.dep.stubdep.generators;

import org.stub.dep.stubdep.annotations.PersistenceAnnotationAudit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.stub.dep.stubdep.StubDep;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import static org.stub.dep.stubdep.StubDep.randomValueFor;

public class ListGenerator implements RandomDataGenerator<List<?>> {

    private static final Logger log = LoggerFactory.getLogger(ListGenerator.class);

    @Override
    public List<?> generate(Field field) {
        var persistenceAnnotationAudit = new PersistenceAnnotationAudit(field);
        try {
            var listType = (ParameterizedType) field.getGenericType();
            var containedType = Class.forName(listType.getActualTypeArguments()[0].getTypeName());

            if (persistenceAnnotationAudit.isForeignKeyAnnotated()) return List.of();

            var valueForContainedType = StubDep.randomValueFor(containedType);
            return valueForContainedType != null ? List.of(valueForContainedType) : List.of();
        } catch (ClassCastException | IndexOutOfBoundsException exception) {
            log.error("List property {} has been declared without a type parameter. Stub can only provide an empty list", field.getName());
            return List.of();
        } catch (ClassNotFoundException exception) {
            log.error("Parameterized Class for field {} cannot be stubbed because class is not found.", field.getName());
            return  List.of();
        }
    }
}
