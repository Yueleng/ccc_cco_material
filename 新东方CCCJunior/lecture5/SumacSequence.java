import java.util.ArrayList;
import java.util.Scanner;

public class SumacSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> sequence = new ArrayList<>();
		
		sequence.add(sc.nextInt());
		sequence.add(sc.nextInt());
		
		int i = 0;
		
		while(sequence.get(i) >= sequence.get(i+1)) {
			sequence.add(sequence.get(i) - sequence.get(i+1));
			i++;
		}
		
		/*
		for(int num : sequence) {
			System.out.print(num + "->");
		}*/
		
		System.out.println(sequence.size());

	}

}
