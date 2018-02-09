public class QueenBoard{
    private static int[][]board;

    public static void QueenBoard(int size){
	board=new int[size][size];
	for (int i=0;i<board.length;i++){
	    for (int j=0;j<board[i].length;j++){
		board[i][j]=0;
	    }
	}
    }

    private static boolean addQueen(int r, int c){
	if (board[r][c]==0){
	    board[r][c]=-1;
	    for(int i=0;i<board.length;i++){
		for(int j=0;j<board[i].length;j++){
		    if(i==r || j==c || i-r==j-c){
			board[i][j]=board[i][j]+1;
		    }
		}
	    }
	    return true;
	}
	return false;
    }
    
    private static boolean removeQueen(int r, int c){
	if (board[r][c]==-1){
	    board[r][c]=0;
	    for(int i=0;i<board.length;i++){
		for(int j=0;j<board[i].length;j++){
		    if(i==r || j==c || i-r==j-c){
			board[i][j]=board[i][j]-1;
		    }
		}
	    }
	    return true;
	}
	return false;
    }

      
    /**
     *@return The output string formatted as follows:
     *All numbers that represent queens are replaced with 'Q' 
     *all others are displayed as underscores '_'
     *There are spaces between each symbol:  
     *Q _ _ _
     *_ _ Q _
     * etc.
     */
    //	public String toString(){}

  
    /**
     *@return false when the board is not solveable and leaves the board filled with zeros; 
     *        true when the board is solveable, and leaves the board in a solved state
     *@throws IllegalStateException when the board starts with any non-zero value
     */
    //    public boolean solve(){}
  
    /**
     *@return the number of solutions found, and leaves the board filled with only 0's
     *@throws IllegalStateException when the board starts with any non-zero value
     */
    //    public int countSolutions(){    }
    public static void main(String[] args){
	QueenBoard(5);
	addQueen(1,1);
	addQueen(6,3);
	addQueen(2,1);
	removeQueen(3,2);
	removeQueen(1,1);
	
	//System.out.println(board);
    }
}
  
