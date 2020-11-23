import java.util.Scanner;

public class HelloWorldMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//single line comment
		
		/*	multi-line 
		 * comments*/
		
		/*
		System.out.println("AAA");
		System.out.print("BBB\n");
		System.out.println("CCC");
		System.out.println("\tDDD");
		
		
		System.out.print("\"\"");
		
		System.out.print("\\");
		*/
		
		
		//int
		//double
		//char
		//String
		//boolean
		
		/*
		System.out.println("5");//String
		System.out.println(5);//int
		System.out.println('a');//char
		System.out.println("a");//String
		System.out.println(5<3);
		System.out.println(5>3);
		*/
		
		Scanner sc = new Scanner(System.in);
		
		//System.out.println(sc.next());
		//System.out.println(sc.nextLine());
		//String s = sc.next();
		//System.out.println(s);
		
		//int i = sc.nextInt();
		//int j = sc.nextInt();
		
		//i++;
		// i = i + 1;
		// i += 1;
		// i += 2; i = i + 2;
		//j--;
		// j = j - 1;
		// j -= 1;
		
		//sc.nextLine();
		
		//String s = sc.nextLine();
		
		//System.out.println(i/j);
		//System.out.println(i%j);//mod
		//System.out.println(s);
	
		//double k = i;
		//i = (int)k;//5.0 -> 5 6.5->6
		
		/*
		System.out.println('A');
		System.out.println((int)'A');
		System.out.println('B' - 'A');
		System.out.println('b' - 'a');
		
		System.out.println("Hello" + "World");*/
		
		/*
		System.out.println((int)1.3+2.8);
		System.out.println((int)(1.3+2.3));
		System.out.println(2*5.0);
		System.out.println(10/3);*/
		
		
		//other();
		int x = 3;
		
		//System.out.println(f(x,2));
		//System.out.println((int)Math.pow(2, 5));
		Math.abs(-5);
		Math.min(5, 3);
		Math.max(3, 7);
		
		System.out.println(maxOfThree(10,9,5));
	}

	
	public static int maxOfThree(int a, int b, int c) {
		
		if(a>b) {
			
			if(a>c) {
				//System.out.print(a);
				return a;
			}else {
				//System.out.print(c);
				return c;
			}
			
		}else{
			
			if(b>c) {
				return b;
			}else {
				return c;
			}
			
		}
	
	}
	
	
	//input
	//output return
	public static int f(int a, int b) {
		
		return a+b;
	}
	
	public static void other() {

		System.out.print("Other!");
		
		
	}
}
