import java.util.*;
import java.io.*;
public class silver{
    private static int[3] start;
    private static int[4] end;
    private static char[][] field;
    public static int silver(String filename)throws FileNotFoundException{
	File text= new File(filename);
	Scanner inf= new Scanner(text);
	int row=0;	    
	int r=0;
	String setups=inf.nextLine();
	setupsilver(setups);
	lake.toString();
    }
    public static void setupsilver(String starting){
	int setplace=0;
	int place=0;
	for(int i=0;i<setup.length();i++){
	    if(setup.substring(i,i+1).equals(" ")){
		set[setplace]=Integer.parseInt(setup.substring(place,i));
		place=i+1;
		setplace++;
	    }
	    if(i==setup.length()-1){
		set[setplace]=Integer.parseInt(setup.substring(place,i+1));
		place=i+1;
		setplace++;;
	    }
	}
	lake=new int[set[0]][set[1]];
	elevation=set[2];
	calls=new int[set[3]][3];
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
