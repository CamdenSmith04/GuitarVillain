package com.drivers;

import com.facade.*;
import com.dataManagers.*;

public class HoldcraftDriver {
    public static void main(String[] args) {


        Facade facade = new Facade();
        facade.beginSong("Fur Elise");
        DataWriter.save();



    }
}
