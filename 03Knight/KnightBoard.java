public class KnightBoard{
    private static int[][] board;
    private static boolean called=false;
    //@throws IllegalArgumentException when either parameter is negative.
    public KnightBoard(int startingRows,int startingCols){
	if(startingRows<0 || startingCols<0){
	    throw new IllegalArgumentException();
	}
	board=new int[startingRows][startingCols];
	for(int row=0;row<board.length;row++){
	    for(int cols=0;cols<board[row].length;cols++){
		board[row][cols]=0;
	    }
	}
    }
	
    //    Initialize the board to the correct size and make them all 0's 
	
	
    public String toString(){
	String news="";
	if(called==false){
	    for (int row=0;row<board.length;row++){
		for(int cols=0;cols<board[row].length;cols++){
		    news+="_ ";
		    if(cols==board[row].length-1){
			news+="\n";
		    }
		}
	    }
	    return news;
	}
	for (int row=0;row<board.length;row++){
	    for(int cols=0;cols<board[row].length;cols++){
		if(board[row][cols]%10==0){
		    news=news+" "+board[row][cols]+" ";
		}
		else{
		    news=news+board[row][cols]+" ";
		}
		if(cols==board[row].length-1){
		    news+="\n";
		}
	    }
	}
	return news;
    } 
/**see format for toString below
   blank boards display 0's as underscores 
   you get a blank board if you never called solve or 
   when there is no solution 
   
@throws IllegalStateException when the board contains non-zero values.
@throws IllegalArgumentException when either parameter is negative 
or out of bounds.
    public boolean solve(int startingRow, int startingCol){
    }

/**
   @throws IllegalStateException when the board contains non-zero values. 
   @throws IllegalArgumentException when either parameter is negative 
   or out of bounds.

    public int countSolutions(int startingRow, int startingCol){

    }
	
    //Suggestion:
    private boolean solveH(int row ,int col, int level) {

    }

    // level is the # of the knight*/
    public static void main(String[] args){
	KnightBoard a= new KnightBoard(5,5);
	System.out.println(a.toString());

    }
}
