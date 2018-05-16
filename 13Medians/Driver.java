public class Driver{
    public static void main(String[] args){
	RunningMedian x=new RunningMedian();
	//	System.out.println(x.getMedian());
	x.add(2);
	System.out.println(x.getMedian());
	x.toStringify();
	x.add(3);
	System.out.println(x.getMedian());
	x.toStringify();
	x.add(5);
	System.out.println(x.getMedian());
	x.toStringify();
	x.add(9);
	System.out.println(x.getMedian());
	x.toStringify();
	x.add(0);
	System.out.println(x.getMedian());
	x.toStringify();
	x.add(0);
	System.out.println(x.getMedian());
	x.toStringify();
	x.add(14);
	System.out.println(x.getMedian());
	x.toStringify();
	x.add(4);
	System.out.println(x.getMedian());
	x.toStringify();
    }
}
