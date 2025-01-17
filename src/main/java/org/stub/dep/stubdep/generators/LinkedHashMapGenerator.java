package org.stub.dep.stubdep.generators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.stub.dep.stubdep.StubDep;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.LinkedHashMap;

import static org.stub.dep.stubdep.StubDep.randomValueFor;

public class LinkedHashMapGenerator implements RandomDataGenerator<LinkedHashMap<?,?>> {

    private static final Logger log = LoggerFactory.getLogger(LinkedHashMapGenerator.class);

    @Override
    public LinkedHashMap<?,?> generate(Field field) {
        var listType = (ParameterizedType) field.getGenericType();
        var containedTypes = listType.getActualTypeArguments();
        var result = new LinkedHashMap<>();

        if (containedTypes.length != 2) {
            log.error("Map property {} has been declared without enough type parameters. Stub can only provide an empty list", field.getName());
            return result;
        }

        var keyType = containedTypes[0];
        var valueType = containedTypes[1];
        try {
            // TODO determine how to handle Object as a key or value class
            // TODO generate linkedhashmap with random size instead of just one
            var key = StubDep.randomValueFor(Class.forName(keyType.getTypeName()));
            var value = StubDep.randomValueFor(Class.forName(valueType.getTypeName()));
            if (key != null && value != null) {
                result.put(key, value);
            }
        } catch (ClassNotFoundException exception) {
            log.error("Parameterized Class for field {} cannot be stubbed because class is not found.", field.getName());
        }
        return result;
    }
}
