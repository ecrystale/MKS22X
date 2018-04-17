import java.util.*;
public class Sorts{
    @SuppressWarnings("unchecked") static MyLinkedListImproved<Integer>[] ary=new MyLinkedListImproved[10];
    static Integer amount=0;
    static int index=0;

    public static void radixsort(MyLinkedListImproved<Integer> data){
	for(int i=0;i<10;i++){
	    ary[i]=new MyLinkedListImproved<Integer>();
	}
	Integer num=data.max();
	while(num/10>0){
	    amount++;
	    num=num/10;
	}
	sorting(data);

    }

    public static void sorting(MyLinkedListImproved<Integer> data){
	if(index==0){
	    Integer maxi=data.max();
	    for(int i=0;i<data.size();i++){
		Integer val=data.get(i);
		val=val%10;
		ary[val].add(data.get(i));
	    }
	    index++;
	}
	while(amount>index){
	    runthrough();
	}
    }

    public static void runthrough(){
	for(int i=0;i<10;i++){
	    if(ary[i]!=null){
		Integer maxi=ary[i].max();
		int j=0;
		while(j<ary[i].size()){
		    Integer val=ary[i].get(j);
		    int count=0;
		    while(count<index){
			val=(val-val%10)/10;
		    }
		    val=val%10;
		    if(val!=i){
			ary[val].add(ary[i].get(j));
			ary[i].remove(ary[i].get(j));
		    }
		    else{
			j++;
		    }
		}
	    }	   
	}
	index++;
    }


    public static void radixsortIncludingNegatives(MyLinkedListImproved<Integer> data){ 
	return;
	//either blank method
	//OR
	//radixsort(data)
    }


}
