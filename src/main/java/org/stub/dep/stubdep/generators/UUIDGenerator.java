package org.stub.dep.stubdep.generators;

import java.lang.reflect.Field;
import java.util.UUID;

public class UUIDGenerator implements RandomDataGenerator<UUID> {

    @Override
    public UUID generate(Field field) {
        return UUID.randomUUID();
    }
}
