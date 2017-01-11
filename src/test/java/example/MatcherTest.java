package example;

import static org.hamcrest.Matchers.contains;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import org.junit.Test;

public class MatcherTest {

    @SafeVarargs
    final Matcher<? super Iterable<? extends String>> listMatcher(final Matcher<? super String>... stringmatchers) {
        return contains(stringmatchers);
    }

    @Test
    public void testNormalVarargsCall() {
        final Matcher<? super Iterable<? extends String>> matcher = contains(stringMatcher(), stringMatcher());
        System.out.println(matcher);
        assertThat(makeList(), matcher);
    }

    @Test
    public void testIndirectVarargsCall() {
        final Matcher<? super Iterable<? extends String>> matcher = listMatcher(stringMatcher(), stringMatcher());
        System.out.println(matcher);
        assertThat(makeList(), matcher);
    }

    @Test
    public void testCompareResults() {
        final Matcher<? super Iterable<? extends String>> matcherIndirect = listMatcher(stringMatcher(),
                stringMatcher());
        final Matcher<? super Iterable<? extends String>> matcherDirect = contains(stringMatcher(), stringMatcher());

        assertEquals(matcherDirect.toString(), matcherIndirect.toString());
    }

    private Iterable<? extends String> makeList() {
        return Arrays.asList("example entry 1", "example entry 2");
    }

    private Matcher<String> stringMatcher() {
        return Matchers.startsWith("example");
    }

}
