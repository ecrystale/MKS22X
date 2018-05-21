import java.util.*;
public class FrontierPriorityQueue implements Frontier{
    //min heap of Locations.
    //@SuppressWarnings("unchecked")
    private LinkedList<Location> data=new LinkedList<>();
	@SuppressWarnings("unchecked")
    public FrontierPriorityQueue(){
	//data= new MyHeap<>(true);
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
