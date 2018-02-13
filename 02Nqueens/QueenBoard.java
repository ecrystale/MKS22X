public class QueenBoard{
    private static int[][]board;
    private static int length;
    private static int sol=0;

    public QueenBoard(int size){
	length=size;
	board=new int[size][size];
	reset();
    }

    private static boolean addQueen(int r, int c){
	if (board[r][c]==0){
	    board[r][c]=-1;
	    for(int i=0;i<board.length;i++){
		for(int j=0;j<board[i].length;j++){
		    if((i==r || j==c || i-r==j-c || r-i==j-c) && !(i==r && j==c)){
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
		    if((i==r || j==c || i-r==j-c || r-i==j-c) && !(i==r && j==c)){
			board[i][j]=board[i][j]-1;
		    }
		}
	    }
	    return true;
	}
	return false;
    }

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
    public static boolean solve(){
	if(allZeros()==false){
	    throw new IllegalStateException();
	}
	return setBoard(0);
	//return setBoard(0,0,0);
    }
  
    public static void reset(){
	for (int i=0;i<board.length;i++){
	    for (int j=0;j<board[i].length;j++){
		board[i][j]=0;
	    }
	}

    }


    public static boolean setBoard(int col){
	if(col>=board.length){
	    return true;
	}
	for(int row=0;row<board.length;row++){
	    if(addQueen(row,col)){
		if(setBoard(col+1)){
		    return true;
		}
	    }
	    removeQueen(row,col);
	}
	return false;
    }

    public static boolean allZeros(){
	for(int i=0;i<board.length;i++){
	    for(int j=0;j<board[i].length;j++){
		if(board[i][j]!=0){
		    return false;
		}
	    }
	}
	return true;
    }
    /**
     *@return the number of solutions found, and leaves the board filled with only 0's
     *@throws IllegalStateException when the board starts with any non-zero value
     */
    public static int countSolutions(){
	if(!allZeros()){
	    throw new IllegalStateException();
	}
	helpCount();
	reset();
	return sol;
    }

    public static int helpCount(){
	for(int i=0;i<board.length;i++){
	    reset();
	    if(addQueen(i,0)){
		if(helphelp(0,1)){
			sol++;
		}
	    }
	}
	return sol;
    }
    
    public static boolean helphelp(int row, int col){
    	if(col>=board.length){
	    return true;
	}
	for(int i=row;i<board.length;i++){
	    if(addQueen(i,col)){
		return helphelp(0,col+1);
	    }
	    removeQueen(i,col);
	}
	return false;
    }
    /*
    public static boolean helphelp(int row, int col){
	if(col>=board.length){
	    return true;
	}
	for(int i=row;i<board.length;i++){
	    if(addQueen(i,col)){
		return helphelp(0,col+1);
	    }
	    removeQueen(i,col);
	}
	return false;
	}*/
       
    
    public static void main(String[] args){
	QueenBoard a=new QueenBoard(6);
	System.out.println(a.countSolutions());
	System.out.println(a.solve());
	System.out.println(a.toString());
	System.out.println(a.addQueen(0,0));
	System.out.println(a.addQueen(4,2));
	System.out.println(a.removeQueen(0,0));
	System.out.println(a.removeQueen(0,0));
	//	addQueen(6,3);
	System.out.println(a.addQueen(2,2));
	System.out.println(a.removeQueen(3,2));
	System.out.println(a.removeQueen(1,1));
	//System.out.println(board);
	}
}
  
