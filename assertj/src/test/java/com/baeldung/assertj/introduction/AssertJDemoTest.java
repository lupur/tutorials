package com.baeldung.assertj.introduction;

import com.baeldung.assertj.introduction.domain.Dog;
import com.baeldung.assertj.introduction.domain.Person;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

public class AssertJDemoTest {

    @Test
    public void whenComparingReferences_thenNotEqual() throws Exception {
        Dog fido = new Dog("Fido", 5.15f);
        Dog fidosClone = new Dog("Fido", 5.15f);

        assertThat(fido).isNotEqualTo(fidosClone);
    }

    @Test
    public void whenComparingFields_thenEqual() throws Exception {
        Dog fido = new Dog("Fido", 5.15f);
        Dog fidosClone = new Dog("Fido", 5.15f);

        assertThat(fido).isEqualToComparingFieldByFieldRecursively(fidosClone);
    }

    @Test
    public void whenCheckingForElement_thenContains() throws Exception {
        List<String> list = Arrays.asList("1", "2", "3");

        assertThat(list)
                .contains("1");
    }

    @Test
    public void whenCheckingForElement_thenMultipleAssertions() throws Exception {
        List<String> list = Arrays.asList("1", "2", "3");

        assertThat(list)
                .isNotEmpty()
                .contains("1")
                .startsWith("1")
                .doesNotContainNull()
                .containsSequence("2", "3");
    }

    @Test
    public void whenCheckingRunnable_thenIsInterface() throws Exception {
        assertThat(Runnable.class).isInterface();
    }

    @Test
    public void whenAssigningNSEExToException_thenIsAssignable() throws Exception {
        assertThat(Exception.class).isAssignableFrom(NoSuchElementException.class);
    }

    @Test
    public void whenComparingWithOffset_thenEquals() throws Exception {
        assertThat(5.1).isEqualTo(5, withPrecision(1d));
    }

    @Ignore // IN ORDER TO TEST, REMOVE THIS LINE
    @Test
    public void whenRunningAssertion_thenDescribed() throws Exception {
        Person person = new Person("Alex", 34);

        assertThat(person.getAge())
                .as("%s's age should be equal to 100")
                .isEqualTo(100);
    }
}
