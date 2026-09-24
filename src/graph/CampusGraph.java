package graph;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.Queue;
import java.util.LinkedList;
import java.util.HashSet;


public class CampusGraph {

    private HashMap<String, ArrayList<String>> adjacencyList;

    public CampusGraph() {
    adjacencyList = new HashMap<>();
    }

    public void addLocation(String location) {

        if (adjacencyList.containsKey(location)) {

            System.out.println("Location already exists.");
            return;
        }

        adjacencyList.put(location, new ArrayList<>());
    }

    public void removeLocation(String location) {

    adjacencyList.remove(location);

        for (ArrayList<String> neighbours : adjacencyList.values()) {
        neighbours.remove(location);
        }
    }

   public void addConnection(String location1, String location2) {

        if (!adjacencyList.containsKey(location1) ||
            !adjacencyList.containsKey(location2)) {

            System.out.println("One or both locations do not exist.");
            return;
        }

        adjacencyList.get(location1).add(location2);
        adjacencyList.get(location2).add(location1);
    }

public void removeConnection(String location1, String location2) {

if (adjacencyList.containsKey(location1) &&
adjacencyList.containsKey(location2)) {

adjacencyList.get(location1).remove(location2);
adjacencyList.get(location2).remove(location1);
}
}
public void displayConnections() {

for (String location : adjacencyList.keySet()) {

System.out.print(location + " -> ");

for (String neighbour : adjacencyList.get(location)) {
System.out.print(neighbour + " ");
}

System.out.println();
}
}
public void bfsTraversal(String startLocation) {

if (!adjacencyList.containsKey(startLocation)) {
System.out.println("Location not found.");
return;
}

HashSet<String> visited = new HashSet<>();
Queue<String> queue = new LinkedList<>();

visited.add(startLocation);
queue.offer(startLocation);

while (!queue.isEmpty()) {

String current = queue.poll();
System.out.println(current);

for (String neighbour : adjacencyList.get(current)) {

if (!visited.contains(neighbour)) {
visited.add(neighbour);
queue.offer(neighbour);
}
}
}
}

}

