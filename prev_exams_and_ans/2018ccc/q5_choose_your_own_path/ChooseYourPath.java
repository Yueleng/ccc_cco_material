import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

class Node {
	private int value;
	private ArrayList<Node> children;
	//Constructor
	public Node() {
		this.value = 0;
		this.children = new ArrayList<Node>();
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

	public ArrayList<Node> getChildren() {
		return this.children;
	}

	public void pushChild(Node node) {
		this.children.add(node);
	}

}

public class ChooseYourPath {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numOfPages = Integer.parseInt(br.readLine());
		ArrayList<Node> pageArray = new ArrayList<Node>();
		// String[] connections = new String[numOfPages];
		for (int i = 0; i <= numOfPages; i++) {
			Node page = new Node();
			page.setValue(i);
			pageArray.add(page);
		}
		
		for (int i = 1; i <= numOfPages; i++) {
			String[] inputLine = br.readLine().split(" ");
			int numOfChildrenForPageI = Integer.parseInt(inputLine[0]);
			for (int j = 1; j <= numOfChildrenForPageI; j++) {
				int child = Integer.parseInt(inputLine[j]);
				pageArray.get(i).pushChild(pageArray.get(child));
			}
		}
		
		// do we have all the pages?
		HashSet<Integer> pages = new HashSet<Integer>();
		getReachablePages(pageArray.get(1), pages);
		if (pages.size() == numOfPages) {
			System.out.println("Y");
		} else {
			System.out.println("N");
		}

		ArrayList<Node> nodes = new ArrayList<Node>();
		nodes.add(pageArray.get(1));
		int level = findShortestPath(nodes, 0);
		System.out.println(level);
	}

	public static void getReachablePages(Node node, HashSet<Integer> pages) {
		if (!pages.contains(node.getValue())) {
			pages.add(node.getValue());
			for (Node child: node.getChildren()) {
				getReachablePages(child, pages);
			}
		}	
	}

	public static int findShortestPath(ArrayList<Node> nodes, int level) {
		level++;
		ArrayList<Node> children = new ArrayList<Node>();
		for (Node node: nodes) {
			if (node.getChildren().size() == 0) 
				return level;
			else {
				for (Node child: node.getChildren())
					children.add(child);
			}
		}
		return findShortestPath(children, level);
	}
}
