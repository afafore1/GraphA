package com.algorithms.algorithms.Helpers;

import com.algorithms.graph.Edge;
import com.algorithms.graph.Node;
import org.apache.commons.lang.builder.HashCodeBuilder;

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
    private HashMap<Integer, Edge> allEdges;
    private Node source;
    private HashMap<Integer, ArrayList<Node>> populationGroups;
    private HashMap<Integer, ArrayList<Node>> fittestGroups;
    public Population(HashSet<Node> allNodes, HashMap<Integer, Edge> allEdges, Node source)
    {
        this.allNodes = allNodes;
        this.allEdges = allEdges;
        allNodes.remove(source);
        this.source = source;
        populationGroups = new HashMap<>();
        fittestGroups = new HashMap<>();
    }

    /*
    Create different groups of populations using the same set of nodes we have
     */
    public void createPopulationGroup(int size)
    {
        for(int i = 0; i < size; i++)
        {
            ArrayList<Node> nodeArrayList = new ArrayList<>(allNodes);
            Collections.shuffle(nodeArrayList);
            nodeArrayList.add(0, source);
            nodeArrayList.add(nodeArrayList.size(), source);
            populationGroups.put(i, nodeArrayList);
        }
    }

    private void getFittest()
    {
        for(Integer key : populationGroups.keySet())
        {
            if(!fittestGroups.containsKey(key))
            {
                ArrayList<Node> group = populationGroups.get(key);
                double rank = rankGroup(group);
            }
        }

    }

    private double rankGroup(ArrayList<Node> group)
    {
        double rank = 0.0;
        for(Node node : group)
        {
            List<Object> neighbors =  node.getNeighbors();
            for(Object object : neighbors)
            {
                Node neighbor = (Node) object;
                int hashCode = new HashCodeBuilder().append(node).append(neighbor).toHashCode();
                double weight = allEdges.get(hashCode).getWeight();
                rank+= weight;
            }
        }
        return rank;
    }

    public HashMap<Integer, ArrayList<Node>> getFittestGroups()
    {
        return fittestGroups;
    }

    public HashMap<Integer, ArrayList<Node>> getPopulationGroups()
    {
        return populationGroups;
    }
}
