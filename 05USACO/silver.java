import java.util.*;
import java.io.*;
public class USACO{
    private static int[][] field;
    public static int silver(String filename)throws FileNotFoundException{
	File text= new File(filename);
	Scanner inf= new Scanner(text);
	int row=0;	    
	int r=0;
	String setup=inf.nextLine();
	setupary(setup);
	lake.toString();
    }
    public static boolean cantravel(int row, int col){
	if(row>=0 && row<lake.length && col>=0 && col<lake[0].length){
	    if(field[row][col].equals("*")){
		return false;
	    }
	    return true;
	}
	return false;
    }
    public static void main(String[] args)throws FileNotFoundException{
	//System.out.println(silver("makelake.1.in"));
    }
}
