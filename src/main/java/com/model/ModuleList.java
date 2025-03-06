package com.model;

import java.util.ArrayList;

public class ModuleList {
    
    private static ModuleList moduleList;

    private ArrayList<Module> modules;

    private ModuleList(){

    }

    public static ModuleList getInstance() {
        if (moduleList == null) {
            moduleList = new ModuleList();
        }
        return moduleList;
    }

    public void createModule(Module module) {

    }

    public Module getModule(String title) {
        // TODO: Fix
        return null;
    }

    public void updateModule(Module module) {

    }

    public void deleteModule(Module module) {

    }

    public void save() {
        
    }

}
