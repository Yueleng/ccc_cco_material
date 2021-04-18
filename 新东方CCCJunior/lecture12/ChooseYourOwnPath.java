package demo3;

import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;



// TREE

public class ChooseYourOwnPath {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int numOfPages = Integer.parseInt(sc.nextLine());
		
		// Initialization of pageArray
		ArrayList<Node> pageArray = new ArrayList<>();
		for (int i = 0; i <= numOfPages; i++) {
//			Node page = new Node();
//			page.setValue(i);
			Node page = new Node(i);
			pageArray.add(page);
		}
		
		// Construct the tree
		for (int i = 1; i <= numOfPages; i++) {
			String[] inputLine = sc.nextLine().split(" ");
			int numOfChildrenForPageI = Integer.parseInt(inputLine[0]);
			
			for (int j = 1; j <= numOfChildrenForPageI; j++) {
				int childIndex = Integer.parseInt(inputLine[j]);
				Node childNode = pageArray.get(childIndex);
				pageArray.get(i).pushChild(childNode);
			}
		}
		
		// do we have all the pages?
		HashSet<Integer> pages = new HashSet<>();
		insertChildIntoPages(pageArray.get(1), pages);
		if (pages.size() == numOfPages) {
			System.out.println("Y");
		} else {
			System.out.println("N");
		}
		
		// find the shotest path;
		ArrayList<Node> nodes = new ArrayList<>();
		nodes.add(pageArray.get(1));
		int level = findShortestPath(nodes, level = 0);
		System.out.println(level);
		
	}
	
	private static void insertChildIntoPages(Node node, HashSet<Integer> pages) {
		if (!pages.contains(node.getValue())) {
			pages.add(node.getValue());
			for (Node child: node.getChildren())
				insertChildIntoPages(child, pages);
		}
	}
	
	private static int findShortestPath(ArrayList<Node> nodes, int level) {
		level++;
		ArrayList<Node> children = new ArrayList<>();
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

class Node {
	private int value;
	private ArrayList<Node> children;
	
	// Constructor 1
	public Node() {
		this.value = 0;
		this.children = new ArrayList<>();
	}
	
	// Constructor 2
	public Node(int value) {
		this.value = value;
		this.children = new ArrayList<>();
	}
	
	// setter
	public void setValue(int value) {
		// validation
		
		this.value = value;
	}
	
	// getter
	public int getValue() {
		return this.value;
	}
	
	
	// get children
	public ArrayList<Node> getChildren() {
		return this.children;
	}
	
	// add a new child
	public void pushChild(Node node) {
		this.children.add(node);
	}
}