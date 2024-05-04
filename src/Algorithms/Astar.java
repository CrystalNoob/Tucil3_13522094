package Algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import Datastructure.Node;
import Dictionary.Dictionary;

public class Astar {
	public static List<String> findPath(String start, String end, Set<String> wordSet) throws Exception {
		if (!wordSet.contains(start)) {
			throw new Exception("Start word doesn't!");
		} else if (!wordSet.contains(end)) {
			throw new Exception("End word doesn't exist!");
		}

		PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.getPriority()));
		queue.offer(new Node(start, 0, Heuristic.heuristic(start, end), null));

		Map<String, Node> parent = new HashMap<>();
		Map<String, Integer> cost = new HashMap<>();
		parent.put(start, null);
		cost.put(start, 0);

		while(!queue.isEmpty()) {
			Node currentNode = queue.remove();
			
			if(currentNode.getWord().equals(end)) {
				List<String> path = new ArrayList<>();
				while(currentNode != null) {
					path.add(currentNode.getWord());
					currentNode = parent.get(currentNode.getWord());
				}
				Collections.reverse(path);
				return path;
			}

			for(String neighbor : Dictionary.getNeighbors(currentNode.getWord(), wordSet)) {
				int newCost = cost.get(currentNode.getWord()) + 1;

				if(!cost.containsKey(neighbor) || newCost < cost.get(neighbor)) {
					int priority = newCost + Heuristic.heuristic(neighbor, end); // f(n) = g(n) + h(n)
					queue.offer(new Node(neighbor, newCost, priority, currentNode));
					cost.put(neighbor, newCost);
					parent.put(neighbor, currentNode);
				}
			}
		}
		return null;
	}
}
