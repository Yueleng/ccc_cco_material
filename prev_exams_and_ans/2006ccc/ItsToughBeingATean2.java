import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
public class ItsToughBeingATean2 {
	public static void main(String[]args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<int[]> data = new ArrayList<>();
	    int[] x1 = {1,7};
	    data.add(x1);
	    int[] x2 = {1,4};
	    data.add(x2);
	    int[] x3 = {2,1};
	    data.add(x3);
	    int[] x4 = {3,4};
	    data.add(x4);
	    int[] x5 = {3,5};
	    data.add(x5);
		ArrayList<Integer> finaloutput = new ArrayList<>();
		ArrayList<Integer> tool = new ArrayList<>();
		HashMap<Integer,Integer> list = new HashMap<>();
		HashSet<Integer> lista = new HashSet<>();
		while(true) {
			int data1 = Integer.parseInt(br.readLine());
			int data2 = Integer.parseInt(br.readLine());
			if(data1 == 0 && data2==0) {
				break;
			}
			int[] ar = {data1,data2};
			data.add(ar);
        }
        

		finaloutput.addAll(solve(data,tool,list,lista));
		for(int i = 0;i < finaloutput.size();i++) {
			if(finaloutput.get(i) == 8) {
				System.out.println("Cannot complete these tasks. Going to bed.");
				return;
			}
		}
		for(int i = 0;i < finaloutput.size();i++) {
				System.out.print(finaloutput.get(i) + " ");
		}
	}
	public static ArrayList<Integer> solve(ArrayList<int[]> data,ArrayList<Integer> tool,HashMap<Integer,Integer> list,HashSet<Integer> lista){
		if(tool.size() == 7) {
			return tool;
		}
		for(int i =0;i < data.size();i++) {
            if(!list.containsKey(data.get(i)[1]) && data.get(i)[1] != 0) { 
            list.put(data.get(i)[1],1); // key: event number, value: `before event` count
            }
            if(list.containsKey(data.get(i)[1]) && data.get(i)[1] != 0 ) {
            list.replace(data.get(i)[1],list.get(data.get(i)[1])+1);
            }
        }
        
		for(int i = 0;i < data.size();i++) {
			if(data.get(i)[0] == 0) {
				int w = 1;
				for(int x = 0 ;x < data.size();x++) {
					if(data.get(x)[0] == 0 && data.get(x)[1] == data.get(i)[1]) {
						w++;
					}
				}
				list.remove(data.get(i)[1],w);
			}
        }
        
		int ps = 8;
		for(int i = 1;i <= 7;i++) {
			if(!list.containsKey(i) && i < ps && !lista.contains(i)) {
				ps = i;
			}
		}
		lista.add(ps);
		tool.add(ps);
		for(int i =0;i < data.size();i++ ) {
			for(int x = 0; x < tool.size();x++) {
				if(data.get(i)[0] == tool.get(x)) {
					data.get(i)[0] = 0;
					//System.out.println(data.get(i)[0]);
				}
				if(data.get(i)[1] == tool.get(x)) {
					data.get(i)[1] = 0;
				}
			}
		}
		list.clear();
		return solve(data,tool,list,lista);
	}
}