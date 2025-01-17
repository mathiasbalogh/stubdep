package org.stub.dep.stubdep;

import org.stub.dep.stubdep.model.StubbedDependency;
import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;


import java.util.Set;

import static org.stub.dep.stubdep.StubDep.stub;
import static jakarta.validation.Validation.buildDefaultValidatorFactory;

public class StubDepTest {
    
    @Test
    public void testStub() {
        for (int i = 0; i < 100; i++) {
            var stubbed = stub(StubbedDependency.class);

            var validator = buildDefaultValidatorFactory().getValidator();

            Set<ConstraintViolation<StubbedDependency>> violations = validator.validate(stubbed);

            System.out.println(stubbed.toString());

            for (ConstraintViolation<StubbedDependency> violation : violations) {
                System.out.println("Constraint violations found!");
                System.out.println(violation.getPropertyPath().toString() + violation.getMessage());
            }
            System.out.println("Number of violations: " + violations.size());

            assert violations.isEmpty();
        }
    }
}
