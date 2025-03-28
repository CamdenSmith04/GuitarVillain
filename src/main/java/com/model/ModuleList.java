package com.model;

import java.util.ArrayList;
import java.util.UUID;

/**
 * This class keeps track of all the modules in the program and represents the list of modules.
 * @author Camden Smith
 */
public class ModuleList {
    
    /**
     * This is the singleton of the moduleList object.
     */
    private static ModuleList moduleList;

    /**
     * This is the list of modules in the moduleList.
     */
    private ArrayList<Module> modules;

    /**
     * This constructs the ModuleList object from the JSON files.
     */
    private ModuleList(){
        modules = DataLoader.getModules();
    }

    /**
     * This uses a static method to create the single version of the moduleList.
     * @return the ModuleList moduleList that is the singleton.
     */
    public static ModuleList getInstance() {
        if (moduleList == null) {
            moduleList = new ModuleList();
        }
        return moduleList;
    }

    /**
     * This method adds a Module object to the list of modules.
     * @param module a module to be added to the list of modules.
     */
    public boolean addModule(Module module) {
        if (module == null) {
            return false;
        }
        for (Module match : modules) {
            if (match.equals(module)){
                return false;
            }
        }
        this.modules.add(module);
        return true;
    }

    /**
     * This method gets a Module from the list of modules by title.
     * @param title the title of the module being searched for.
     * @return the Module if it is found in the list of modules.
     */
    public Module getModuleByTitle(String title) {
        for(Module current : modules) {
            if(current.getTitle().equals(title)) {
                return current;
            }
        }
        return null;
    }

    /**
     * This method gets a Module from the list of modules by Id.
     * @param module the UUID of the module being searched for.
     * @return the module if it is found in the list of modules.
     */
    public Module getModuleById(UUID module) {
        for (Module current: modules) {
            if(current.idIsMatch(module)) {
                return current;
            }
        }
        return null;
    }

    /**
     * This is a getter method to get the list of modules in the moduleList object.
     * @return the list of modules.
     */
    public ArrayList<Module> getModules() {
        return this.modules;
    }

    /** 
     * This method deletes/removes a module from the module list if it is found
     * @param module the module object to be deleted/removed.
     */
    public boolean deleteModule(Module module) {
        if (module == null) {
            return false;
        }
        for (Module match : modules) {
            if (match.equals(module)) {
                this.modules.remove(module);
                return true;
            }
        }
        return false;
    }

}
