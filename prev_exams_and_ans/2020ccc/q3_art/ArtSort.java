import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class ArtSort {

  public static void main(String [] args) throws Exception {

    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    
    in.nextLine();

    String[] input = new String[n];

    for(int i=0; i<n; i++) {
      input[i] = in.nextLine(); // input[i] = in.next();
    }
    in.close();

    ArrayList<Integer> xs = new ArrayList<>();
    ArrayList<Integer> ys = new ArrayList<>();

    for(int i=0; i<n; i++) {
      String x = input[i];
      String[] pointStr = x.split(",");
      xs.add(Integer.parseInt(pointStr[0]));
      ys.add(Integer.parseInt(pointStr[1]));
    }

    Collections.sort(xs);
    Collections.sort(ys);

    System.out.println((xs.get(0)-1) + "," + (ys.get(0)-1));
    System.out.println((xs.get(xs.size()-1)+1) + "," + (ys.get(ys.size()-1)+1));

  }
}
