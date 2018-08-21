public class game{

    private int[][] frame; // 0-1 = roll score, 2 = sum score
    private int[] mode;
    private int[] frameScore;
    private int currentFrame;
    private int roll;

    public game(){
        initGame();
    }

    private void initGame(){
        frame = new int[10][3];
        mode = new int[10];
        frameScore = new int[10];
        currentFrame = 0;
        roll = 0;
    }

    public void debug(){
        System.out.println("========= DEBUG LOG =========");
        System.out.println("Frame");
        for(int i = 0;i < 10;i++){
            System.out.print("[");
            int temporary = 2;
            if(i == 9){
                temporary = 3;
            }
            for(int j = 0; j < temporary;j++){
                System.out.print(frame[i][j]);
                if(j != temporary-1){
                    System.out.print(",");
                }
            }
            System.out.print("] ");
        }
        System.out.println("\nframeScore");
        for(int i = 0; i < 10;i++){
            System.out.print("[");
            System.out.print(frameScore[i]);
            System.out.print("] ");
        }
        System.out.println("\nMode");
        for(int i = 0; i < 10;i++){
            System.out.print("[");
            System.out.print(mode[i]);
            System.out.print("] ");
        }
        System.out.print("\ncurrentFrame: ");
        System.out.println(currentFrame);
        System.out.print("roll: ");
        System.out.println(roll);
        System.out.println("========== END LOG ==========");
    }

    public void throwBall(int score){
        addExtraScore(score);
        if(isLastFrame()){
            LastFrameThrow(score);
        }
        else{
            otherFrameThrow(score);
        }
    }

    private boolean isLastFrame(){
        return (currentFrame == 9);
    }

    public int getCurrentFrame() {
        return (currentFrame+1);
    }

    private void LastFrameThrow(int score){
        if(roll < 2 && roll >= 0){
            frame[currentFrame][roll] = score;
            frameScore[currentFrame] += score;
            mode[currentFrame] = 0;
            roll += 1;
        }
        else if(roll == 2 && frameScore[currentFrame] >= 10){
            frame[currentFrame][roll] = score;
            frameScore[currentFrame] += score;
            mode[currentFrame] = 0;
            roll++;
        }
        else if(roll == 2 && frameScore[currentFrame] < 10){
            mode[currentFrame] = 0;
        }
        else{
            System.out.println("ERROR");
        }
    }

    private void otherFrameThrow(int score){
        frame[currentFrame][roll] = score;
        frameScore[currentFrame] += score;
        if(isStrike(score)){
            mode[currentFrame] = 2;
            nextFrame();
        }
        else if(isSpare(score)){
            mode[currentFrame] = 1;
            nextFrame();
        }
        else {
            mode[currentFrame] = 0;
            if(roll == 1){
                nextFrame();
            }
            else{
                nextRoll();
            }
        }
    }

    private void nextFrame(){
        currentFrame++;
        roll = 0;
    }

    private void nextRoll(){
        roll++;
    }
    
    private boolean isStrike(int score){
        return (score == 10 && this.roll == 0);
    }

    private boolean isSpare(int score){
        return (score == 10 && this.roll == 0);
    }

    public int getScore(){
        int score = 0;
        for(int i = 0;i <= currentFrame;i++){
            if(mode[i] == 0){
                score += frameScore[i];
            }
        }
        return score;
    }

    public int scoreForFrame(int nFrame){
        nFrame--;
        int score = 0;
        for(int i = 0;i <= nFrame;i++){
            if(mode[i] == 0){
                score += frameScore[i];
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
                frameScore[temporary] += score;
                mode[temporary]--;
            }
        }
    }

    private void backOne(int score){
        int temporary = currentFrame-1;
        if(temporary >= 0){
            if(mode[temporary] > 0){
                frameScore[temporary] += score;
                mode[temporary]--;
            }
        }
    }
}