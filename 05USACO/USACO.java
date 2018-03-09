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

	String setup=inf.nextLine();
	System.out.println(setup);
	setupary(setup);
	lake.toString();
	while(inf.hasNextLine()){
	    int col=0;
	    int place=0;
	    int r=0;
	    int c=0;
	    String part=inf.nextLine();
	    if(row>=lake.length){
		System.out.println("why");
		for(int i=0;i<part.length()-1;i++){		    
		    System.out.println("ok1");
		    if(part.substring(i,i+1).equals(" ")){
			calls[r][c]=Integer.parseInt(part.substring(place,i));
			System.out.println(calls[r][c]);
			c++;
			place=i+1;      
		    }
		    if(i==part.length()-1){
			calls[r][c]=Integer.parseInt(part.substring(place,i+1));
			System.out.println(calls[r][c]);
			c++;
			place=i+1;
		    }
		}
		r++;
		row++;
		System.out.println("1");
	    }
	    if(row<lake.length){
		for(int i=0;i<part.length();i++){
		    if(part.substring(i,i+1).equals(" ")){
			lake[row][col]=Integer.parseInt(part.substring(place,i));
			col++;
			place=i+1;

		    }
		    if(i==part.length()-1){
			lake[row][col]=Integer.parseInt(part.substring(place,i+1));
			place=i+1;
		    }
		}
		row++;
	    }
	}
	calls.toString();
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
		if(inbounds(i,j)){
		    if(lake[i][j]<elevation){
			lake[i][j]=elevation-lake[i][j];
		    }
		    if(lake[i][j]>=elevation){
			lake[i][j]=0;
		    }
		    sum+=lake[i][j];
		}
	    }
	}
	return sum*72*72;
    }

    public static void setlake(int row, int col, int amount){
	for(int i=row;i<row+3;i++){
	    for(int j=col;col<col+3;j++){
		if(inbounds(i,j)){
		    int a=lake[i][j];
		    if(a>amount){
			lake[i][j]=amount;
		    }
		}
	    }
	}
    }

    public static int maxbox(int row, int col){
	int orig=lake[row][col];
	for(int i=row;i<row+2;i++){
	    for(int j=col;col<col+2;j++){
		if(inbounds(i,j)){
		    int a=lake[i][j];
		    if(a>orig){
			orig=a;
		    }
		}
	    }
	}
	return orig;
    }

    public static boolean inbounds(int row, int col){
	if(row>0 && row<lake.length && col>0 && col<lake[0].length){
	    return true;
	}
	return false;
    }

    public static void setupary(String setup){
	int[] set= new int[4];
	int setplace=0;
	int place=0;
	for(int i=0;i<setup.length();i++){
	    //System.out.println(setup.substring(i,i+1));
	    // System.out.println(setup.substring(i,i+1).equals(" "));
	    if(setup.substring(i,i+1).equals(" ")){
		System.out.println("exist");
		set[setplace]=Integer.parseInt(setup.substring(place,i));
		System.out.println(set[setplace]);
		place=i+1;
		setplace++;
	    }
	    if(i==setup.length()-1){
		System.out.println("exist2");
		set[setplace]=Integer.parseInt(setup.substring(i,i+1));
		System.out.println(set[setplace]);
		place=i+1;
		setplace++;;
	    }
	}
	//	set[3]=Integer.parseInt(setup.substring(setup.length()-1,setup.length()));
	lake=new int[set[0]][set[1]];
	elevation=set[2];
	calls=new int[set[3]][3];
    }
    /**    public static int silver(String filename){
	
	   }*/
    public static void main(String[] args)throws FileNotFoundException{
	System.out.println(bronze("makelake.1.in"));
	//	System.out.println(bronze("makelake.2.in"));
    }
}
