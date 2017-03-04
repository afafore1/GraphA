package com.algorithms.algorithms;

import com.algorithms.algorithms.Helpers.Population;
import com.algorithms.graph.Node;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Ayomitunde on 2/25/2017.
 * Use genetic algorithm for TSP ...
 */
class GeneticAlgorithm {

    private HashSet<Node> allNodes;
    GeneticAlgorithm(HashSet<Node> allNodes)
    {
        this.allNodes = allNodes;
    }

    void run(Node source)
    {
        Population population = new Population(allNodes, source);
        HashMap<Integer, ArrayList<Node>> populationGroup = population.createPopulationGroup(10);
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
