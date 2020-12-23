package graph;

import java.util.*;

public class DegreeOfSeparation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<Integer, Set<Integer>> graph = buildGraph();
		
		Scanner sc = new Scanner(System.in);
		
		String command;
		do {
			command = sc.nextLine();
			//"i 20 10"->["i", "20", "10"]
			String[] commands = command.split(" ");
			
			if(commands[0].equals("i")) {
				
				int x = Integer.parseInt(commands[1]);
				int y = Integer.parseInt(commands[2]);
				/*
				if(!graph.containsKey(x)) {
					graph.put(x, new HashSet<>());	
				}*/
				graph.get(x).add(y);
				graph.get(y).add(x);
				
			}else if(command.equals("d")) {
				
				int x = Integer.parseInt(commands[1]);
				int y = Integer.parseInt(commands[2]);
				
				graph.get(x).remove(y);
				graph.get(y).remove(x);
				
			}else if(command.equals("n")) {//n 20
				
				int x = Integer.parseInt(commands[1]);
				System.out.println(graph.get(x).size());
				
			}else if(command.equals("f")) {
				
				int x = Integer.parseInt(commands[1]);
				
				Set<Integer> fof = new HashSet<>();
				Set<Integer> f = graph.get(x);
				
				for(Integer i : graph.get(x)) {
					for(Integer j : graph.get(i)) {
						
						if(j != x && !f.contains(j)) {
							fof.add(j);
						}
					}
				}
				
				System.out.println(fof.size());
				
			}else if(command.equals("s")) {
				int x = Integer.parseInt(commands[1]);
				int y = Integer.parseInt(commands[2]);
				/*
				int dis = shorestDis(graph, x, y);
				
				if(dis == 51) {
					System.out.println("Not connected");
				}else {
					System.out.println(dis);
				}*/
				System.out.println(shorestDis(graph, x, y) == 51 ? 
						"Not connected" : shorestDis(graph, x, y));
			}
			
		}while(!command.equals("q"));

	}
	
	public static int shorestDis(Map<Integer, Set<Integer>> map, int from, int to) {
		
		int[][] graph = new int[50][50];
		
		for(int i = 1; i < 50; i++) {
			for(int j = 1; j < 50; j++) {
				graph[i][j] = 51;
			}
		}
		
		for(int i = 1; i < 50; i++) {
			for(Integer j : map.get(i)) {
				graph[i][j] = 1;
			}
		}
		
		for(int k = 1; k < 50; k++) {
			for(int i = 1; i < 50; i++) {
				for(int j = 1; j < 50; j++) {
					
					if(graph[i][k] + graph[k][j] < graph[i][j]) {
						graph[i][j] = graph[i][k] + graph[k][j];
					}
				}
			}
		}
		
		return graph[from][to];
	}
	
	public static Map<Integer, Set<Integer>> buildGraph(){
		
		Map<Integer, Set<Integer>> graph = new HashMap<>();
		
		for(int i = 1; i < 50; i++) {
			graph.put(i, new HashSet<>());
		}
		
		graph.get(1).add(6);
        graph.get(2).add(6);
        graph.get(3).add(4);
        graph.get(3).add(5);
        graph.get(3).add(6);
        graph.get(3).add(15);
        graph.get(4).add(3);
        graph.get(4).add(5);
        graph.get(4).add(6);
        graph.get(5).add(3);
        graph.get(5).add(4);
        graph.get(5).add(6);
        graph.get(6).add(1);
        graph.get(6).add(2);
        graph.get(6).add(3);
        graph.get(6).add(4);
        graph.get(6).add(5);
        graph.get(6).add(7);
        graph.get(7).add(6);
        graph.get(7).add(8);
        graph.get(8).add(7);
        graph.get(8).add(9);
        graph.get(9).add(8);
        graph.get(9).add(10);
        graph.get(9).add(12);
        graph.get(10).add(9);
        graph.get(10).add(11);
        graph.get(11).add(10);
        graph.get(11).add(12);
        graph.get(12).add(9);
        graph.get(12).add(11);
        graph.get(12).add(13);
        graph.get(13).add(12);
        graph.get(13).add(14);
        graph.get(13).add(15);
        graph.get(14).add(13);
        graph.get(15).add(3);
        graph.get(15).add(13);
        graph.get(16).add(17);
        graph.get(16).add(18);
        graph.get(17).add(16);
        graph.get(17).add(18);
        graph.get(18).add(16);
        graph.get(18).add(17);
		
		return graph;
	}

}
