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
	int r=0;
	String setup=inf.nextLine();
	setupary(setup);
	lake.toString();
	while(inf.hasNextLine()){
	    int col=0;
	    int place=0;
	    int c=0;
	    String part=inf.nextLine();
	    if(row>=lake.length){
		for(int i=0;i<part.length();i++){
		    if(part.substring(i,i+1).equals(" ")){
			calls[r][c]=Integer.parseInt(part.substring(place,i));
			c++;
			place=i+1;      
		    }
		    if(i==part.length()-1){
			calls[r][c]=Integer.parseInt(part.substring(place,i+1));
			c++;
			place=i+1;
		    }
		}
		r++;
		row++;
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
	return solvebronze();
    }

    public static int solvebronze(){
	for(int row=0;row<calls.length;row++){
	    int max=maxbox(calls[row][0]-1,calls[row][1]-1);
	    max=max-calls[row][2];
	    setlake(calls[row][0]-1,calls[row][1]-1,max);
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
	    for(int j=col;j<col+3;j++){
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
	for(int i=row;i<row+3;i++){
	    for(int j=col;j<col+3;j++){
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
	if(row>=0 && row<lake.length && col>=0 && col<lake[0].length){
	    return true;
	}
	return false;
    }

    public static void setupary(String setup){
	int[] set= new int[4];
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


    //SILVER
    private static int[] start=new int[3];
    private static int[] end=new int[4];
    private static char[][] field;
    private static int[][] copy;
    private static int time;
    public static int silver(String filename)throws FileNotFoundException{
	File text= new File(filename);
	Scanner inf= new Scanner(text);
	int row=0;	    
	int r=0;
	String setups=inf.nextLine();
	setupsilver(setups);
	field=new char[start[0]][start[1]];
	time=start[2];
	while(inf.hasNextLine()){
	    int input=0;
	    int place=0;
	    int c=0;
	    String part=inf.nextLine();
	    if(row>=field.length){
		for(int i=0;i<part.length();i++){
		    if(part.substring(i,i+1).equals(" ")){
			end[input]=Integer.parseInt(part.substring(place,i));
			input++;
			place=i+1;
		    }
		    if(i==part.length()-1){
		        end[input]=Integer.parseInt(part.substring(place,i+1));
			place=i+1;
		    }
		}
		row++;
	    }
	    if(row<field.length){
		for(int i=0;i<part.length();i++){
		    field[r][i]=part.charAt(i);
		}
		row++;
	    }
	}
	return solvesilver();
    }

    public static int solvesilver(){
	copy=new int[field.length][field[0].length];
	for(int i=0;i<copy.length;i++){
	    for(int j=0;j<copy[0].length;j++){
		copy[i][j]=0;
	    }
	}
	int[][] copy2=copy;
	int sum=0;
	int row=end[0];
	int col=end[1];
	int tr=end[2];
	int tc=end[3];
	copy[row][col]=1;
	for(int i=1;i<time+1;i++){
	    for(int r=0;r<row;r++){
		for(int c=0;c<col;c++){
		    if(copy[r][c]==1){
			if(cantravel(r+1,c)){
			    copy[r+i][c]=1;
			}
			if(cantravel(row-1,col)){
			    copy[r-i][c]=1;
			}
			if(cantravel(row,col+1)){
			    copy[r][c+i]=1;
			}
			if(cantravel(row,col-1)){
			    copy[r][c-i]=1;
			}
			copy[r][c]=0;
			if(i==time){
			    if(cantravel(r+1,c)){
				if(r+1==tr && c==tc){
				    sum++;
				    System.out.println(sum);
				}
			    }
			    if(cantravel(row-1,col)){
				if(r-1==tr && c==tc){
				    sum++;
				}
			    }
			    if(cantravel(row,col+1)){
				if(r==tr && c+1==tc){
				    sum++;
				}
			    }
			    if(cantravel(row,col-1)){
				if(r==tr && c-1==tc){
				    sum++;
				}
			    }
			}
		    }
		}
	    }
	}
	return sum;
    }
    public static void setupsilver(String starting){
	int setplace=0;
	int place=0;
	for(int i=0;i<starting.length();i++){
	    if(starting.substring(i,i+1).equals(" ")){
		start[setplace]=Integer.parseInt(starting.substring(place,i));
		place=i+1;
		setplace++;
	    }
	    if(i==starting.length()-1){
		start[setplace]=Integer.parseInt(starting.substring(place,i+1));
		place=i+1;
		setplace++;;
	    }
	}
    }
    public static boolean cantravel(int row, int col){
	if(row>=0 && row<lake.length && col>=0 && col<lake[0].length){
	    if(field[row][col]==('*')){
		return false;
	    }
	    return true;
	}
	return false;
    }
    public static void main(String[] args)throws FileNotFoundException{
	System.out.println(silver("ctravel.1.in"));
	System.out.println(silver("ctravel.2.in"));
    }
}
