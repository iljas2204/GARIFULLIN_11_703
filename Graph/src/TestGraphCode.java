import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class TestGraphCode {
    private GraphCode graphCode;
    @Before
    public void init() { graphCode = new GraphCode();}
    @After
    public void tearDown() {graphCode = null;}
    @Test
    public void test1(){
        graphCode.insert(1,2);
        graphCode.delete(1,2);
        assertTrue(graphCode.getTail() == null);
        assertTrue(graphCode.getHead() == null);
    }
    @Test
    public void test2(){
        graphCode.insert(1,1);
        assertFalse(graphCode.getHead() == null);
        assertFalse(graphCode.getTail() == null);
    }
    @Test
    public void test3(){
        graphCode.insert(1,2);
        assertTrue(graphCode.getTail() == graphCode.getHead());
    }
    @Test
    public void test4(){
        graphCode.insert(1,2);
        graphCode.insert(1,2);
        assertFalse(graphCode.getTail() == graphCode.getHead());
    }
    @Test
    public void test5(){
        graphCode.insert(1,2);
        assertEquals(2,graphCode.getMI()[0].length);
        assertEquals(1,graphCode.getMI().length);
        assertEquals(1,graphCode.getMI()[0][1]);
        assertEquals(1, graphCode.getMI()[0][0]);
    }

    protected final ByteArrayOutputStream output = new ByteArrayOutputStream();
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void test6(){
        graphCode.GraphCode(new int[][]{{1, 0, 1},{0,1,0}});
        assertEquals(3,graphCode.getMI()[0].length);
        assertEquals(2,graphCode.getMI().length);
        graphCode.delete(2,2);
        assertEquals(1,graphCode.getMI().length);
        output.reset();
        graphCode.GraphCode(1);
        assertEquals("(1,3)", output.toString());
    }
    @Test
    public void test7() {
        graphCode.insert(1,2);
        graphCode.insert(1,1);
        graphCode.modify(1);
        assertTrue(graphCode.getTail() == null);
        assertTrue(graphCode.getHead() == null);
    }
}
