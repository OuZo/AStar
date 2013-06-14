package multichoice;

/**
 *
 * @author Dimitri Mallis
 */
public class TraverseAStar {

    int[][] map = null;
    public LocalMap lm = new LocalMap();
    int currentX = 0; 
    int currentY = 0; 
    static final int UP_LEFT = 0;
    static final int UP = 1;
    static final int UP_RIGHT = 2;
    static final int LEFT = 3;
    // skip 4
    static final int RIGHT = 5;
    static final int DOWN_LEFT = 6;
    static final int DOWN = 7;
    static final int DOWN_RIGHT = 8;

    public TraverseAStar(int[][] map) {
        this.map = map;
    } // TraverseAStar

    public boolean inBounds(int col, int row) {
        boolean ret = true;
        try {
            int val = map[col][row];
        } catch (ArrayIndexOutOfBoundsException aiobe) {
//            System.err.println("Out of bounds: [" + col + "][" + row + "]");
            ret = false;
        } catch (Exception e) {
//            System.err.println("Error!");
            ret = false;
        }
        return ret;
    } // inBounds

    public int getVal(int col, int row) {
        return map[col][row];
    } // getVal

    public int right(int myX) {
        return myX + 1;
    } // right

    public int left(int myX) {
        return myX - 1;
    } // left

    public int down(int myY) {
        return myY + 1;
    } // down

    public int up(int myY) {
        return myY - 1;
    }

    public int[] rightDown(int myX, int myY) {
        int[] ret = new int[2];
        ret[0] = right(myX);
        ret[1] = down(myY);
        return ret;
    } // rightDown

    public int[] leftDown(int myX, int myY) {
        int[] ret = new int[2];
        ret[0] = left(myX);
        ret[1] = down(myY);
        return ret;
    } // leftDown

    public int[] rightUp(int myX, int myY) {
        int[] ret = new int[2];
        ret[0] = right(myX);
        ret[1] = up(myY);
        return ret;
    } // rightUp

    public int[] leftUp(int myX, int myY) {
        int[] ret = new int[2];
        ret[0] = left(myX);
        ret[1] = up(myY);
        return ret;
    } // rightUp

    public void look(int myX, int myY) {
        System.out.println(inBounds(myX, myY));
    } // look

    public void move(int min) {
        switch (min) {
            case UP_LEFT:
                System.out.println("UP_LEFT");
                shift();
                map[currentY -= 1][currentX -= 1] = 8;
                break;
            case UP:
                System.out.println("UP");
                shift();
                map[currentY -= 1][currentX] = 8;
                break;
            case UP_RIGHT:
                System.out.println("UP_RIGHT");
                shift();
                map[currentY -= 1][currentX += 1] = 8;
                break;
            case LEFT:
                System.out.println("LEFT");
                shift();
                map[currentY][currentX -= 1] = 8;
                break;
            case RIGHT:
                System.out.println("RIGHT");
                shift();
                map[currentY][currentX += 1] = 8;
                break;
            case DOWN_LEFT:
                System.out.println("DOWN_LEFT");
                shift();
                map[currentY += 1][currentX -= 1] = 8;
                break;
            case DOWN:
                System.out.println("DOWN");
                shift();
                map[currentY += 1][currentX] = 8;
                break;
            case DOWN_RIGHT:
                System.out.println("DOWN_RIGHT");
                shift();
                map[currentY += 1][currentX += 1] = 8;
                break;
        } // switch 
    } // move

    public void shift() {
        map[currentY][currentX] = 7;
    } // shift

    public boolean solve() {
        boolean ret = false;

        if (map[currentY][currentX] == 9) {
            ret = true;
        } // game over

        // SEARCH LOCAL

        lm.clear();
//        lm.print();
        
        // UP LEFT
        int[] t2 = leftUp(currentX, currentY);
        if (inBounds(t2[0], t2[1])) {
            System.out.println("UP LEFT value = " + getVal(t2[1], t2[0]));
            lm.assignPos(UP_LEFT, getVal(t2[1], t2[0]));
        } // if valid

        // UP
        if (inBounds(currentX, up(currentY))) {
            System.out.println("UP value = " + getVal(up(currentY), currentX));
            lm.assignPos(UP, getVal(up(currentY), currentX));
        } // if valid

        // UP RIGHT
        t2 = rightUp(currentX, currentY);
        if (inBounds(t2[0], t2[1])) {
            System.out.println("UP RIGHT value = " + getVal(t2[1], t2[0]));
            lm.assignPos(UP_RIGHT, getVal(t2[1], t2[0]));
        } // if valid

        // LEFT
        if (inBounds(left(currentX), currentY)) {
            System.out.println("LEFT value = " + getVal(currentY,left(currentX)));
            lm.assignPos(LEFT, getVal(currentY,left(currentX)));
        } // if valid

        // RIGHT
        if (inBounds(right(currentX), currentY)) {
            System.out.println("RIGHT value = " + getVal(currentY,right(currentX)));
            lm.assignPos(RIGHT, getVal(currentY,right(currentX)));
        } // if valid

        // DOWN LEFT 
        t2 = leftDown(currentX, currentY);
//        t2 = leftDown(currentY,currentX);
//        System.out.println("T2_X = " + t2[0] + " T2_Y = " + t2[1]);
        if (inBounds(t2[0], t2[1])) {
//            System.out.println("DOWN LEFT value = " + getVal(t2[1], t2[0]));
            lm.assignPos(DOWN_LEFT, getVal(t2[1], t2[0]));
        } // if valid

        // DOWN
        if (inBounds(currentX, down(currentY))) {
//            System.out.println("DOWN value = " + getVal(currentX, down(currentY)));
            System.out.println("DOWN value = " + getVal(down(currentY), currentX));
            lm.assignPos(DOWN, getVal(down(currentY), currentX));
        } // if valid

        // DOWN RIGHT
        t2 = rightDown(currentX, currentY);
        if (inBounds(t2[0], t2[1])) {
//            System.out.println("DOWN RIGHT value = " + getVal(t2[0], t2[1]));
            System.out.println("DOWN RIGHT value = " + getVal(t2[1], t2[0]));
            lm.assignPos(DOWN_RIGHT, getVal(t2[1], t2[0]));
        } // if valid

//        lm.print();
        System.out.println("");

        System.out.println("MIN POS = " + lm.minPos() + " [" + lm.toString() + "]");
        move(lm.minPos());
        
//        System.out.println("MIN POS = " + lm.bestPos() + " [" + lm.toString() + "]");
//        move(lm.bestPos());
        
//        look(currentX,currentY);
//        
//        look(right(currentX),currentY);
//        look(left(currentX),currentY);
//        look(currentX,up(currentY));
//        look(currentX,down(currentY));
//        
//        int[] temp = rightDown(currentX,currentY);
//        look(temp[0],temp[1]);
//        temp = leftDown(currentX,currentY);
//        look(temp[0],temp[1]);
//        temp = rightUp(currentX,currentY);
//        look(temp[0],temp[1]);
//        temp = leftUp(currentX,currentY);
//        look(temp[0],temp[1]);

        return ret;

    } // solve
} // TraverseAStar
