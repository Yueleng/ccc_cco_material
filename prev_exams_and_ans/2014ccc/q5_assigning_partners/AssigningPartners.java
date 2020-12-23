import java.util.HashMap;
import java.util.Scanner;
import java.io.IOException;

public class AssigningPartners {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int numOfStu = Integer.parseInt(sc.nextLine());

        String[] arr1 = sc.nextLine().split(" ");
        String[] arr2 = sc.nextLine().split(" ");

        HashMap<String, String> pairs = new HashMap<>();

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i].equals(arr2[i])) {
                System.out.println("bad");
                return ;
            } else if (pairs.containsKey(arr1[i])) {
                if (!pairs.get(arr1[i]).equals(arr2[i])) {
                    System.out.println("bad");
                    return ;
                }
            } else if (pairs.containsKey(arr2[i])) {
                if (!pairs.get(arr2[i]).equals(arr1[i])) {
                    System.out.println("bad");
                    return ;
                }   
            } else {
            	pairs.put(arr1[i], arr2[i]);
                pairs.put(arr2[i], arr1[i]);
            }
        }

        System.out.println("good");
    }
}

