import java.util.*;
import java.io.*;
public class Maze{

    //private boolean real;
    private char[][]maze;
    private boolean animate;//false by default

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
    public Maze(String filename) throws FileNotFoundException {
        //COMPLETE CONSTRUCTOR
	ReadFile(filename);
	if(checker()==false){
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
	return s==1 && e==1;
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


    /*Wrapper Solve Function returns the helper function
      Note the helper function has the same name, but different parameters.
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public int solve(){
	//find the location of the S. 

	//erase the S

	//and start solving at the location of the s.
	//return solve(???,???);
	return 1;
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
    private int solve(int row, int col){ //you can add more parameters since this is private

        //automatic animation! You are welcome.
        if(animate){
            clearTerminal();
            System.out.println(this);
            wait(20);
        }

        //COMPLETE SOLVE
        return -1; //so it compiles
    }

    /**
       for(int i=0;i<arry.length;i++){
       String out="";	   
       for(int j=0;j<arry[0].length;j++){
       out+=arry[i][j];
	    }
	    System.out.println(out);
	    }
    */
    public void ReadFile(String files) throws FileNotFoundException {
        //instead of a try/catch, you can throw the FileNotFoundException.
        File text = new File(files);// can be a path like: "/full/path/to/file.txt"
	Scanner inf = new Scanner(text);
	int row=0;
	int col=0;
        while(inf.hasNextLine()){
            String line = inf.nextLine();
	    //            System.out.println(line);//hopefully you can do other things with the line
	    col=line.length();
	    row++;
        }
	
        Scanner inf2 = new Scanner(text);
	//	String line = inf2.nextLine();
	maze= new char[row][col];
	row=0;
        while(inf2.hasNextLine()){
            String line = inf2.nextLine();
	    for(int i=0;i<col;i++){
		maze[row][i]=line.charAt(i);
	    }
	    row++;
	    // System.out.println(line);//hopefully you can do other things with the line
        }
    }
}
