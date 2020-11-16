package hw4.tests;

import exceptions.EmptyException;
import exceptions.ExampleException;
import hw4.Deque226;
import hw4.FlawedDeque226;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertFalse;

public class FlawedDeque226Test {

    // The unit being tested
    private Deque226<String> stringDequeue;
    private String s1 = "s 1";
    private String s2 = "s 2";
    private String s3 = "s 3";

    @Before
    public void setupDequeue() {
        this.stringDequeue = new FlawedDeque226<String>();
    }

    @Test(expected = ExampleException.class)
    public void exampleTest() {
        throw new ExampleException();
    }

    @Test
    public void startsEmptyTest() {
        assertTrue(stringDequeue.empty());
        assertEquals(0, stringDequeue.length());
    }

    @Test(expected = EmptyException.class)
    public void emptyFrontTest() {
        stringDequeue.front();
    }

    @Test(expected = EmptyException.class)
    public void emptyBackTest() {
        stringDequeue.back();
    }


    @Test
    public void insertFrontTest() {
        stringDequeue.insertFront("1");
        stringDequeue.insertFront("2");
        stringDequeue.insertFront("3");
        stringDequeue.insertFront("4");
        stringDequeue.insertFront("5");
        stringDequeue.insertFront("6");
        stringDequeue.insertFront("7");
        assertEquals("[7, 6, 5, 4, 3, 2, 1]", stringDequeue.toString());
    }

    @Test
    public void insertBackTest() {
        stringDequeue.insertBack("1");
        stringDequeue.insertBack("2");
        stringDequeue.insertBack("3");
        stringDequeue.insertBack("4");
        stringDequeue.insertBack("5");
        stringDequeue.insertBack("6");
        stringDequeue.insertBack("7");
        assertEquals("[1, 2, 3, 4, 5, 6, 7]", stringDequeue.toString());
    } 

    @Test
    public void insertThenRemoveFrontTest() {
        stringDequeue.insertFront(s1);
        stringDequeue.insertFront(s2);

        assertFalse(stringDequeue.empty());
        assertEquals(s2, stringDequeue.front());
        assertEquals(s1, stringDequeue.back());

        stringDequeue.removeFront();

        assertEquals(s1, stringDequeue.front());

        stringDequeue.removeFront();

        assertTrue(stringDequeue.empty());
    }

    @Test
    public void insertThenRemoveBackTest() {
        stringDequeue.insertBack(s1);
        stringDequeue.insertBack(s2);

        assertFalse(stringDequeue.empty());
        assertEquals(s2, stringDequeue.back());
        assertEquals(s1, stringDequeue.front());

        stringDequeue.removeBack();

        assertEquals(s1, stringDequeue.back());
        assertEquals(s1, stringDequeue.front());

        stringDequeue.removeBack();

        assertTrue(stringDequeue.empty());
    }


    @Test
    public void insertFrontRemoveBackTest() {
        stringDequeue.insertFront(s1);
        stringDequeue.insertFront(s2);

        assertEquals(s2, stringDequeue.front());
        assertEquals(s1, stringDequeue.back());

        stringDequeue.removeBack();

        assertEquals(s2, stringDequeue.front());
        assertEquals(s2, stringDequeue.back());

        stringDequeue.removeBack();

        assertTrue(stringDequeue.empty());
    }

    @Test
    public void insertBackRemoveFrontTest() {
        stringDequeue.insertBack(s3);

        assertEquals(s3, stringDequeue.back());
        assertEquals(s3, stringDequeue.front());

        stringDequeue.removeFront();

        assertTrue(stringDequeue.empty());
    }

    @Test(expected = EmptyException.class)
    public void removeFrontWhenEmptyTest() {
        assertTrue(stringDequeue.empty());
        stringDequeue.removeFront();
    } 

    @Test(expected = EmptyException.class)
    public void removeBackWhenEmptyTest() {
        assertTrue(stringDequeue.empty());
        stringDequeue.removeBack();
    } 


}
