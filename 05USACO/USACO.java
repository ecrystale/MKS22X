import java.util.*;
import java.io.*;
public class USACO{
    private int[][] lake;
    public static int bronze(String filename)throws FileNotFoundException{
	File text= new File(filename);
	Scanner inf= new Scanner(text);
	int row=0;
	int col=0;
	String line="";
	while(inf.hasNextLine()){
	    String part=inf.nextLine();
	    line+=part;
	    row++;
	    col=part.length();
	}
	return -1;
    }
    public static void grid(){
	
    }
    /**    public static int silver(String filename){
	
	   }*/
}
