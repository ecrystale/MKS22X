import java.util.*;
public class Calculator{
    private static ArrayList ary=new ArrayList();;
    
    // static Stack hold=new Stack();
    @SuppressWarnings("unchecked")
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
	    if((ary.get(i)).equals("+")){
		result=ary.get(i-1)+ary.get(i-2);
		ary.set(i,result);
		ary.remove(i-2);
		ary.remove(i-1);
	    }
	    if((ary.get(i)).equals("-")){
		result=ary.get(i-1)-ary.get(i-2);
		ary.set(i,result);
		ary.remove(i-2);
		ary.remove(i-1);
	    }
	    if((ary.get(i)).equals("/")){
		result=ary.get(i-1)/ary.get(i-2);
		ary.set(i,result);
		ary.remove(i-2);
		ary.remove(i-1);
	    }
	    if((ary.get(i)).equals("*")){
		result=ary.get(i-1)*ary.get(i-2);
		ary.set(i,result);
		ary.remove(i-2);
		ary.remove(i-1);
	    }
	    else{
		ary.set(i,Double.parseDouble(ary.get(i));
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
