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
	if (n==0){
	    return 0;
	}
	if (n==1){
	    return 1;
	}
	return fib(n-1)+fib(n-2);
    }

    //1.1c: Square Root
    public double sqrt(double n){

    }

public 

}
