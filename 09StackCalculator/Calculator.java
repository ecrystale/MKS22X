import java.util.*;
public class Calculator{
    private static ArrayList ary=new ArrayList();
    // static Stack hold=new Stack();
    public static void eval(String data){
	int index=0;
	for(int i=0;i<data.length();i++){
	    if((data.substring(i,i+1)).equals(" ")){
		ary.add(data.substring(index,i));
		index=i+1;
	    }
	}
	solve();
    }

    public static void solve(){
	String toSolve="";
	double result=0;
	for(int i=0;i<ary.size();i++){
	    if((ary.get(i)).equals("+") || (ary.get(i)).equals("-") || (ary.get(i)).equals("/") || (ary.get(i)).equals("*")){
		String first=toSolve.substring(0,toSolve.length()-1);
		String last=toSolve.substring(toSolve.length()-1,toSolve.length());
		toSolve="("+first+(ary.get(i))+last+")";
	    }
	    else{
		toSolve+=(ary.get(i));
	    }
	    // hold.push(ary[i]);
	}
	System.out.println(toSolve);
/**
	for(int i=0;i<toSolve.length();i++){
	    if((ary.get(i)).equals("+") || (ary.get(i)).equals("-") || (ary.get(i)).equals("/") || (ary.get(i)).equals("*")){
		result=
		}*/
	/**while(hold.empty!=true){
	    if(peek()=="+"){

	    }
	    }*/
    }

    public static void main(String[] args){
	eval("10 2.0 +");// is 12.0
	eval("11 3 - 4 + 2.5 *");// is 30.0
	eval("8 2 + 99 9 - * 2 + 9 -");// is 893.0
    }
}
