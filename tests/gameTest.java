import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class gameTest extends game {

    private game userName;

    @Before
    public void setUp() throws Exception {
        userName = new game();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testInitGame() {
        assertEquals(0, userName.getScore());
    }

    @Test
    public void testTwoThrowsNoMark() {
        userName.throwBall(5);
        userName.throwBall(4);
        assertEquals(9, userName.getScore());
    }

    @Test
    public void testFourThrowsNoMark() {
        userName.throwBall(5);
        userName.throwBall(4);
        userName.throwBall(7);
        userName.throwBall(2);
        assertEquals(18, userName.getScore());
        assertEquals(9, userName.scoreForFrame(1));
        assertEquals(18, userName.scoreForFrame(2));
    }

    @Test
    public void testSimpleSpare() {
        userName.throwBall(3);
        userName.throwBall(7);
        userName.throwBall(3);
        assertEquals(13, userName.scoreForFrame(1));
    }

    @Test
    public void testSimpleFrameAfterSpare() {
        userName.throwBall(3);
        userName.throwBall(7);
        userName.throwBall(3);
        userName.throwBall(2);
        assertEquals(13, userName.scoreForFrame(1));
        assertEquals(18, userName.scoreForFrame(2));
        assertEquals(18, userName.getScore());
    }

    @Test
    public void testSimpleStrike() {
        userName.throwBall(10);
        userName.throwBall(3);
        userName.throwBall(6);
        assertEquals(19, userName.scoreForFrame(1));
        assertEquals(28, userName.getScore());
    }

    @Test
    public void testPerfectGame() {
        for (int i = 0; i < 12; i++) {
            userName.throwBall(10);
        }
        assertEquals(300, userName.getScore());
    }

    @Test
    public void testEndOfArray() {
        for (int i = 0; i < 9; i++) {
            userName.throwBall(0);
            userName.throwBall(0);
        }
        userName.throwBall(2);
        userName.throwBall(8);
        userName.throwBall(10);
        assertEquals(20, userName.getScore());
    }

    @Test
    public void testFailedGame() {
        for (int i = 0; i < 20; i++) {
            userName.throwBall(0);
        }
        assertEquals(0, userName.getScore());
    }

    @Test
    public void testSampleGame() {
        userName.throwBall(1);
        userName.throwBall(4);
        userName.throwBall(4);
        userName.throwBall(5);
        userName.throwBall(6);
        userName.throwBall(4);
        userName.throwBall(5);
        userName.throwBall(5);
        userName.throwBall(10);
        userName.throwBall(0);
        userName.throwBall(1);
        userName.throwBall(7);
        userName.throwBall(3);
        userName.throwBall(6);
        userName.throwBall(4);
        userName.throwBall(10);
        userName.throwBall(2);
        userName.throwBall(8);
        userName.throwBall(6);
        assertEquals(133, userName.getScore());
    }

    @Test
    public void testHeartBreak() {
        for (int i = 0; i < 11; i++) {
            userName.throwBall(10);
        }
        userName.throwBall(9);
        assertEquals(299, userName.getScore());
    }

    @Test
    public void testTenthFrameSpare() {
        for (int i = 0; i < 9; i++) {
            userName.throwBall(10);
        }
        userName.throwBall(9);
        userName.throwBall(1);
        userName.throwBall(1);
        assertEquals(270, userName.getScore());
    }

    @Test
    public void testNearPerfectButFail() {
        for (int i = 0; i < 10; i++) {
            userName.throwBall(9);
            userName.throwBall(0);
        }
        assertEquals(90, userName.getScore());
    }

    @Test
    public void testAllFive() {
        for (int i = 0; i < 21; i++) {
            userName.throwBall(5);
        }
        assertEquals(150, userName.getScore());
    }

    @Test
    public void randomTestCase1() {
        userName.throwBall(1);
        userName.throwBall(3);
        userName.throwBall(7);
        userName.throwBall(2);
        userName.throwBall(1);
        userName.throwBall(7);
        userName.throwBall(10);
        userName.throwBall(0);
        userName.throwBall(8);
        userName.throwBall(7);
        userName.throwBall(1);
        userName.throwBall(9);
        userName.throwBall(0);
        userName.throwBall(4);
        userName.throwBall(1);
        userName.throwBall(7);
        userName.throwBall(3);
        userName.throwBall(6);
        userName.throwBall(4);
        userName.throwBall(6);
        assertEquals(101, userName.getScore());
    }

    @Test
    public void randomTestCase2() {
        userName.throwBall(8);
        userName.throwBall(1);
        userName.throwBall(7);
        userName.throwBall(2);
        userName.throwBall(0);
        userName.throwBall(6);
        userName.throwBall(6);
        userName.throwBall(2);
        userName.throwBall(4);
        userName.throwBall(6);
        userName.throwBall(10);
        userName.throwBall(1);
        userName.throwBall(7);
        userName.throwBall(5);
        userName.throwBall(5);
        userName.throwBall(0);
        userName.throwBall(3);
        userName.throwBall(6);
        userName.throwBall(3);
        assertEquals(100, userName.getScore());
    }

    @Test
    public void randomTestCase3() {
        userName.throwBall(7);
        userName.throwBall(1);
        userName.throwBall(8);
        userName.throwBall(0);
        userName.throwBall(10);
        userName.throwBall(4);
        userName.throwBall(6);
        userName.throwBall(7);
        userName.throwBall(1);
        userName.throwBall(8);
        userName.throwBall(2);
        userName.throwBall(3);
        userName.throwBall(4);
        userName.throwBall(8);
        userName.throwBall(0);
        userName.throwBall(0);
        userName.throwBall(5);
        userName.throwBall(2);
        userName.throwBall(6);
        assertEquals(102, userName.getScore());
    }

    @Test
    public void randomTestCase4() {
        userName.throwBall(2);
        userName.throwBall(6);
        userName.throwBall(3);
        userName.throwBall(4);
        userName.throwBall(6);
        userName.throwBall(2);
        userName.throwBall(7);
        userName.throwBall(2);
        userName.throwBall(10);
        userName.throwBall(10);
        userName.throwBall(6);
        userName.throwBall(1);
        userName.throwBall(2);
        userName.throwBall(5);
        userName.throwBall(5);
        userName.throwBall(4);
        userName.throwBall(10);
        userName.throwBall(7);
        userName.throwBall(3);
        assertEquals(118, userName.getScore());
    }

    @Test
    public void randomTestCase5() {
        userName.throwBall(6);
        userName.throwBall(0);
        userName.throwBall(4);
        userName.throwBall(0);
        userName.throwBall(7);
        userName.throwBall(3);
        userName.throwBall(9);
        userName.throwBall(1);
        userName.throwBall(7);
        userName.throwBall(3);
        userName.throwBall(6);
        userName.throwBall(4);
        userName.throwBall(7);
        userName.throwBall(3);
        userName.throwBall(9);
        userName.throwBall(0);
        userName.throwBall(1);
        userName.throwBall(2);
        userName.throwBall(4);
        userName.throwBall(1);
        assertEquals(115, userName.getScore());
    }

    @Test
    public void randomTestCase6() {
        userName.throwBall(10);
        userName.throwBall(10);
        userName.throwBall(6);
        userName.throwBall(2);
        userName.throwBall(10);
        userName.throwBall(1);
        userName.throwBall(3);
        userName.throwBall(10);
        userName.throwBall(1);
        userName.throwBall(7);
        userName.throwBall(9);
        userName.throwBall(1);
        userName.throwBall(2);
        userName.throwBall(2);
        userName.throwBall(5);
        userName.throwBall(5);
        userName.throwBall(7);
        assertEquals(129, userName.getScore());
    }

    @Test
    public void randomTestCase7() {
        userName.throwBall(9);
        userName.throwBall(1);
        userName.throwBall(9);
        userName.throwBall(0);
        userName.throwBall(6);
        userName.throwBall(2);
        userName.throwBall(7);
        userName.throwBall(3);
        userName.throwBall(1);
        userName.throwBall(0);
        userName.throwBall(10);
        userName.throwBall(2);
        userName.throwBall(4);
        userName.throwBall(5);
        userName.throwBall(3);
        userName.throwBall(10);
        userName.throwBall(4);
        userName.throwBall(3);
        assertEquals(102, userName.getScore());
    }

    @Test
    public void randomTestCase8() {
        userName.throwBall(6);
        userName.throwBall(3);
        userName.throwBall(2);
        userName.throwBall(2);
        userName.throwBall(10);
        userName.throwBall(3);
        userName.throwBall(7);
        userName.throwBall(10);
        userName.throwBall(1);
        userName.throwBall(6);
        userName.throwBall(8);
        userName.throwBall(2);
        userName.throwBall(2);
        userName.throwBall(3);
        userName.throwBall(5);
        userName.throwBall(5);
        userName.throwBall(10);
        userName.throwBall(10);
        userName.throwBall(10);
        assertEquals(144, userName.getScore());
    }

    @Test
    public void randomTestCase9() {
        userName.throwBall(10);
        userName.throwBall(6);
        userName.throwBall(2);
        userName.throwBall(7);
        userName.throwBall(0);
        userName.throwBall(1);
        userName.throwBall(0);
        userName.throwBall(5);
        userName.throwBall(0);
        userName.throwBall(6);
        userName.throwBall(0);
        userName.throwBall(10);
        userName.throwBall(7);
        userName.throwBall(3);
        userName.throwBall(5);
        userName.throwBall(0);
        userName.throwBall(10);
        userName.throwBall(8);
        userName.throwBall(2);
        assertEquals(105, userName.getScore());
    }

    @Test
    public void randomTestCase10() {
        userName.throwBall(10);
        userName.throwBall(8);
        userName.throwBall(2);
        userName.throwBall(10);
        userName.throwBall(9);
        userName.throwBall(1);
        userName.throwBall(10);
        userName.throwBall(7);
        userName.throwBall(3);
        userName.throwBall(10);
        userName.throwBall(9);
        userName.throwBall(0);
        userName.throwBall(9);
        userName.throwBall(0);
        userName.throwBall(0);
        userName.throwBall(10);
        userName.throwBall(10);
        assertEquals(177, userName.getScore());
    }
}