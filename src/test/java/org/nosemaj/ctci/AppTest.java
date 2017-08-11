package org.nosemaj.ctci;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private final ByteArrayOutputStream stdoutStream = new ByteArrayOutputStream();
    private final ByteArrayOutputStream stderrStream = new ByteArrayOutputStream();

    /**
     * Route stdout and stderr to stream so we can verify what is
     * written to them.
     */
    @Before
    public void setup() {
        System.setOut(new PrintStream(stdoutStream));
        System.setErr(new PrintStream(stderrStream));
    }

    /**
     * Undo the routing of stdout and stderr.
     */
    @After
    public void cleanup() {
        System.setOut(null);
        System.setErr(null);
    }

    /**
     * Test instantiation of App.
     */
    @Test
    public void testAppConstructor() {
        Assert.assertNotNull(new App());
    }

    /**
     * Ensure that main writes to stdout, when arguments are passed.
     */
    @Test
    public void testMainHelpArgument() {
        App.main(new String[] { RandomString.string() });
        assertHelloWorldIsPrinted();
    }

    /**
     * Asserts that hello world is printed to stdout.
     * @throws AssertionError if hello world is not printed
     */
    private void assertHelloWorldIsPrinted() {
        String expectedOutput = "Hello World!\n";
        String actualOutput = stdoutStream.toString();
        Assert.assertEquals(expectedOutput, actualOutput);
    }
}
