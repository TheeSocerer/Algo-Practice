package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MainTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

//    @AfterEach
//    public void tearDown() {
//        System.setOut(standardOut);
//        System.setIn(standardIn);
//    }
    @Test
    public void TestGenerateParanthesis(){
        Main.main(new String[]{"3"});
        String actual = outputStreamCaptor.toString().trim();

        Assert.assertEquals(actual,"Let's backtrack\nThe output of the generateParanthesis is : [((())), (()()), (())(), ()(()), ()()()]");
    }

}
