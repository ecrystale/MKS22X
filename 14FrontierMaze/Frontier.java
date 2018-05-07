public interface Frontier{
    private ary[] locate;
    private int index;
    private int count;
    private int cap;
    public Frontier(){
	locate=new ary[10];
	index=0;
	count=0;
	cap=10;
    }
    public Location next(){
	if(hasNext()){
	    count++;
	    return locate[count];
	}
    }
    public void add(Location n){
	if(cap==index){

	}
	locate[index]=n;
	index++;
    }
    public boolean hasNext(){
	if(locate[count+1]!=null){
	    return true;
	}
	return false;
    }
}
