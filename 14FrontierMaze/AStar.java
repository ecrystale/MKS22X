import java.util.*;
public class AStar implements Frontier{
    //min heap of Locations.
    private MyHeap<Location> data;//= new MyHeap<>(false);
    //@SuppressWarnings("unchecked")
    //private LinkedList<Location> data=new LinkedList<>();
    @SuppressWarnings("unchecked")
    public AStar(){
	data= new MyHeap<Location>(false);
	//data.setAstar(true);
    }
    public void add(Location n){
	data.add(n);
    }
    public Location next(){
        return data.remove();
    }
    public boolean hasNext(){
	return data.size()>0;
    }
}
