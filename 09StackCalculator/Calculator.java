import java.util.*;
import java.io.*;
public class Calculator{    

    @SuppressWarnings("unchecked")

    public static double eval(String data){

	LinkedList<String> ary=new LinkedList();
	LinkedList<Double> nums=new LinkedList();
	int index=0;

	for(int i=0;i<data.length()+1;i++){
	    if(i==data.length()){
		ary.add(data.substring(index,i));
	    }
	    else if((data.substring(i,i+1)).equals(" ")){
		ary.add(data.substring(index,i));
		index=i+1;
	    }
	}

	double result=Double.parseDouble(ary.get(0));

	for(int i=0;i<ary.size();i++){
	    double second;
	    if((ary.get(i)).equals("+")){
	        result=nums.pop()+nums.pop();
		nums.push(result);
	    }
	    else if((ary.get(i)).equals("-")){
		second=nums.pop();
	        result=nums.pop()-second;
		nums.push(result);
	    }
	    else if((ary.get(i)).equals("/")){
		second=nums.pop();
	        result=nums.pop()/second;
		nums.push(result);
	    }
	    else if((ary.get(i)).equals("*")){
	        result=nums.pop()*nums.pop();
		nums.push(result);
	    }
	    else{
		nums.push(Double.parseDouble(ary.get(i)));
	    }

	}
	return nums.get(nums.size()-1);

    }


}
