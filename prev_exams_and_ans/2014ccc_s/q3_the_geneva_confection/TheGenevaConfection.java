import java.io.*;
import java.util.Stack;

public class TheGenevaConfection {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            int count = Integer.parseInt(br.readLine());
            Stack<Integer> data = new Stack<>();
            for (int j = 0; j < count; j++) {
                int cake = Integer.parseInt(br.readLine());
                data.add(cake);
            }
            Stack<Integer> st = new Stack<>();
            int lakeInt = 0;
            boolean flag = true;
            for (int j = 0; j < count; j++) {
                // int cake = Integer.parseInt(br.readLine());
                int cake = data.pop();
                if (cake == lakeInt + 1) {
                    // drop the cake on the lake 
                    // update lakeInt
                    lakeInt = cake;
                } else {
                    // pop the cake onto the lake
                    while (!st.isEmpty() && st.peek() == lakeInt + 1)
                        lakeInt = st.pop();
                    if ((!st.isEmpty() && st.peek() >= cake + 1) || st.isEmpty())
                        st.add(cake);
                    else if (lakeInt == cake + 1) {
                        lakeInt += 1;
                    } else {
                        // System.out.println(lakeInt);
                        // System.out.println(cake);
                        // if (!st.isEmpty()) {
                        //     System.out.println(st.peek());
                        // }
                        System.out.println("N");
                        flag = false;
                        break;
                    }
                }
            }
            if (flag == true) {
                System.out.println("Y");
            }
        }
        
    }
    
}
