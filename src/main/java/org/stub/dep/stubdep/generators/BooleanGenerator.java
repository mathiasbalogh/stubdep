package org.stub.dep.stubdep.generators;

import java.lang.reflect.Field;
import java.util.Random;

public class BooleanGenerator implements RandomDataGenerator<Boolean>{

    private final Random random = new Random();

    @Override
    public Boolean generate(Field field) {
        return random.nextBoolean();
    }
}
