import java.util.*;
public class FrontierPriorityQueue implements Frontier{
    //min heap of Locations.
    private MyHeap<Location> data;//= new MyHeap<>(false);
    //@SuppressWarnings("unchecked")
    //private LinkedList<Location> data=new LinkedList<>();
    @SuppressWarnings("unchecked")
    public FrontierPriorityQueue(){
	data= new MyHeap<Location>(false);
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
