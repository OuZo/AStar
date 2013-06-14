package multichoice;

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
    
    public void assignPos(int p, int val) {
        map[p] = val;
    } // assignPos

    public int minPos() {
        int min = 999;
        int pos = -1;
        for (int i = 0; i < map.length; i++) {
            if ((map[i] < min) && (map[i] > 0)) {
                min = map[i];
                pos = i;
            } // if
        } // for
        return pos;
    } // minPos
    
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
