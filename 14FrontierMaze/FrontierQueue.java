import java.util.*;
public class FrontierQueue implements Frontier{
    private LinkedList<Location> list=new LinkedList<>();
    public Location next(){
	return list.remove();
    }
    public void add(Location x){
	list.add(x);
    }
    public boolean hasNext(){
	return list.size()>0;
    }
    /**
    private Location[] locate=new Location[10];
    private int index=9;
    private int count=0;
    private int first=9;
    private int cap=10;
    public void add(Location n){
	if(cap==count){
	    resize();
	}
	locate[index]=n;
	index--;
	count++;
    }
    public void resize(){
	Location[] copy=new Location[cap*2+1];
	int max=cap*2+1;
	for(int i=cap-1;i>0;i--){
	    copy[max-1]=locate[i];
	    max--;
	}
	cap=cap*2+1;
	first=cap-1;
	locate=copy;
    }
    public Location next(){
	if(hasNext()){
	    index--;
	    return locate[index];
	}
	return null;
    }
    public boolean hasNext(){
	if(index-1<0){
	    return false;
	}
	if(locate[index-1]!=null){
	    return true;
	}
	return false;
    }
    public void remove(){
	locate[first]=null;
	count--;
	first--;
	cap--;
	}*/
}
