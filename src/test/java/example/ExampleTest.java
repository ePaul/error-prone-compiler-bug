package example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ExampleTest {

    @SafeVarargs
    final <E> String example(final Class<? super E>... classes) {
        return "with classes";
    }

    @SafeVarargs
    final <E> String example(final E... items) {
        return "with items";
    }

    @SafeVarargs
    final String indirectCall(final Class<? super ExampleTest>... classes) {
        return example(classes);
    }

    @Test
    public void testNormalVarargsCall() {
        final String result = example(ExampleTest.class, Object.class);
        assertEquals("with classes", result);
    }

    @Test
    public void testIndirectVarargsCall() {
        final String result = indirectCall(ExampleTest.class, Object.class);
        assertEquals("with classes", result);
    }
}
