package org.stub.dep.stubdep.generators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Map;

import static org.stub.dep.stubdep.StubDep.randomValueFor;

public class MapGenerator implements RandomDataGenerator<Map<?, ?>> {

    private static final Logger log = LoggerFactory.getLogger(MapGenerator.class);

    @Override
    public Map<?, ?> generate(Field field) {
        var listType = (ParameterizedType) field.getGenericType();
        var containedTypes = listType.getActualTypeArguments();

        if (containedTypes.length != 2) {
            log.error("Map property {} has been declared without enough type parameters. Stub can only provide an empty list", field.getName());
            return Map.of();
        }

        var keyType = containedTypes[0];
        var valueType = containedTypes[1];
        try {
            var key = randomValueFor(Class.forName(keyType.getTypeName()));
            var value = randomValueFor(Class.forName(valueType.getTypeName()));
            return key != null && value != null ? Map.of(key, value) : Map.of();
        } catch (ClassNotFoundException exception) {
            log.error("Parameterized Class for field {} cannot be stubbed because class is not found.", field.getName());
            return  Map.of();
        }
    }
}
