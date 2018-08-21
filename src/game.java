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
            lastFrameThrow(score);
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

    private void lastFrameThrow(int score){
        if(roll < 2 ||(roll == 2 && frameScore[currentFrame] >= 10)){
            frame[currentFrame][roll] = score;
            frameScore[currentFrame] += score;
            nextRoll();
        }
        else{
            System.out.println("GAME IS ALREADY END!!!");
        }
    }

    private void otherFrameThrow(int score){
        frame[currentFrame][roll] = score;
        frameScore[currentFrame] += score;
        if(roll == 0 && score != 10){
            nextRoll();
        }
        else {
            if(isStrike(score)){
                setMode('X');
            }
            else if(isSpare(score)){
                setMode('/');
            }
            nextFrame();
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
        return (score == 10 && this.roll == 1);
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
        addExtraFrameScore(currentFrame-1,score);
        addExtraFrameScore(currentFrame-2,score);
    }

    private void addExtraFrameScore(int frame,int score){
        if(frame >= 0){
            if(mode[frame] > 0){
                frameScore[frame] += score;
                mode[frame]--;
            }
        }
    }

    private void setMode(char mode){
        if(mode == 'X'){
            this.mode[currentFrame] = 2;
        }
        else if(mode == '/'){
            this.mode[currentFrame] = 1;
        }
    }
}