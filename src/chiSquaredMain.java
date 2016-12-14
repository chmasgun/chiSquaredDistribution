
public class chiSquaredMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double lambda=0; // random variable
		int k=3; //degrees of freedom
		while(lambda<3.1){

			// repetitively print out function value
			System.out.println("x= "+lambda+", "+chi(lambda,k));
			
			// iteration with this weird RHS, because of the numerical problems
			lambda=(double)Math.round(10*lambda+1)/10;
			
		}
	}

	
	private static double approxChi(double lambda,double k){
		// This function has similar curve with chi function, however there is no divisor
		return (Math.pow(lambda, k/2-1)*Math.exp(-lambda/2));
	}
	private static double chi(double lambda,double k){
		double res=Math.pow(lambda, k/2-1)*Math.exp(-lambda/2);
		double div=Math.pow(2, k/2)*gamma(k/2);
		return res/div;
	}
	private static double gamma(double k){
		if(k-(int)k==0){
			return factorial(k-1);
		}else if(k-0.5-(int) k==0){
			int a=(int) (k-0.5);
			return factorial(2*a)*Math.sqrt(Math.PI)/(factorial(a)*Math.pow(4, a));
		}else{
			System.out.println("Wrong input for gamma function");
			System.exit(0);
			return k;

		}
	}
	private static int factorial(double n){
		if(n==1){
			return 1;
		}else{
			return (int) (n*factorial(n-1));
		}
	}
}
