public class game{

    private int[][] frame; // 0-1 = roll score, 2 = sum score
    private int[] mode;
    private int currentFrame;
    private int roll;

    public game(){
        resetGame();
    }

    public void resetGame(){
        frame = new int[10][3];
        mode = new int[10];
        currentFrame = 0;
        roll = 0;
    }

    public void debug(){
        System.out.println(frame);
        System.out.println(mode);
    }

    public void throwBall(int score){
        addExtraScore(score);
//        System.out.println(currentFrame);
        if(currentFrame == 9){
            throwBall10(score);
        }
        else if(currentFrame < 9 && currentFrame >= 0){
            throwBall9(score);
        }
    }

    public int getCurrentFrame() {
        return currentFrame+1;
    }

    private void throwBall10(int score){
        if(roll < 2 && roll >= 0){
            frame[currentFrame][roll] = score;
            frame[currentFrame][2] += score;
            mode[currentFrame] = 0;
            roll += 1;
        }
        else if(roll == 2 && frame[currentFrame][2] >= 10){
            frame[currentFrame][2] += score;
            mode[currentFrame] = 0;
            roll++;
        }
        else if(roll == 2 && frame[currentFrame][2] < 10){
            mode[currentFrame] = 0;
        }
        else{
            System.out.println("ERROR");
        }
    }

    private void throwBall9(int score){
        if(score == 10 && roll == 0){ //strike
            frame[currentFrame][roll] = score;
            frame[currentFrame][2] = score;
            mode[currentFrame] = 2;
            currentFrame ++;
        }
        else if(roll == 0){
            frame[currentFrame][roll] = score;
            frame[currentFrame][2] = score;
            mode[currentFrame] = 0;
            roll++;
        }
        else if(roll == 1){
            frame[currentFrame][roll] = score;
            frame[currentFrame][2] += score;
            if(frame[currentFrame][2] == 10){
                mode[currentFrame] = 1;
            }
            else {
                mode[currentFrame] = 0;
            }
            roll = 0;
            currentFrame++;
        }

    }

    public int getScore(){
        int score = 0;
        for(int i = 0;i <= currentFrame;i++){
            if(mode[i] == 0){
                score += frame[i][2];
            }
        }
        return score;
    }

    public int scoreForFrame(int nFrame){
        nFrame--;
        int score = 0;
        for(int i = 0;i <= nFrame;i++){
            if(mode[i] == 0){
                score += frame[i][2];
            }
        }
        return score;
    }

    private void addExtraScore(int score){
        backOne(score);
        backTwo(score);
    }

    private void backTwo(int score){
        int temporary = currentFrame-2;
        if(temporary >= 0){
            if(mode[temporary] == 1){
                frame[temporary][2] += score;
                mode[temporary]--;
            }
        }
    }

    private void backOne(int score){
        int temporary = currentFrame-1;
        if(temporary >= 0){
            if(mode[temporary] > 0){
                frame[temporary][2] += score;
                mode[temporary]--;
            }
        }
    }
}
//public class game {
//    private int currentFrame = 0; // index follow by computer
//    private int currentThrow = 0;
//    private int currentScore = 0;
//    private int sumScore = 0;
//    private static int maxPin = 10;
//    private int[][] gameScore;
//    private char[] gameMode;//0 = not throw, / = spare, X = strike, n = normal
//    private boolean[][] ExtraScore;
//
//    public void resetGame(){
//        currentFrame = 0;
//        currentThrow = 0;
//        currentScore = 0;
//        sumScore = 0;
//        gameScore = new int[10][2];
//        gameMode = new char[10];
//        ExtraScore = new boolean[100][100];
//    }
//    public void throwBall(int score){
//        if(isValidThrow(score)) {
//            if(isStrike(score)){
//                gameMode[currentFrame] = 'X';
//                gameScore[currentFrame][0] = maxPin;
//                gameScore[currentFrame][1] = -1;
//                calculateExtraScore();
//                currentFrame += 1;
//            }
//            else if(currentThrow == 0){
//                gameScore[currentFrame][currentThrow] = score;
//                currentThrow += 1;
//            }
//            else {
//                if (isSpare(score)) {
//                    gameMode[currentFrame] = '/';
//                } else {
//                    gameMode[currentFrame] = 'n';
//                }
//                gameScore[currentFrame][currentThrow] = score;
//                calculateExtraScore();
//                currentFrame += 1;
//                currentThrow = 0;
//            }
//        }
//    }
//    private void calculateExtraScore(){
//
//    }
//    private boolean isStrike(int score){
//        return (score == maxPin && currentThrow == 0);
//    }
//    private boolean isSpare(int score){
//        return (currentScore + score == maxPin && currentThrow == 1);
//    }
//    private boolean isValidThrow(int score){
//        return ((score >= 0 && score <= maxPin) && currentFrame <= 9);
//    }
//
//}
