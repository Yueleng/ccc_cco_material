package class3;

public class ArrayDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		double[] arr = new double[10];
		//0,1,2,3...9
		//arr[0], arr[1], ..., arr[9]
		
		//by default -> all zeros
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		
		System.out.println();
		System.out.println("After modification");
		//0,1,2,3,....
		//1,3,5,7,....
		for(int i = 0; i < arr.length; i++) {
			arr[i] = 2 * i + 1;
		}
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		System.out.println();
		System.out.println("The other way to visit");
		
		for(double d : arr) {//double d = arr[0], [1], [2]...
			System.out.print(d + " ");
		}
		*/
		//arr[1] = 7;
		
		//for(int i = 0; i < arr.length; i++) {
			//System.out.print(arr[i] + " ");
		//}
		
		//String[] strArr = new String[10];
		
		//by default -> all null
		//for(int i = 0; i < strArr.length; i++) {
		//	System.out.print(strArr[i] + " ");
		//}
		
		//null <-> ""
		//System.out.println(strArr[0].length());
		//strArr[0] = "";
		//System.out.println(strArr[0].length());
		
		//strArr[0] = "Hello World";
		
		//for(int i = 0; i < arr.length; i++) {
		//	System.out.print(strArr[i] + " ");
		//}
		
		//boolean[] bArr = new boolean[10];
		//bArr[15] = true;
		//by default -> all false
		//for(int i = 0; i < bArr.length; i++) {
		//	System.out.print(bArr[i] + " ");
		//}
		
		int[][] arr = new int[5][5];
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = i * 10 + j;
			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
