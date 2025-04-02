package com.model;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * @author Andrew Goad
 */

public class DataLoaderTest {

    DataLoader dataLoader1 = new DataLoader();

    @Before
    public void setup() {

    }

    @After
    public void teardown() {
        
    }            
            
    @Test
    public void testParseModule(){
        try{
            FileReader reader = new FileReader("./songs.json");
            JSONArray modulesJSON = (JSONArray)new JSONParser().parse(reader);

            Module module = dataLoader1.parseModule((JSONObject)modulesJSON.get(0));

            System.out.print(module);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}