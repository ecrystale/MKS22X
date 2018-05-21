public class Location{
    private int x,y;
    private Location previous;
    private int dist;

    public Location(int _x, int _y, Location prev){
	x=_x;
	y=_y;
	previous=prev;
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
	}*//**
    public int distToStart(){
	return maze.start;
    }
    public void setdist(int tostart){
	dist=tostart;
	}*/
    public int distanceToLoc(Location start){
	return (int) Math.sqrt(Math.pow(x-start.getx(),2)+Math.pow(y-start.gety(),2));
    }
}
