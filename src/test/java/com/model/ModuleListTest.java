package com.model;
import java.util.ArrayList;
import java.util.UUID;

import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * @author Camden Smith
 */
public class ModuleListTest {
    
    ModuleList moduleList = ModuleList.getInstance();
    ArrayList<Module> modules = moduleList.getModules();
    

    @Before
    public void setup() {
        modules.clear();
        modules.add(new Module("Module 1"));
        modules.add(new Module("Module 2"));
        modules.add(new Module("Module 3"));
        DataWriter.saveModules();
    }

    @After
    public void teardown() {
        moduleList.getInstance().getModules().clear();
        DataWriter.saveModules();
    }

    @Test
    public void testAddModuleNull() {
        boolean success = moduleList.addModule(null);
        assertFalse(success);
    }

    @Test
    public void testAddModuleExistingModule() {
        Module module = moduleList.getModuleByTitle("Module 1");
        boolean success = moduleList.addModule(module);
        assertFalse(success);
    }

    @Test
    public void testAddModuleValid() {
        Module module = new Module("Title");
        boolean success = moduleList.addModule(module);
        assertTrue(success);
    }

    @Test
    public void testGetModuleByTitleNull() {
        Module module = moduleList.getModuleByTitle(null);
        assertEquals(module, null);
    }

    @Test
    public void testGetModuleByTitleNotFound() {
        Module module = moduleList.getModuleByTitle("Invalid title");
        assertEquals(module, null);
    }

    @Test
    public void testGetModuleByTitleValid() {
        Module module = moduleList.getModuleByTitle("Module 1");
        assertEquals(modules.get(0), module);
    }

    @Test
    public void testGetModuleByUUIDNotFound() {
        UUID id = UUID.randomUUID();
        Module module = moduleList.getModuleById(id);
        assertEquals(module, null);

    }

    @Test
    public void testGetModuleByUUIDValid() {
        UUID id = modules.get(0).getId();
        Module module = moduleList.getModuleById(id);
        assertEquals(module, modules.get(0));
    }

    @Test
    public void testDeleteModuleNull() {
        boolean success = moduleList.deleteModule(null);
        assertFalse(success);
    }

    @Test
    public void testDeleteModuleExistingModule() {
        Module module = moduleList.getModuleByTitle("Module 1");
        boolean success = moduleList.deleteModule(module);
        assertTrue(success);
    }

    @Test
    public void testDeleteModuleNotFound() {
        Module module = new Module("Title");
        boolean success = moduleList.deleteModule(module);
        assertFalse(success);
    }

}
