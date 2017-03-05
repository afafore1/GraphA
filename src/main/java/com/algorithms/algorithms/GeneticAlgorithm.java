package com.algorithms.algorithms;

import com.algorithms.algorithms.Helpers.Population;
import com.algorithms.graph.Edge;
import com.algorithms.graph.Node;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Ayomitunde on 2/25/2017.
 * Use genetic algorithm for TSP ...
 */
class GeneticAlgorithm {

    private HashSet<Node> allNodes;
    private HashMap<Integer, Edge> allEdges;
    GeneticAlgorithm(HashSet<Node> allNodes, HashMap<Integer, Edge> allEdges)
    {
        this.allNodes = allNodes;
        this.allEdges = allEdges;
    }

    void run(Node source)
    {
        Population population = new Population(allNodes, allEdges, source);
        population.createPopulationGroup(10);
        HashMap<Integer, ArrayList<Node>> populationGroup = population.getPopulationGroups();
        for(int key : populationGroup.keySet())
        {
            System.out.println("SET");
            System.out.println("========================================");
            System.out.println("========================================");
            ArrayList<Node> nodeHashSet = populationGroup.get(key);
            for(Node node : nodeHashSet)
            {
                System.out.println(node.getId());
            }
        }
    }


}
