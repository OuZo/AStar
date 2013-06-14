package multichoice;

import java.util.ArrayList;

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

    }
} // TestLocalMin
