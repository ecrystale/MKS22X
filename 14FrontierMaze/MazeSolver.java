public class MazeSolver{
  private Maze maze;
  private Frontier frontier;

  public MazeSolver(String mazeText){
      maze=new Maze(mazeText);
  }

  //Default to BFS
  public boolean solve(){
      return solve(0);
  }

  //mode: required to allow for alternate solve modes.
  //0: BFS
  //1: DFS
  public boolean solve(int mode){
      if(mode==0){
	  frontier= new FrontierStack();
	  return Frontiersolver(maze.getStart());
      }
      if(mode==1){
	  frontier= new FrontierQueue();
	  return Frontiersolver(maze.getStart());
      }
    //initialize your frontier
    //while there is stuff in the frontier:
    //  get the next location
    //  process the location to find the locations (use the maze to do this)
    //  check if any locations are the end, if you found the end just return true!
    //  add all the locations to the frontier
    //when there are no more values in the frontier return false
    return false;
  }

    public boolean Frontiersolver(Location L){
	  frontier.add(L);
	  Location[] neighbors=maze.getNeighbors(L);
	  for(int i=0;i<neighbors.length;i++){
	      if(neighbors[i]==(maze.getEnd())){
		  return true;
	      }
	      frontier.add(neighbors[i]);
	  }
	  while(frontier.hasNext()){
	      if(Frontiersolver(frontier.next())){
		  return true;
	      }
	  }
	  //frontier.remove();
	  return false;
    }

    public String toString(){
	return maze.toString();
    }
    /**
    public static void main(String[] args){
	MazeSolver x=new MazeSolver("maze1");
	return x.solve();
	}*/
}
