package arun.problems.ds.threads;


public class PrintOddEvenNumbersWithTwoThreads {
	
	boolean printEven = true;
	
	public void printEven(int i) throws InterruptedException {
		synchronized (this) {
			if(printEven)
				wait();
			System.out.println(i);
			printEven = true;
			notify();
		}
	}
	
	public void printOdd(int i) throws InterruptedException {
		synchronized (this) {
			if(!printEven)
				wait();
			printEven = false;
			System.out.println(i);
			notify();
		}
	}

	public static void main(String a[]) {
		
		PrintOddEvenNumbersWithTwoThreads printer = new PrintOddEvenNumbersWithTwoThreads();
		
		PrintOdd odd =  new PrintOdd(printer);
		PrintEven even =  new PrintEven(printer);
		
		odd.start();
		even.start();
	}
}

class PrintOdd extends Thread {
	
	public PrintOddEvenNumbersWithTwoThreads printer = null;
	
	public PrintOdd(PrintOddEvenNumbersWithTwoThreads printer) {
		super();
		this.printer =printer;
	}
	
	public void run() {
		for(int i=1; i<10; i = i+2) {
			try {
				printer.printOdd(i);
			} catch (InterruptedException e) {
				System.out.println("Interrupted for i: " + i);
			}
		}
	}
}

class PrintEven extends Thread {
	
	public PrintOddEvenNumbersWithTwoThreads printer = null;
	
	public PrintEven(PrintOddEvenNumbersWithTwoThreads printer) {
		super();
		this.printer =printer;
	}
	
	public void run() {
		for(int i=2; i<=10; i=i+2) {
			try {
				printer.printEven(i);
			} catch (InterruptedException e) {
				System.out.println("Interrupted for i: " + i);
			}
		}
	}
}
