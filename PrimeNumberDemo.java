import java.util.Scanner;
class PrimeNumberDemo{
	//Q. what is a Prime Number?
	//Ans. a number that is divisible only by itself and 1 (e.g. 2, 3, 5, 7, 11).
	
	public static boolean isPrime(int num){
		if(num<2){
			return false;
		}
		for(int i=2;i<num/i;i++){
			if(num%i==0){
				return false;
			}
		}
		return true;
	}
	public static void findPrimes(int limit){
		double startTime = System.nanoTime();
		int pc=0;
		for(int i=1;i<limit;i++){
			if(isPrime(i)){
				pc++;
				System.out.println(i);
			}
		}
		double endTime = System.nanoTime();
		System.out.println("total prime numbers between 1 and "+limit+" = "+pc);
		double diff = endTime - startTime;
		System.out.println("time taken : "+(diff/1000000000)+" seconds");
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		/*System.out.println("Enter a number : ");
		int a = sc.nextInt();
		if(isPrime(a)){
			System.out.println(a+" is a prime.");
		}else{
			System.out.println(a+" is not a prime.");
		}
		*/
		System.out.println("Enter limit : ");
		int limit = sc.nextInt();
		findPrimes(limit);
	}
}