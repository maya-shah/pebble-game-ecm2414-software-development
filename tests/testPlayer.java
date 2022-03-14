import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import java.util.ArrayList;
import java.util.Arrays;


import static org.junit.Assert.*;


public class testPlayer {
    Player p = new Player("test");
    ArrayList<Integer> playerPebbles = new ArrayList<>(Arrays.asList(3, 1));


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getPebblesTest() {
        System.out.println(" getPebbles ");
        p.pebbleAdd(1);
        p.pebbleAdd(3);
        assertEquals(p.getPebbles().size(), playerPebbles.size());
    }

    @Test
    public void pebbleAdd() {
        System.out.println(" pebbleAdd ");
        p.pebbleAdd(1);
        assertEquals("Test failed.", 1, p.pebbleNumber());
    }

    @Test
    public void pebbleDiscard() {
        System.out.println(" pebbleDiscard ");
        p.pebbleAdd(1);
        Player.pebbleDiscard(p);
        assertEquals("Test failed.", 0, p.getPebbles().size());
    }

    @Test
    public void pebbleNumber() {
        System.out.println(" pebbleNumber ");
        p.pebbleAdd(1);
        p.pebbleAdd(2);
        assertEquals("Test failed.",playerPebbles.size(), p.getPebbles().size());
    }

    @Test
    public void playerTotal() {
        System.out.println(" playerTotal ");
        p.pebbleAdd(1);
        p.pebbleAdd(2);
        assertEquals(3,p.playerTotal());

    }

}

