package ru.ancndz.javaSchool.secondTask;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Utilities {
    final private Set<Node> nodeSet;
    private final List<TreeSet<Node>> treeSetList;

    public Utilities(Set<Node> nodeSet) {
        this.nodeSet = nodeSet;
        this.treeSetList = new LinkedList<>();
    }

    /**
     * Процедура формирования списка компонент связности
     * @return Список, где каждый элемент - компонента связности
     */
    public List<TreeSet<Node>> getListComponents() {
        for (Node eachNode: this.nodeSet) {
            TreeSet<Node> treeSet = getContainedTree(eachNode);
            treeSet.add(eachNode);
            treeSet.addAll(eachNode.getLinks());
        }
        return this.treeSetList;
    }


    /**
     * Проверка, существует ли нода в уже созданной компоненте
     * @param node - проверяемая нода
     * @return если существует, возвращается эта нода, если нет - создается новая
     */
    private TreeSet<Node> getContainedTree(Node node) {
        for (TreeSet<Node> eachTree : this.treeSetList) {
            if (eachTree.contains(node)) {
                return eachTree;
            }
        }
        TreeSet<Node> blankTree = new TreeSet<>();
        this.treeSetList.add(blankTree);
        return blankTree;
    }
}
