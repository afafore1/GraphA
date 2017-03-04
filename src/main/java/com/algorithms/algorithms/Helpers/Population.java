package com.algorithms.algorithms.Helpers;

import com.algorithms.graph.Node;

import java.util.*;

/**
 * Created by Ayomitunde on 2/27/2017.
 * A population has a set of nodes. These nodes will be shuffled each time to create a group.
 * Example: We can have groups (1 ... 10)
 * We create a tournament within groups to see which is the fittest of all.
 * Assume fittest group consist of 5, 7 and 9.
 * We use this fit group to create another set of population of same size.
 */
public class Population {
    private HashSet<Node> allNodes;
    private Node source;
    public Population(HashSet<Node> allNodes, Node source)
    {
        this.allNodes = allNodes;
        allNodes.remove(source);
        this.source = source;
    }

    /*
    Create different groups of populations using the same set of nodes we have
     */
    public HashMap<Integer, ArrayList<Node>> createPopulationGroup(int size)
    {
        HashMap<Integer, ArrayList<Node>> populationGroup = new HashMap<>();
        for(int i = 0; i < size; i++)
        {
            ArrayList<Node> nodeArrayList = new ArrayList<>(allNodes);
            Collections.shuffle(nodeArrayList);
            nodeArrayList.add(0, source);
            nodeArrayList.add(nodeArrayList.size(), source);
            populationGroup.put(i, nodeArrayList);
        }
        return populationGroup;
    }

    public HashSet<Node> getFittest()
    {
        HashSet<Node> fittest = new HashSet<>();
        return fittest;

    }

}
