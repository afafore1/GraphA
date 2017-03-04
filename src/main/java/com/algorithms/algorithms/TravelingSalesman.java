package com.algorithms.algorithms;

import com.algorithms.graph.Node;

import java.util.HashSet;

/**
 * Created by Ayomitunde on 3/2/2017.
 */
public class TravelingSalesman {
    public void runGeneticAlgorithm(HashSet<Node> allNodes, Node source)
    {
        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(allNodes);
        geneticAlgorithm.run(source);
    }

    public void runSimulatedAnnealing(HashSet<Node> allNodes)
    {

    }

    public void runKNearestNeighbors(HashSet<Node> allNodes)
    {

    }
}
