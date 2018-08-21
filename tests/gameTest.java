import org.junit.Test;

import static org.junit.Assert.*;

public class gameTest extends game{

    @Test
    public void throwBall() {
        game bowling = new game();
        assertEquals(0,bowling.getScore());

        bowling.throwBall(5);
        assertEquals(5,bowling.getScore());

        bowling.throwBall(4);
        assertEquals(9,bowling.getScore());

        bowling.throwBall(7);
        bowling.throwBall(2);
        assertEquals(18,bowling.getScore());
        assertEquals(9,bowling.scoreForFrame(1));
        assertEquals(18,bowling.scoreForFrame(2));
        assertEquals(3,bowling.getCurrentFrame());

        bowling = new game();
        for(int i = 0; i < 11;i++){
            bowling.throwBall(10);
        }
        bowling.throwBall(9);
        assertEquals(299,bowling.getScore());

        bowling = new game();
        for(int i = 0; i < 9;i++){
            bowling.throwBall(10);
        }
        bowling.throwBall(9);
        bowling.throwBall(1);
        bowling.throwBall(1);
        assertEquals(270,bowling.getScore());


    }

//    @Test
//    public void throwBall() {
//        assertEquals(0,bowling.getScore());
//        bowling.throwBall(10); //0
//        assertEquals(0,bowling.getScore());
//        bowling.throwBall(10); //0
//        bowling.throwBall(5); //25
//        bowling.throwBall(4); //53
//        assertEquals(53,bowling.getScore());
//        bowling.throwBall(0); //53
//        bowling.throwBall(10); //53
//        assertEquals(53,bowling.getScore());
//        bowling.throwBall(6); //75
//        assertEquals(75,bowling.getScore());
//        bowling.throwBall(1); //76
//        assertEquals(76,bowling.getScore());
//        bowling.resetGame();
////        bowling.debug();
//        assertEquals(0,bowling.getScore());
////        bowling.debug();
//        for(int i = 1; i < 13; i++){
//            System.out.println(bowling.currentFrame);
//            bowling.throwBall(10);
//        }
//        assertEquals(300,bowling.getScore());
//
//    }

//    @Test
//    public void getScore() {
//    }
}