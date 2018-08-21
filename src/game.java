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
        this.frame = new int[10][3];
        this.mode = new int[10];
        this.frameScore = new int[10];
        this.currentFrame = 0;
        this.roll = 0;
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
                System.out.print(this.frame[i][j]);
                if(j != temporary-1){
                    System.out.print(",");
                }
            }
            System.out.print("] ");
        }
        System.out.println("\nframeScore");
        for(int i = 0; i < 10;i++){
            System.out.print("[");
            System.out.print(this.frameScore[i]);
            System.out.print("] ");
        }
        System.out.println("\nMode");
        for(int i = 0; i < 10;i++){
            System.out.print("[");
            System.out.print(this.mode[i]);
            System.out.print("] ");
        }
        System.out.print("\ncurrentFrame: ");
        System.out.println(this.currentFrame);
        System.out.print("roll: ");
        System.out.println(this.roll);
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
        return (this.currentFrame == 9);
    }

    public int getCurrentFrame() {
        return (this.currentFrame+1);
    }

    private void lastFrameThrow(int score){
        if(this.roll < 2 ||(this.roll == 2 && this.frameScore[currentFrame] >= 10)){
            saveScore(score);
            nextRoll();
        }
        else{
            System.out.println("GAME IS ALREADY END!!!");
        }
    }

    private void otherFrameThrow(int score){
        saveScore(score);
        if(this.roll == 0 && score != 10){
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

    private void saveScore(int score){
        this.frame[currentFrame][roll] = score;
        this.frameScore[currentFrame] += score;
    }

    private void nextFrame(){
        this.currentFrame++;
        this.roll = 0;
    }

    private void nextRoll(){
        this.roll++;
    }

    private boolean isStrike(int score){
        return (score == 10 && this.roll == 0);
    }

    private boolean isSpare(int score){
        return (score == 10 && this.roll == 1);
    }

    public int getScore(){
        int score = 0;
        for(int i = 0;i <= this.currentFrame;i++){
            if(this.mode[i] == 0){
                score += this.frameScore[i];
            }
        }
        return score;
    }

    public int scoreForFrame(int frame){
        frame--;
        int sumScore = 0;
        for(int i = 0;i <= frame;i++){
            if(this.mode[i] == 0){
                sumScore += this.frameScore[i];
            }
        }
        return sumScore;
    }

    private void addExtraScore(int score){
        addExtraFrameScore(this.currentFrame-1,score);
        addExtraFrameScore(this.currentFrame-2,score);
    }

    private void addExtraFrameScore(int frame,int score){
        if(frame >= 0){
            if(this.mode[frame] > 0){
                this.frameScore[frame] += score;
                this.mode[frame]--;
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