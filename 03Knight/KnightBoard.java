public class KnightBoard{
    private int[][] board;
    //    private static boolean called=false;
    
    public KnightBoard(int startingRows,int startingCols){
	if(startingRows<0 || startingCols<0){
	    throw new IllegalArgumentException();
	}
	board=new int[startingRows][startingCols];
	clearboard();
    }
	
    //    Initialize the board to the correct size and make them all 0's 
	
	
    public String toString(){
	String news="";
	if(isclearboard()==true){
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
		if(board[row][cols]/10==0){
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
    
    private boolean noZero(){
	for(int row=0;row<board.length;row++){
	    for(int col=0;col<board[row].length;col++){
		if(board[row][col]!=0){
		    return false;
		}
	    }
	}
	return true;
    }
    
    public boolean solve(int startingRow, int startingCol){
	if(!noZero()){
	    throw new IllegalStateException();
	}
	if(startingRow<0 || startingCol<0){
	    throw new IllegalArgumentException();
	}
	//called=true;
	return HelpSolve(startingRow,startingCol,1,0);
    }

    public boolean inbound(int row, int col){
	if(row<0 || col<0 || row>=board.length || col>=board[0].length){
	    return false;
	}
	return true;
    }
    
    public boolean HelpSolve(int row,int col, int step, int count){
	if(!inbound(row,col)){
	    return false;
	}
	if(count==board[0].length*board.length){
	    return true;
	}
	if(board[row][col]==0){
	    board[row][col]=step;
	    if(HelpSolve(row+2, col+1, step+3, count+1) ||  HelpSolve(row+1, col+2, step+3, count+1) || HelpSolve(row-2, col+1, step+3, count+1) || HelpSolve(row+2, col-1, step+3, count+1) || HelpSolve(row-2, col-1, step+3, count+1) || HelpSolve(row-1, col+2, step+3, count+1) || HelpSolve(row+1, col-2, step+3, count+1) || HelpSolve(row-1, col-2, step+3, count+1)){
		return true;
	    }
	    board[row][col]=0;
	}
	return false;
    }
    /**
       @throws IllegalStateException when the board contains non-zero values. 
       @throws IllegalArgumentException when either parameter is negative 
       or out of bounds.*/
    
    public boolean isclearboard(){
	for(int row=0;row<board.length;row++){
	    for(int cols=0;cols<board[row].length;cols++){
		if(board[row][cols]!=0){
		    return false;
		}
	    }
	}
	return true;
    }
    public void clearboard(){
	for(int row=0;row<board.length;row++){
	    for(int cols=0;cols<board[row].length;cols++){
		board[row][cols]=0;
	    }
	}
    }
    public int countSolutions(int startingRow, int startingCol){
	if(!noZero()){
	    throw new IllegalStateException();
	}
	if(startingRow<0 || startingCol<0){
	    throw new IllegalArgumentException();
	}
        return solveH(startingRow,startingCol,0);
    }

    private void remove(int row,int col){
	if(inbound(row,col)){
	    board[row][col]=0;
	}
    }

    private int solveH(int row ,int col,int count) {
	int solution=0;
	if(!inbound(row,col)){
	    return 0;
	}
	if(count==(board[0].length*board.length)-1 && board[row][col]==0){
	    return 1;
	}
	if(board[row][col]!=0){
	    return 0;
	}
	if(board[row][col]==0){
	    board[row][col]=count+1;
	    int a=solveH(row+2, col+1,count+1);
	    if(a>=1){
		solution+=a;
		//remove(row+2,col+1);
	    } 
	    a=solveH(row+1, col+2,  count+1);
	    if(a>=1){
		solution+=a;
		//	remove(row+1,col+2);
	    }
	    a=solveH(row-2, col+1, count+1);
	    if(a>=1){
		solution+=a;
		//	remove(row-2,col+1);
	    }
	    a=solveH(row+2, col-1, count+1);
	    if(a>=1){
		solution+=a;
		//	remove(row+2,col-1);
	    } 
	    a=solveH(row-2, col-1, count+1);
	    if(a>=1){
		solution+=a;
		//	remove(row-2,col-1);
	    } 
	    a=solveH(row-1, col+2, count+1);
	    if(a>=1){
		solution+=a;
		//remove(row-1,col+2);
	    } 
	    a=solveH(row+1, col-2, count+1);
	    if(a>=1){
		solution+=a;
		//remove(row+1,col-2);
	    } 
	    a=solveH(row-1, col-2, count+1);
	    if(a>=1){
		solution+=a;
	        //remove(row-1,col-2);
	    }
	    remove(row,col);
	}
	//clearboard();
	return solution;
    }
    
    // level is the # of the knight
    
}
