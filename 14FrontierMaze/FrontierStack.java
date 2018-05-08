public class FrontierStack implements Frontier{
    private Location[] locate=new Location[10];
    private int index=0;
    private int count=0;
    private int cap=10;
    public void add(Location n){
	if(cap==count){
	    resize();
	}
	locate[index]=n;
	index++;
	count++;
    }
    public void resize(){
	Location[] copy=new Location[cap*2+1];
	for(int i=0;i<cap;i++){
	    copy[i]=locate[i];
	}
	cap=cap*2+1;
	locate=copy;
    }
    public Location next(){
	if(hasNext()){
	    count++;
	    return locate[count];
	}
	return null;
    }
    public boolean hasNext(){
	if(locate[count+1]!=null){
	    return true;
	}
	return false;
    }
}
