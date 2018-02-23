public class KnightBoard{
    private static int[][] board;
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
	if(!noZero()){
	    throw new IllegalStateException();
	}
	if(startingRow<0 || startingCol<0){
	    throw new IllegalArgumentException();
	}
	//called=true;
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
    
    public static boolean isclearboard(){
	for(int row=0;row<board.length;row++){
	    for(int cols=0;cols<board[row].length;cols++){
		if(board[row][cols]!=0){
		    return false;
		}
	    }
	}
	return true;
    }
    public static void clearboard(){
	for(int row=0;row<board.length;row++){
	    for(int cols=0;cols<board[row].length;cols++){
		board[row][cols]=0;
	    }
	}
    }
    public static int countSolutions(int startingRow, int startingCol){
	if(!noZero()){
	    throw new IllegalStateException();
	}
	if(startingRow<0 || startingCol<0){
	    throw new IllegalArgumentException();
	}
	int sum=0;
	for(int row=startingRow;row<board.length;row++){
	    for(int cols=startingCol;cols<board[row].length;cols++){
		sum+=solveH(row,cols,1,0);
		clearboard();
	    }
	}
	return sum;
    }
    
    private static int solveH(int row ,int col, int step,int count) {
	int solution=0;
	if(!inbound(row,col)){
	    return 0;
	}
	if(count==board[0].length*board.length){
	    return 1;
	}
	if(board[row][col]==0){
	    board[row][col]=step;
	    if(solveH(row+2, col+1, step+3, count+1)!=0){
		solution++;
	    } 
	    if(solveH(row+1, col+2, step+3, count+1)!=0){
		solution++;
	    }
	    if(solveH(row-2, col+1, step+3, count+1)!=0){
		solution++;
	    }
	    if(solveH(row+2, col-1, step+3, count+1)!=0){
		solution++;
	    } 
	    if(solveH(row-2, col-1, step+3, count+1)!=0){
		solution++;
	    } 
	    if(solveH(row-1, col+2, step+3, count+1)!=0){
		solution++;
	    } 
	    if(solveH(row+1, col-2, step+3, count+1)!=0){
		solution++;
	    } 
	    if(solveH(row-1, col-2, step+3, count+1)!=0){
		solution++;
	    }
	    board[row][col]=0;
	}
	return solution;
    }
    
    // level is the # of the knight
    public static void main(String[] args){
	KnightBoard a = new KnightBoard(3,3);

	System.out.println(a);
	/* Prints
	   _ _ _
	   _ _ _
	   _ _ _
	*/

	for (int i = 0; i < 3; i++){
	    for (int j = 0; j < 3; j++){
		if (a.solve(i,j)){
		    System.out.println("There is an error with your solve method");
		}
	    }
	} //prints nothing

	System.out.println(a.countSolutions(0,0)); //prints 0



	KnightBoard b = new KnightBoard(5,5);
	System.out.println(b.solve(0,0)); //prints true
	System.out.println(b); //prints a valid solution

	try{
	    b.solve(0,0);
	}catch(IllegalStateException e){
	    System.out.println("Error: The board contains non-zero values");
	} //prints "Error: The board contains non-zero values"

	try{
	    b.countSolutions(0,0);
	}catch(IllegalStateException e){
	    System.out.println("Error: The board contains non-zero values");
	} //prints "Error: The board contains non-zero values"

	try{
	    KnightBoard b1 = new KnightBoard(-1,0);
	}catch(IllegalArgumentException e){
	    System.out.println("Error: There cannot be negative parameters in the constructor");
	} //prints "Error: There cannot be negative parameters in the constructor"

	try{
	    KnightBoard b1 = new KnightBoard(1,-1);
	}catch(IllegalArgumentException e){
	    System.out.println("Error: There cannot be negative parameters in the constructor");
	} //prints "Error: There cannot be negative parameters in the constructor"

	try{
	    KnightBoard b1 = new KnightBoard(-1,-1);
	}catch(IllegalArgumentException e){
	    System.out.println("Error: There cannot be negative parameters in the constructor");
	} //prints "Error: There cannot be negative parameters in the constructor"

	try{
	    KnightBoard b1 = new KnightBoard(5,5);
	    b1.solve(0,-1);
	}catch(IllegalArgumentException e){
	    System.out.println("Error: There cannot be negative parameters");
	} //prints "Error: There cannot be negative parameters"

	try{
	    KnightBoard b1 = new KnightBoard(5,5);
	    b1.solve(-1,0);
	}catch(IllegalArgumentException e){
	    System.out.println("Error: There cannot be negative parameters");
	} //prints "Error: There cannot be negative parameters"

	try{
	    KnightBoard b1 = new KnightBoard(5,5);
	    b1.solve(-1,-1);
	}catch(IllegalArgumentException e){
	    System.out.println("Error: There cannot be negative parameters");
	} //prints "Error: There cannot be negative parameters"



	for (int i = 0; i < 5; i++){
	    for (int j = 0; j < 5; j++){
		KnightBoard abc = new KnightBoard(5,5);
		System.out.println(abc.solve(i,j)); //prints alternating lines of true/false starting with true
	    }
	}
	KnightBoard c = new KnightBoard(5,5);

	int totalSol = 0;
	for (int i = 0; i < 5; i++){
	    for (int j = 0; j < 5; j++){
		totalSol += c.countSolutions(i,j);
	    }
	}

	System.out.println(totalSol); //prints 1728

	KnightBoard d = new KnightBoard(5,5);
	System.out.println(d.countSolutions(0,0)); //prints 304

    }
    
}
