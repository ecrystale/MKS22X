import java.util.*;
import java.io.*;
public class Maze{

    //private boolean real;
    private static boolean file;
    private static boolean check;
    private static char[][] maze;
    private static boolean animate;//false by default

    /*Constructor loads a maze text file, and sets animate to false by default.

      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - Walls - locations that cannot be moved onto
      ' ' - Empty Space - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)
      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!

      3. When the file is not found OR the file is invalid (not exactly 1 E and 1 S) then: 
      throw a FileNotFoundException or IllegalStateException
    */
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
	/*	if(file==false){
	throw new FileNotFoundException();
	}*/
	if(!checker()){
	    throw new IllegalStateException();
	}
    }
    /*if(checker()==false){
      throw new IllegalStateException();
      }*/


    public static boolean checker(){
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
    private static void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public static void setAnimate(boolean b){
        animate = b;
    }

    public static void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }


    /*Wrapper Solve Function returns the helper function
      Note the helper function has the same name, but different parameters.
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public static int solve(){
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

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns the number of @ symbols from S to E when the maze is solved,
      Returns -1 when the maze has no solution.

      Postcondition:
      The S is replaced with '@' but the 'E' is not.
      All visited spots that were not part of the solution are changed to '.'
      Note: This is not required based on the algorithm, it is just nice visually to see.
      All visited spots that are part of the solution are changed to '@'
    */
    private static int min(int a, int b){
	if(a!=-1 && b!=-1){
	    if(a<b){
		return a;
	    }
	    return b;
	}
	if(a==-1){
	    return b;
	}
	return a;
    }
    private static int solve(int row, int col, int count){ //you can add more parameters since this is private
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
	    int b=solve(i-1,j,count+1);
	    int c=solve(i,j+1,count+1);
	    int d=solve(i,j-1,count+1);
	    int number=min(a,b);
	    number=min(number,c);
	    number=min(number,d);
	    if(number==-1){
		maze[row][col]='.';
	    }
	    return number;
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
    
    public static void main(String[]args){
        Maze f;
	try {
	    f = new Maze("data1.dat");//true animates the maze.
	    f.setAnimate(true);
	    System.out.println(f.solve());
	    System.out.println(f.toString());
	} catch (FileNotFoundException e){
	    System.out.println("wrong");
	}
    }
}
