public class KnightBoard{
    private static int[][] board;
    private static boolean called=false;
    
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
    
    private static boolean noZero(){
	for(int row=0;row<board.length;row++){
	    for(int col=0;col<board[row].length;col++){
		if(board[row][col]!=0){
		    return false;
		}
	    }
	}
	return true;
    }
    
    public static boolean solve(int startingRow, int startingCol){
	if(!noZero() || !inbound(startingRow,startingCol)){
		throw new IllegalStateException();
	    }
	called=true;
	return HelpSolve(startingRow,startingCol,1,0);
    }

	public static boolean inbound(int row, int col){
	    if(row<0 || col<0 || row>=board.length || col>=board[0].length){
		return false;
	    }
	    return true;
	}
    
	public static boolean HelpSolve(int row,int col, int step, int count){
	    if(!inbound(row,col)){
		return false;
	    }
	    if(count==board[0].length*board.length){
		return true;
	    }
	    if(board[row][col]==0){
		board[row][col]=step;
		if(HelpSolve(row+2, col+1, step+3, count+1) || HelpSolve(row+1, col+2, step+3, count+1) || HelpSolve(row-2, col+1, step+3, count+1) || HelpSolve(row+2, col-1, step+3, count+1) || HelpSolve(row-2, col-1, step+3, count+1) || HelpSolve(row-1, col+2, step+3, count+1) || HelpSolve(row+1, col-2, step+3, count+1) || HelpSolve(row-1, col-2, step+3, count+1)){
		return true;
		}
		board[row][col]=0;
	    }
	    return false;
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
	    System.out.println(a.solve(0,0));
	    System.out.println(a.toString());
	}
    }
