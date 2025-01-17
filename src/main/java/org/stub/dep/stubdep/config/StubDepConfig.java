package org.stub.dep.stubdep.config;

import java.util.Arrays;
import java.util.List;

public class StubDepConfig {

    private static boolean isInitialized = false;
    private static List<String> customPojoPackagePrefixes;

    public static void initialize() {
        if (!isInitialized) {
            customPojoPackagePrefixes = loadPackagePrefixes();
            isInitialized = true;
        }
    }

    public static List<String> getCustomPojoPackagePrefixes() {
        initialize();
        return customPojoPackagePrefixes;
    }

    private static List<String> loadPackagePrefixes() {
        String prefixes = System.getProperty("stubdep.custom-pojo.package-prefixes", "org.stub.dep");
        return Arrays.asList(prefixes.split(","));
    }
}
