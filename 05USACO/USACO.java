import java.util.*;
import java.io.*;
public class USACO{
    private static int[][] lake;
    private static int elevation;
    private static int[][] calls;
    public static int bronze(String filename)throws FileNotFoundException{
	File text= new File(filename);
	Scanner inf= new Scanner(text);
	int row=0;
	int col=0;
	int r=0;
	int c=0;
	String setup=inf.nextLine();
	setupary(setup);
	while(inf.hasNextLine()){
	    String part=inf.nextLine();
	    if(row<lake.length){
		int place=0;
		for(int i=0;i<part.length();i++){
		    if(part.substring(i,i+1)==" "){
			lake[row][col]=Integer.parseInt(part.substring(place,i+1));
			col++;
			place=i+1;
		    }
		}
		row++;
	    }
	    if(row>=lake.length){
		int place=0;
		for(int i=0;i<part.length();i++){
		    if(part.substring(i,i+1)==" "){
			calls[r][c]=Integer.parseInt(part.substring(place,i+1));
			c++;
			place=i+1;
		    }
		}
		r++;
	    }
	}
	return solvebronze();
    }

    public static int solvebronze(){
	for(int row=0;row<calls.length;row++){
	    int max=maxbox(calls[row][0],calls[row][1]);
	    max=max-calls[row][2];
	    setlake(calls[row][0],calls[row][1],max);
	}
	int sum=0;
	for(int i=0;i<lake.length;i++){
	    for(int j=0;j<lake[0].length;j++){
		if(lake[i][j]<elevation){
		    lake[i][j]=elevation-lake[i][j];
		}
		if(lake[i][j]>=elevation){
		    lake[i][j]=0;
		}
		sum+=lake[i][j];
	    }
	}
	int volume=1;
	for(int num=sum;num==0;num=num%10){
	    volume=num%10*volume;
	}
	return volume*72*72;
    }

    public static void setlake(int row, int col, int amount){
	for(int i=row;i<row+3;i++){
	    for(int j=col;col<col+3;j++){
		int a=lake[i][j];
		if(a>amount){
		    lake[i][j]=amount;
		}
	    }
	}
    }

    public static int maxbox(int row, int col){
	int orig=lake[row][col];
	for(int i=row;i<row+3;i++){
	    for(int j=col;col<col+3;j++){
		int a=lake[i][j];
		if(a>orig){
		    orig=a;
		}
	    }
	}
	return orig;
    }

    public static void setupary(String setup){
	int[] set= new int[4];
	int setplace=0;
	int place=0;
	for(int i=0;i<setup.length();i++){
	    if(setup.substring(i,i+1)==" "){
		set[setplace]=Integer.parseInt(setup.substring(place,i+1));
		place=i+1;
		setplace++;
	    }
	}
	lake=new int[set[0]][set[1]];
	elevation=set[2];
	calls=new int[set[3]][3];
    }
    /**    public static int silver(String filename){
	
	   }*/
}
