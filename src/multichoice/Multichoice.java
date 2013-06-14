package multichoice;

/**
 *
 * @author Dimitri Mallis
 */
public class Multichoice {

    public static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if ((arr[i][j] > 0) && (arr[i][j] != 5)) {
                    System.out.print("|" + arr[i][j]);
                } else if ((arr[i][j] > 0) && (arr[i][j] == 5)) {
                    System.out.print("|#");
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
//        boolean finished = false;
        int moves = 0;
        while (!tas.isFinished()) {
            tas.solve();
            print(arr); 
            moves++;
        } // while not finished solve
        
        System.out.println("Found solution in " + moves + " moves");
        

    } // main
} // Multichoice
