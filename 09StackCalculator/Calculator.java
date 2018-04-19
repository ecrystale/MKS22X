import java.util.*;
public class Calculator{    

    @SuppressWarnings("unchecked")

    public static double eval(String data){

	ArrayList<String> ary=new ArrayList();
	ArrayList<Double> nums=new ArrayList();
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

	double result=0;

	for(int i=0;i<ary.size();i++){
	    if((ary.get(i)).equals("+")){
	        result=nums.get(nums.size()-2)+nums.get(nums.size()-1);
		nums.set(nums.size()-2,result);
		nums.remove(nums.size()-1);
	    }
	    else if((ary.get(i)).equals("-")){
	        result=nums.get(nums.size()-2)-nums.get(nums.size()-1);
		nums.set(nums.size()-2,result);
		nums.remove(nums.size()-1);
	    }
	    else if((ary.get(i)).equals("/")){
	        result=nums.get(nums.size()-2)/nums.get(nums.size()-1);
		nums.set(nums.size()-2,result);
		nums.remove(nums.size()-1);
	    }
	    else if((ary.get(i)).equals("*")){
	        result=nums.get(nums.size()-2)*nums.get(nums.size()-1);
		nums.set(nums.size()-2,result);
		nums.remove(nums.size()-1);
	    }
	    else{
		nums.add(Double.parseDouble(ary.get(i)));
	    }

	}
	return nums.get(0);

    }


    /**
    public static void main(String[] args){
	System.out.println(eval("10 2.0 +"));// is 12.0
	System.out.println(eval("11 3 - 4 + 2.5 *"));// is 30.0
	System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));// is 893.0
	}*/
}
