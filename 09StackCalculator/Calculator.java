import java.util.*;
@SuppressWarnings("unchecked")
public class Calculator{    
    private static ArrayList<String> ary=new ArrayList();
    private static ArrayList<Double> nums=new ArrayList();
    // static Stack hold=new Stack();
    public static void eval(String data){
        //ary=new ArrayList();
	int index=0;
	for(int i=0;i<data.length();i++){
	    if((data.substring(i,i+1)).equals(" ")){
		ary.add(data.substring(index,i));
		index=i+1;
	    }
	}
	String toSolve="";
	double result=0;
	for(int i=0;i<ary.size();i++){
	    System.out.println(ary.get(i));
	    if((ary.get(i)).equals("+")){
		result=nums.get(0)+nums.get(1);
		nums.set(0,result);
		nums.remove(1);
		//nums.remove(i-1);
	    }
	    if((ary.get(i)).equals("-")){
	        result=nums.get(0)-nums.get(1);
		nums.set(0,result);
		nums.remove(1);
	    }
	    if((ary.get(i)).equals("/")){
	        result=nums.get(0)/nums.get(1);
		nums.set(0,result);
		nums.remove(1);
	    }
	    if((ary.get(i)).equals("*")){
	        result=nums.get(0)*nums.get(1);
		nums.set(0,result);
		nums.remove(1);
	    }
	    else{
		nums.add(i,Double.parseDouble(ary.get(i)));
	    }
	    /**
	    if((ary.get(i)).equals("+") || (ary.get(i)).equals("-") || (ary.get(i)).equals("/") || (ary.get(i)).equals("*")){
		String first=toSolve.substring(0,toSolve.length()-1);
		String last=toSolve.substring(toSolve.length()-1,toSolve.length());
		toSolve="("+first+(ary.get(i))+last+")";
		}
	    else{
		toSolve+=(ary.get(i));
		}*/

	}
	    //System.out.println(toSolve);
	    System.out.println(result);

    }



    public static void main(String[] args){
	eval("10 2.0 +");// is 12.0
	eval("11 3 - 4 + 2.5 *");// is 30.0
	eval("8 2 + 99 9 - * 2 + 9 -");// is 893.0
    }
}
