

package multichoice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dimitri Mallis 
 */
public class ReadWrite {

    public ReadWrite() {
       
        
    } // ReadWrite
    
    public int[][] read(String path) {
       
        int[][] arr = null;
        int x = 0;
        int y = 0;
        
        BufferedReader br = null;
 
		try {
 
			String sCurrentLine;
 
			br = new BufferedReader(new FileReader(path));
 
                        
			while ((sCurrentLine = br.readLine()) != null) {
                                x = sCurrentLine.length();
                                y += 1 ;
//				System.out.println(sCurrentLine);
			}
                        System.out.println("x = " + x + " y = " + y);
                        arr = new int[y][x];
                        int count = 0;
                        br = new BufferedReader(new FileReader(path));
                        while ((sCurrentLine = br.readLine()) != null) {
                            for (int i = 0; i < sCurrentLine.length(); i++) {
                                char var = sCurrentLine.charAt(i);
                                if (var == '~') {
                                    arr[count][i] = -1;
                                } else if (var == '.') {
                                    arr[count][i] = 1;
                                } else if (var == '*') {
                                    arr[count][i] = 2;   
                                } else if (var == '^') {
                                    arr[count][i] = 3;   
                                } else if (var == '@') {
                                    arr[count][i] = 8;
                                } else if (var == 'X') {
                                    arr[count][i] = 9;
                                }
                                else {
                                    System.err.println("ERROR: " + var);
                                }

                            } // for chars in line
                            count++;
			} // while lines
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
                
                return arr;
 
	} // read
    
     public void write(String path, int[][] arr) {
         PrintWriter writer = null; 
        try {
                     writer = new PrintWriter(path, "UTF-8");
                     
                     for (int col = 0; col < arr.length; col++) {
                         for (int row = 0; row < arr[col].length; row++) {
                             if (arr[col][row] == -1) {
                                 writer.print("~");
                             } else if (arr[col][row] == 1) {
                                 writer.print(".");
                             } else if (arr[col][row] == 2) {
                                 writer.print("*");
                             } else if (arr[col][row] == 3) {
                                 writer.print("^");
                             } else if (arr[col][row] == 5) {
                                 writer.print("#");
                             } else if (arr[col][row] == 8) {
                                 writer.print("@");
                             } else if (arr[col][row] == 9) {
                                 writer.print("X");
                             }
                         } // row 
                         writer.println();
                     } // col
        } catch (IOException ex) {
            Logger.getLogger(ReadWrite.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            writer.close();
        }
         
         
     } // write
    
} // ReadWrite