package com.algorithms.algorithms;

import com.algorithms.graph.Node;
import com.algorithms.helper.TestHelper;
import generators.Parser;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

import static org.junit.Assert.*;

/**
 * Created by Ayomitunde on 3/2/2017.
 * Cannot really test this since the output is unknown.
 * Perhaps there can be test for other things
 */
public class TravelingSalesmanTest {
    @Test
    public void runGeneticAlgorithm() throws Exception {

    }

    @Test
    public void runSimulatedAnnealing() throws Exception {

    }

    @Test
    public void runKNearestNeighbors() throws Exception {

    }

    public static void main(String [] args)
    {
        HashMap<Integer, Node> allNodes = TestHelper.createNodeMap();
        HashSet<Node> nodes = new HashSet<>();
        for(int key : allNodes.keySet())
        {
            nodes.add(allNodes.get(key));
        }
        Node source = allNodes.get(1);
        TravelingSalesman tsp = new TravelingSalesman();
        tsp.runGeneticAlgorithm(nodes, source);
    }
}