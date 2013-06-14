package multichoice;

/**
 *
 * @author Dimitri Mallis
 */
public class Multichoice {

    public static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > 0) {
                    System.out.print("|" + arr[i][j]);
                } else {
                    System.out.print("| ");
                }
            } // j
            System.out.println("|");
        } // i
    } // print

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ReadWrite rw = new ReadWrite();
        int[][] arr = rw.read("large_map.txt");
        print(arr);


        TraverseAStar tas = new TraverseAStar(arr);
        boolean finished = false;
        while (!finished) {
            tas.solve();
//            print(arr);
        } // while not finished solve



    } // main
} // Multichoice
