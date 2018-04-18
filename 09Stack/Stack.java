import java.util.*;
public class Stack{
    static ArrayList ary=new ArrayList();
    static Stack hold=new Stack();
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
	for(int i=0;i<ary.length();i++){
	    hold.push(ary[i]);
	}

    }
}
