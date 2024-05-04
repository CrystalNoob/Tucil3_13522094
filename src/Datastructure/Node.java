package Datastructure;

public class Node {
	private String word;
	private int cost;
	private int priority;
	private Node parent;

	public Node(String word, int cost, int priority, Node parent) {
		this.word = word;
		this.cost = cost;
		this.priority = priority;
		this.parent = parent;
	}

	public String getWord() {
		return this.word;
	}

	public int getCost() {
		return this.cost;
	}

	public int getPriority() {
		return this.priority;
	}

	public Node getParent() {
		return this.parent;
	}
}
