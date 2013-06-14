package multichoice;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Dimitri Mallis
 */
public class LocalMap {

    int[] map = new int[9];

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
        ArrayList<Integer> validPos = new ArrayList<>();

//        for (int i = 0; i < map.length; i++) {
        for (int i = map.length - 1; i >= 0; i--) {
            if ((map[i] < min) && (map[i] > 0)) {
                min = map[i];
                pos = i;
            } // if
            if ((map[i] > 0) && (map[i] < 6)) {
                validPos.add(pos);
                System.out.println("MPA: " + map[i]);
            }
        } // for map
        System.out.println("VP: " + validPos.size());
        for (int i = 0; i < validPos.size(); i++) {
            System.out.println("Valid: " + validPos.get(i));
        } // show valid routes
        return pos;
    } // minPos
    
//    public int bestPos() {
//        int min = 6; 
//        int pos = -1;
//        
//        if ((map[0] < min) && (map[0] > 0)) {
//            pos = map[0];
//        }
//        
//        if ((map[1] < min) && (map[1] > 0)) {
//            pos = map[1];
//        }
//        
//        if ((map[2] < min) && (map[2] > 0)) {
//            pos = map[2];
//        }
//        
//        if ((map[3] < min) && (map[3] > 0)) {
//            pos = map[3];
//        }
//        
//        if ((map[4] < min) && (map[4] > 0)) {
//            pos = map[4];
//        }
//        
//        if ((map[5] < min) && (map[5] > 0)) {
//            pos = map[5];
//        }
//        
//        if ((map[6] < min) && (map[6] > 0)) {
//            pos = map[6];
//        }
//        
//        if ((map[7] < min) && (map[7] > 0)) {
//            pos = map[7];
//        }
//        
//        if ((map[8] < min) && (map[8] > 0)) {
//            pos = map[8];
//        }
//        
//        return pos;
//    } // bestPos
    
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
