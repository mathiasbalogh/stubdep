package org.stub.dep.stubdep.generators;

import java.lang.reflect.Field;

public interface RandomDataGenerator<T> {

    T generate(Field field);
}
