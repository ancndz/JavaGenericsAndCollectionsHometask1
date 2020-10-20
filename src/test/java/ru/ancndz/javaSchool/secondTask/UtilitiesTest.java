package ru.ancndz.javaSchool.secondTask;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class UtilitiesTest {
    Set<Node> nodeSet;

    /**
     * Создаем список нод, группы будут такими 1-2, 2-3, 4-5, 4-6, 5-7, 6-7, 8, 9-10, 9-11, 10-11
     * В итоге получаем 4 компоненты (1-2-3, 4-5-6-7, 8, 9-10-11)
     */
    @BeforeEach
    void setNodeSet() {
        this.nodeSet = new HashSet<>();

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node11 = new Node(11);

        this.nodeSet.add(node1);
        this.nodeSet.add(node2);
        this.nodeSet.add(node3);
        this.nodeSet.add(node4);
        this.nodeSet.add(node5);
        this.nodeSet.add(node6);
        this.nodeSet.add(node7);
        this.nodeSet.add(node8);
        this.nodeSet.add(node9);
        this.nodeSet.add(node10);
        this.nodeSet.add(node11);

        node1.addLink(node2);
        node2.addLink(node1);
        node2.addLink(node3);
        node3.addLink(node2);

        node4.addLink(node5);
        node4.addLink(node6);
        node5.addLink(node7);
        node5.addLink(node4);
        node6.addLink(node7);
        node6.addLink(node4);
        node7.addLink(node5);
        node7.addLink(node6);

        node9.addLink(node10);
        node9.addLink(node11);
        node10.addLink(node9);
        node10.addLink(node11);
        node11.addLink(node9);
        node11.addLink(node10);

    }

    @Test
    void getListComponents() {
        Utilities utilities = new Utilities(this.nodeSet);

        List<TreeSet<Node>> treeSetList = utilities.getListComponents();

        //количество компонент связности
        Assertions.assertEquals(4, treeSetList.size());

        //размеры компонент связности
        Assertions.assertEquals(3, treeSetList.get(0).size());
        Assertions.assertEquals(1, treeSetList.get(3).size());
    }
}