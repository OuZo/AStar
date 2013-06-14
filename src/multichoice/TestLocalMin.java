package multichoice;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Dimitri Mallis
 */
public class TestLocalMin {
    
    

    public static void main(String[] args) {

        int[] arr = {9, 9, 9, 9, 9, 9, 9, 9, 1};

        LocalMap lm = new LocalMap(arr);


        lm.print();
//        System.out.println("MIN " + lm.minPos());
//        lm.minPos();
        int x = 3;
        ArrayList<Integer> validPos = new ArrayList<>();
        if ((x > 0) && (x < 6)) {
            validPos.add(x);
            System.out.println("MPA: " + x);
        }
        System.out.println("xxxxx " + validPos.size());
        
        Random randomGenerator = new Random();
        int num = randomGenerator.nextInt(100);
        if (num % 2 == 0) {
            System.out.println("num = " + num); 
            System.out.println("EVEN");
        } else {
            System.out.println("ODD");
        }
        

    }
    
    static boolean even(int num) {
        return num % 2 == 0;
    } // even
} // TestLocalMin
