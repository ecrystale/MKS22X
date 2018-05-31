public class Location implements Comparable<Location>{
    private int x,y;
    private Location previous, start,end;
    private int dist;
    private boolean AStar;
    public Location(int _x, int _y, Location prev){
	x=_x;
	y=_y;
	previous=prev;
    }
    public Location(int _x, int _y, Location prev, Location star, Location en, boolean stary){
	x=_x;
	y=_y;
	previous=prev;
	start=star;
	end=en;
	AStar=stary;
    }

    public int getx(){
	return x;
    }
    public int gety(){
	return y;
    }

    public Location prev(){
	return previous;
    }
    /**
    public int compareTo(Location loc){
	if(dist<loc.distToStart()){
	    return 1;
	}
	if(dist>loc.distToStart()){
	    return -1;
	}
	return 0;
	}*/
    public int distToStart(){
	return distanceToLoc(start);
    }
    public int compareTo(Location other){
	if(AStar==true){
	    return (distToStart()+distToEnd())-(other.distToStart()+other.distToEnd());
	}
	return distToStart()-other.distToStart();
    }
    public int distToEnd(){
	return distanceToLoc(end);
    }
    public int endcompareTo(Location other){
	return distToStart()-other.distToStart();
    }
    public int distanceToLoc(Location other){
	return (int) Math.sqrt(Math.pow(x-other.getx(),2)+Math.pow(y-other.gety(),2));
    }
}
