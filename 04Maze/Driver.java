public class Driver{

    public static void main(String[]args){
        Maze f;
        f = new Maze("dataee1.dat");//true animates the maze.
        
        f.setAnimate(true);
        f.solve();

        System.out.println(f);
    }
}
