import java.util.*;
import java.io.*;
public class USACO{
    private static int[][] lake;
    public static int bronze(String filename)throws FileNotFoundException{
	File text= new File(filename);
	Scanner inf= new Scanner(text);
	int row=0;
	int col=0;
	String line="";
	String setup=inf.nextLine();
	setupary(setup);
	while(inf.hasNextLine()){
	    String part=inf.nextLine();
	    line+=part;
	    row++;
	    col=part.length();
	}
	lake=int[row][col];
	int where=0;
	for(int r=0;r<row;r++){
	    for(int c=0;c<col;c++){
		lake[r][c]=line.substring(where,where+1);
		where++;
	    }
	}
	return -1;
    }
    public static void setupary(String setup){
	int set[4];
	int setplace=0;
	int place=0;
	for(int i=0;i<setup.length();i++){
	    if(setup.substring(i,i+1)==" "){
		set[setplace]=Integer.parseInt(setup.substring(place,i+1));
		place=i+1;
		setplace++;
	    }
	}
	lake=int[set[0]][set[1]];
    }
    /**    public static int silver(String filename){
	
	   }*/
}
