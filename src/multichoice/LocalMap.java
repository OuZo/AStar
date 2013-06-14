package multichoice;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Dimitri Mallis
 */
public class LocalMap {

    int[] map = new int[9];
    Random randomGenerator = new Random();

    public LocalMap() {
        for (int i = 0; i < map.length; i++) {
            map[i] = 99;
        } // for 
    } // LocalMap

    public LocalMap(int[] arr) {
        map = arr;
    } // LocalMap

    public void clear() {
        for (int i = 0; i < map.length; i++) {
            map[i] = 99;
        } // for 
    } // clear

    public void assignPos(int p, int val) {
        map[p] = val;
    } // assignPos

    public int minPos() {
        int min = 6; // 999;
        int pos = -1;
        ArrayList<PosVal> validPos = new ArrayList<>();

//        for (int i = 0; i < map.length; i++) {
        for (int i = map.length - 1; i >= 0; i--) {

            if ((map[i] < min) && (map[i] > 0)) {
                min = map[i];
                pos = i;
            } // if

            if (even(randomGenerator.nextInt(100))) {
                if ((map[i] > 0) && (map[i] < 6)) {
                    validPos.add(new PosVal(i, map[i]));
                }
            }

        } // for map
//        System.out.println("VP: " + validPos.size());
        if (validPos.size() > 0) {
            if (even(randomGenerator.nextInt(100))) {
                System.out.println("Won coin toss, choosing random good position to move to...");
                System.out.println("Previous POS = " + pos);
                pos = validPos.get(randomGenerator.nextInt(validPos.size())).getPos();
                System.out.println("New POS = " + pos);
            } // coin toss
            else {
                System.out.println("Lost coin toss, going with first best pos in best direction of goal");
            }
        }
//        for (int i = 0; i < validPos.size(); i++) {
//            System.out.println("Valid: " + validPos.get(i));
//        } // show valid routes
        return pos;
    } // minPos

    boolean even(int num) {
        return ((num % 2) == 0);
    } // even

    public void print() {
        for (int i = 0; i < map.length; i++) {
            System.out.print(map[i] + " ");
        } // for 
    } // print

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < map.length; i++) {
            sb.append(map[i]).append(" ");
//            System.out.print(map[i] + " ");
        } // for
        return sb.toString();
    } // toString
} // LocalMap
