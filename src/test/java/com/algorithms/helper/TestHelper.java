package com.algorithms.helper;

import com.algorithms.graph.Edge;
import com.algorithms.graph.Graph;
import com.algorithms.graph.Node;
import generators.Parser;
import org.apache.commons.lang.ArrayUtils;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by Ayomitunde on 2/18/2017.
 */
public class TestHelper {
    static final String googleDistanceKey = "AIzaSyBfp-zVuuKZg7xeit-oqvn9uKc5VAXewUg";
    public static Graph createGraph()
    {
        Graph graph = createGraphNodes(7);
        createNeighbors(graph);
        createEdges(graph);
        return graph;
    }

    public static Graph createCompleteGraph(int size)
    {
        Graph graph = createGraphNodes(size);
        createCompleteNeighbors(graph, size);
        return graph;
    }

    public static Graph createStateGraph(int size)
    {
        Graph graph = createGraphNodes(size);
        createCompleteStateNeighbors(graph, size);
        return graph;
    }

    private static Graph createGraphNodes(int size)
    {
        Graph graph = new Graph();
        createNodes(size, graph);
        return graph;
    }

    private static void createNodes(Graph graph)
    {

    }

    private static void createNodes(int numberOfNodes, Graph graph)
    {
        for(int i = 0; i < numberOfNodes; i++)
        {
            graph.createNode(i);
        }
    }

    private static void createNeighbors(Graph graph)
    {
        graph.isBidirectional();
        graph.setNodeNeighbors(0, 1,2,4);
        graph.setNodeNeighbors(1, 2,3);
        graph.setNodeNeighbors(2, 3,4);
        graph.setNodeNeighbors(3, 4,5,6);
        graph.setNodeNeighbors(4, 6);
        graph.setNodeNeighbors(5, 6);
    }

    private static void createCompleteNeighbors(Graph graph, int size)
    {
        graph.isBidirectional();
        for(int i = 0; i < size; i++)
        {
            int [] neighbors = createNeighbors(i, size);
            graph.setNodeNeighbors(i, neighbors);
            for(int x : neighbors)
            {
                graph.createEdge(graph.getNode(i), graph.getNode(x), (Math.random() * 120));
            }
        }
    }

    private static void createCompleteStateNeighbors(Graph graph, int size)
    {
        graph.isBidirectional();
    }

    private static int [] createNeighbors(int currentNode, int size)
    {
        int[] neighbors = new int[size-1];
        int index = 0;
        for(int i = 0; i < size; i++)
        {
            if(i != currentNode) neighbors[index++] = i;
        }
        return neighbors;
    }

    private static void createEdges(Graph graph)
    {
        graph.createEdge(graph.getNode(0), graph.getNode(1), 4.0);
        graph.createEdge(graph.getNode(0), graph.getNode(2), 3.0);
        graph.createEdge(graph.getNode(0), graph.getNode(4), 7.0);
        graph.createEdge(graph.getNode(1), graph.getNode(2), 6.0);
        graph.createEdge(graph.getNode(1), graph.getNode(3), 5.0);
        graph.createEdge(graph.getNode(2), graph.getNode(3), 11.0);
        graph.createEdge(graph.getNode(2), graph.getNode(4), 8.0);
        graph.createEdge(graph.getNode(3), graph.getNode(4), 2.0);
        graph.createEdge(graph.getNode(3), graph.getNode(6), 10.0);
        graph.createEdge(graph.getNode(3), graph.getNode(5), 2.0);
        graph.createEdge(graph.getNode(4), graph.getNode(6), 5.0);
        graph.createEdge(graph.getNode(5), graph.getNode(6), 3.0);
    }
}
