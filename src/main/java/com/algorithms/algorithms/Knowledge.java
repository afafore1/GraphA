package com.algorithms.algorithms;

import com.algorithms.graph.Graph;
import com.algorithms.graph.Node;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by Ayomitunde on 3/25/2017.
 */
public class Knowledge  // I don't know what to call this class yet
{
    private static final String TEXT_DIR = "textFiles/";

    private void generateGraph()
    {
        Graph graph = new Graph();
        ClassLoader classLoader = Knowledge.class.getClassLoader();
        File txtFolder = new File(classLoader.getResource(TEXT_DIR).getFile());
        File txtFile = txtFolder.listFiles()[0];
        String fileName = txtFile.getAbsolutePath();
        try(Stream<String> stream = Files.lines(Paths.get(fileName)))
        {
            stream.forEach(str -> {
                graph.createNode(str);
            });
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public void generateComboGraph(Graph graph)
    {
        for(Node node : graph.getNodeList())
        {

        }
    }

    public static void main (String []args)
    {
        Knowledge knowledge = new Knowledge();
        knowledge.generateGraph();
    }
}
