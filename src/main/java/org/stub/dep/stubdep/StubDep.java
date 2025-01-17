package org.stub.dep.stubdep;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.stub.dep.stubdep.config.StubDepConfig;

import org.stub.dep.stubdep.generators.*;
import org.stub.dep.stubdep.model.StandardFields;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class StubDep {

    private static final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private static final Logger log = LoggerFactory.getLogger(StubDep.class);

    public static Object getTestPojo(Map<String, Object> defaultProperties, Map<String, Object> overrideProperties, Class<?> clazz) {
        HashMap<String, Object> properties = new HashMap<>(defaultProperties);
        properties.putAll(overrideProperties);

        return objectMapper.convertValue(properties, clazz);
    }

    public static Map<String, Object> overrideProperties(Object... overrideKeyValues) {
        Map<String, Object> map = new HashMap<>();
        if ((overrideKeyValues.length & 1) == 1) {
            throw new IllegalArgumentException("overrideKeyValues must come in pairs: stub(Foo.class, \"key\", value)");
        }
        for (int i = 0; i < overrideKeyValues.length; i += 2) {
            map.put((String) overrideKeyValues[i], overrideKeyValues[i + 1]);
        }
        return map;
    }

    public static <T> T stub(Class<T> clazz, Object... overrideKeyValues) {
        return (T) getTestPojo(defaultProperties(clazz), overrideProperties(overrideKeyValues), clazz);
    }

    public static <T> T stubVariant(T original, Object... overrideKeyValues) {
        return (T) getTestPojo(propertiesFrom(original), overrideProperties(overrideKeyValues), original.getClass());
    }

    public static <T> T stubVariantWithNullValues(T original, String... fieldsToNullify) {
        Map<String, Object> overrideProperties = Arrays.stream(fieldsToNullify).collect(HashMap::new,
                (map, field) -> map.put(field, null),
                HashMap::putAll);

        return (T) getTestPojo(propertiesFrom(original), overrideProperties, original.getClass());
    }

    private static Object fieldValueFromObject(Object object, Field field) {
        try {
            field.setAccessible(true);
            return field.get(object);
        } catch (IllegalAccessException exception) {
            log.error("Cannot access field value {} from original", field.getName());
        }
        return null;
    }

    public static Map<String, Object> propertiesFrom(Object original) {
        return Arrays.stream(original.getClass().getDeclaredFields()).collect(HashMap::new,
                (map, field) -> map.put(field.getName(), fieldValueFromObject(original, field)),
                HashMap::putAll);
    }

    public static Map<String, Object> defaultProperties(Class<?> clazz) {
        return Arrays.stream(clazz.getDeclaredFields()).collect(HashMap::new,
                (map, field) -> map.put(field.getName(), randomValueFor(field)),
                HashMap::putAll);
    }

    public static Object randomValueFor(Field field) {
        Class<?> type = field.getType();
        if (type.isEnum()) {
            return type.getEnumConstants()[0];
        } else {
            var generator = valueGenerators().get(type);
            if (generator == null && isCustomPojo(type)) {
                return stub(type);
            }
            return generator != null ? generator.generate(field) : null;
        }
    }

    public static Object randomValueFor(Class<?> clazz) {
        if (isCustomPojo(clazz)) return stub(clazz);

        var fieldOptional = Arrays.stream(StandardFields.class.getDeclaredFields()).filter(field -> field.getType() == clazz).toList().stream().findFirst();
        return fieldOptional.map(StubDep::randomValueFor).orElse(null);
    }

    public static Map<Class<?>, RandomDataGenerator<?>> valueGenerators() {
        HashMap<Class<?>, RandomDataGenerator<?>> defaultValueMap = new HashMap<>();

        defaultValueMap.put(UUID.class, new UUIDGenerator());

        defaultValueMap.put(String.class, new StringGenerator());

        defaultValueMap.put(Integer.class, new IntegerGenerator());
        defaultValueMap.put(int.class, new IntegerGenerator());
        defaultValueMap.put(Double.class, new DoubleGenerator());
        defaultValueMap.put(double.class, new DoubleGenerator());
        defaultValueMap.put(Float.class, new FloatGenerator());
        defaultValueMap.put(float.class, new FloatGenerator());
        defaultValueMap.put(Long.class, new LongGenerator());
        defaultValueMap.put(long.class, new LongGenerator());
        defaultValueMap.put(Short.class, new ShortGenerator());
        defaultValueMap.put(short.class, new ShortGenerator());
        defaultValueMap.put(BigDecimal.class, new BigDecimalGenerator());

        defaultValueMap.put(Instant.class, new InstantGenerator());
        defaultValueMap.put(Date.class, new DateGenerator());

        defaultValueMap.put(List.class, new ListGenerator());
        defaultValueMap.put(Set.class, new SetGenerator());
        defaultValueMap.put(Map.class, new MapGenerator());
        defaultValueMap.put(LinkedHashMap.class, new LinkedHashMapGenerator());

        defaultValueMap.put(Boolean.class, new BooleanGenerator());
        defaultValueMap.put(boolean.class, new BooleanGenerator());

        return defaultValueMap;
    }

    public static boolean isCustomPojo(Type type) {
        return StubDepConfig.getCustomPojoPackagePrefixes().stream().anyMatch(type.getTypeName()::startsWith);
    }
}
