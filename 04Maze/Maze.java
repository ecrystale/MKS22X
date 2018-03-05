import java.util.*;
import java.io.*;
public class Maze{

    private  boolean check;
    private char[][] maze;
    private boolean animate;//false by default


    public Maze(String filename) throws FileNotFoundException{
        //COMPLETE CONSTRUCTOR
	//instead of a try/catch, you can throw the FileNotFoundException.
	File text = new File(filename);
	Scanner inf = new Scanner(text);
	int row=0;
	int col=0;
	while(inf.hasNextLine()){
	    String line = inf.nextLine();
	    System.out.println(line);
	    col=line.length();
	    row++;
	}
	
	Scanner inf2 = new Scanner(text);
	//	String line = inf2.nextLine();
	maze= new char[row][col];
	row=0;
	while(inf2.hasNextLine()){
	    String line2 = inf2.nextLine();
	    for(int i=0;i<col;i++){
		maze[row][i]=line2.charAt(i);
	    }
	    row++;
	}

	if(!checker()){
	    throw new IllegalStateException();
	}
    }



    public boolean checker(){
	int s=0;
	int e=0;
	for(int i=0;i<maze.length;i++){
	    for(int j=0;j<maze[0].length;j++){
		    if(maze[i][j]=='S'){
			s++;
		    }
		    if(maze[i][j]=='E'){
			e++;
		    }
	    }
	}
	if(s==1 && e==1){
	    return true;
	}
	return false;
    }
    private void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public void setAnimate(boolean b){
        animate = b;
    }

    public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }


    public int solve(){
	//find the location of the S. 
	int sx=0;
	int sy=0;
	for(int i=0;i<maze.length;i++){
	    for(int j=0;j<maze[0].length;j++){
		if(maze[i][j]=='S'){
		    sx=i;
		    sy=j;
		}
	    }
	}
	//erase the S
	maze[sx][sy]=' ';
	//and start solving at the location of the s.
	return solve(sx,sy,0);
    }



    private int solve(int row, int col, int count){ //you can add more parameters since this is private
	if(animate){
            clearTerminal();
	    // System.out.println(this);
            wait(20);
	}
	int i=row;
	int j=col;
	if(maze[row][col]=='E'){
	    return count;
	}
	if (maze[row][col]==' '){
	    maze[row][col]='@';
	    int a=solve(i+1,j,count+1);
	    if(a!=-1){
		return a;
	    }
	    a=solve(i-1,j,count+1);
	    if(a!=-1){
		return a;
	    }
	    a=solve(i,j+1,count+1);
	    if(a!=-1){
		return a;
	    }
	    a=solve(i,j-1,count+1);
	    if(a!=-1){
		return a;
	    }
	    maze[row][col]='.';
	}

        //COMPLETE SOLVE
        return -1; //so it compiles
    }

    public String toString(){
	String out="";
	for(int i=0;i<maze.length;i++){	   
	    for(int j=0;j<maze[0].length;j++){
		out+=maze[i][j];
	    }
	    out+="\n";
	}
	return out;
    }
    
}
