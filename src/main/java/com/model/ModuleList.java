package com.model;

import java.util.ArrayList;

public class ModuleList {
    
    private static ModuleList moduleList;
    private ArrayList<Module> modules;

    private ModuleList(){
        modules = DataLoader.getModules();
    }

    public static ModuleList getInstance() {
        if (moduleList == null) {
            moduleList = new ModuleList();
        }
        return moduleList;
    }

    // TODO: Make sure user can be created :)
    public void addModule(Module module) {
        modules.add(module);
    }

    public Module getModule(String title) {
        for(Module current : modules) {
            if(current.getTitle().equals(title)) {
                return current;
            }
        }
        return null;
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public void updateModule(Module module) {

    }

    public void deleteModule(Module module) {
        for(Module current : modules) {
            if(current.isMatch(module)) {
                modules.remove(current);
                return;
            }
        }
    }

    public void save() {
        
    }

}
