public class Driver{
    public static void main(String[] args){
    MazeSolver x=new MazeSolver("maze1");
    System.out.println(x.solve());

    MazeSolver y=new MazeSolver("maze1");
    System.out.println(y.solve(1));

    }
}
