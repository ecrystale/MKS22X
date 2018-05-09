public class FrontierQueue implements Frontier{
    private Location[] locate=new Location[10];
    private int index=9;
    private int count=0;
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
	for(int i=cap;i>0;i--){
	    copy[i]=locate[i];
	}
	cap=cap*2+1;
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
	if(locate[index-1]!=null){
	    return true;
	}
	return false;
    }
}
