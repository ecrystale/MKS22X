public class QueenBoard{
    private static int[][]board;

    public QueenBoard(int size){
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
		    if((i==r || j==c || i-r==j-c) && !(i==r && j==c)){
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
		    if((i==r || j==c || i-r==j-c) && !(i==r && j==c)){
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
    public String toString(){
	String chess="";
	for(int i=0;i<board.length;i++){
	    for(int j=0;j<board[i].length;j++){
		if(board[i][j]==-1){
		    chess=chess+"Q ";
		}
		else{
		    chess=chess+"_ ";
		}
		if(j==board[i].length-1 && i!=board.length && j!=board.length){
		    chess=chess+"\n";
		}
	    }
	}
	return chess;
    }

  
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
	QueenBoard a=new QueenBoard(5);
	System.out.println(a.toString());;
	System.out.println(a.addQueen(0,0));
	System.out.println(a.toString());
	System.out.println(a.addQueen(4,2));
	System.out.println(a.toString());
	System.out.println(a.removeQueen(0,0));
	System.out.println(a.toString());
	System.out.println(a.removeQueen(0,0));
	//	addQueen(6,3);
	System.out.println(a.addQueen(2,2));
	System.out.println(a.removeQueen(3,2));
	System.out.println(a.removeQueen(1,1));
	
	//System.out.println(board);
    }
}
  
