package org.example;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class MainTest {

    @Test
    public void testGenerateParenthesis_n3() {
        List<String> expected = new ArrayList<>();
        Main m = new Main();
        expected.add("((()))");
        expected.add("(()())");
        expected.add("(())()");
        expected.add("()(())");
        expected.add("()()()");

        List<String> result = m.generate(3);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testGenerateParenthesis_n2() {
        List<String> expected = new ArrayList<>();
        Main m = new Main();
        expected.add("(())");
        expected.add("()()");

        List<String> result = m.generate(2);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testGenerateParenthesis_n1() {
        List<String> expected = new ArrayList<>();
        Main m = new Main();
        expected.add("()");

        List<String> result = m.generate(1);
        Assert.assertEquals(expected, result);
    }
}
