public class Recursion{
    //1.1a: factorial
    public int fact(int n){
	if (n<0){
	    throw new IllegalArgumentException();
	}
	if (n==0){
	    return 1;
	}
	return n*fact(n-1);
    }
    
    //1.1b: Fibonacci
    public int fib(int n){
	if (n<0){
	    throw new IllegalArgumentException();
	}
	return help(n,0,1,0);
    }
    public int help(int n, int count, int place, int total){
	if (n==count){
	    return total;
	}
	return help(n,count+1,place+total,place);
    }


   //1.1c: Square Root
    public double sqrt(double n){
	if (n<0){
	    throw new IllegalArgumentException();
	}
	return guess(n,1);
    }

    public double guess(double n, double g){
	double y=((n/g)+g)/2;
	if (Math.abs(g-y)<0.00001){
	    return y;
	}
	return guess(n,y);
    }

}
