import java.util.Arrays;
import java.util.ArrayList;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

public class testBag {

    ArrayList<Integer> pebbles = new ArrayList<>(Arrays.asList(1, 2, 5, 7, 8));
    public Bag blackBag = new Bag("blackBag", pebbles, 2);
    public Bag whiteBag = new Bag("whiteBag");
    ArrayList<Integer> testList = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getPebblesTest() {
        System.out.println(" getPebblesTest ");
        assertEquals(blackBag.bagSize(), blackBag.getPebbles().size());
    }


    @Test
    public void getName() {
        System.out.println(" getName ");
        assertTrue(blackBag.getName() == "blackBag");
    }

    @Test
    public void drawPebbleTest() {
        System.out.println(" drawPebble ");
        ArrayList<Integer> blackPebble = blackBag.getPebbles();
        int blackPebbleSize = blackBag.bagSize();
        int drawnPebble = Bag.drawPebble(blackBag);
        ArrayList<Integer> blackPebble2 = blackBag.getPebbles();
        assertNotSame("Test failed.", blackPebble2.size(), blackPebbleSize);
    }

    @Test
    public void discardPebbleTest() {
        System.out.println(" discardPebble ");
        testList.add(3);
        whiteBag.discardPebble(3);
        assertEquals("Test failed.", whiteBag.getPebbles(), testList);
    }

    @Test
    public void bagSizeTest() {
        System.out.println(" bagSize ");
        assertEquals(blackBag.bagSize(), blackBag.getPebbles().size());
    }

    @Test
    public void bagRefillTest() {
        System.out.println(" bagRefill ");
        Bag blackBag2 = new Bag("whiteBag2", pebbles, 2);
        Bag whiteBag2 = new Bag("blackBag2");
        Bag.bagRefill(whiteBag2, blackBag2);
        assertEquals("Test failed.", 0, whiteBag2.bagSize());
        assertEquals("Test failed.", 40, blackBag2.bagSize());

    }
}
