package com.algorithms.algorithms;

import java.io.File;

/**
 * Created by Ayomitunde on 3/25/2017.
 */
public class Knowledge  // I don't know what to call this class yet
{
    private static final String TEXT_DIR = "textFiles/";
    private void generateGraph()
    {
        ClassLoader classLoader = Knowledge.class.getClassLoader();
        File txtFile = new File(classLoader.getResource(TEXT_DIR).getFile());
        
    }
}
