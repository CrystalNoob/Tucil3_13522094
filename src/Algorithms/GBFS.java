package Algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import Datastructure.Node;
import Dictionary.Dictionary;

public class GBFS {
	public static List<String> findPath(String start, String end, Set<String> wordSet) throws Exception {
		if (!wordSet.contains(start)) {
			throw new Exception("Start word doesn't exist!");
		} else if (!wordSet.contains(end)) {
			throw new Exception("End word doesn't exist!");
		}

		PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.getPriority()));
		queue.offer(new Node(start, 0, Heuristic.heuristic(start, end), null));

		int totalNode = 0;
		Set<String> visited = new HashSet<>();
		Map<String, Node> parent = new HashMap<>();
		parent.put(start, null);

		while (!queue.isEmpty()) {
			Node currentNode = queue.remove();
			totalNode++;
			visited.add(currentNode.getWord());

			if (currentNode.getWord().equals(end)) {
				List<String> path = new ArrayList<>();
				while (currentNode != null) {
					path.add(currentNode.getWord());
					currentNode = parent.get(currentNode.getWord());
				}
				Collections.reverse(path);
				System.out.println("Node Visited: " + totalNode);
				return path;
			}

			for (String neighbor : Dictionary.getNeighbors(currentNode.getWord(), wordSet)) {
				if (!visited.contains(neighbor)) {
					int priority = Heuristic.heuristic(neighbor, end);	// f(n) = h(n)
					queue.offer(new Node(neighbor, 0, priority, null));
					parent.put(neighbor, currentNode);
				}
			}
		}
		System.out.println("Node Visited: " + totalNode);
		return null;
	}
}
