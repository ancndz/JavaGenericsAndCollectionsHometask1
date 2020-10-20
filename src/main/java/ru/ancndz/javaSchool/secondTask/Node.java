package ru.ancndz.javaSchool.secondTask;

import java.util.HashSet;
import java.util.Set;

public class Node implements Comparable<Node>{
    private final Set<Node> links = new HashSet<>();
    private final Integer nodeNumber;

    public Node(int nodeNumber) {
        this.nodeNumber = nodeNumber;
    }

    public void addLink(Node linkedNode) {
        this.links.add(linkedNode);
    }

    public int getNodeNumber() {
        return nodeNumber;
    }

    public Set<Node> getLinks() {
        return links;
    }

    @Override
    public int compareTo(Node node) {
        return this.nodeNumber - node.getNodeNumber();
    }
}
