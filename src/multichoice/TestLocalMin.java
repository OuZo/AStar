package multichoice;

/**
 *
 * @author Dimitri Mallis
 */
public class TestLocalMin {

    public static void main(String[] args) {

        int[] arr = {9,9,9,9,9,9,9,9,1};
        
        LocalMap lm = new LocalMap(arr);

        
        lm.print();
        System.out.println("MIN " + lm.minPos());
//        lm.minPos();

    }
} // TestLocalMin
