<<<<<<< HEAD:src/main/java/com/model/HoldcraftDriver.java
package com.model;
=======
package com.drivers;

import com.facade.*;
import com.model.User;
>>>>>>> holdcraftbranch:src/main/java/com/drivers/HoldcraftDriver.java

public class HoldcraftDriver {
    public static void main(String[] args) {


        Facade facade = new Facade();
        // facade.beginSong("Fur Elise");
        facade.logIn("abbyholdcraft", "thegrasstoucher");
        // System.out.println(facade.getCurrentUser());
        facade.becomeAdmin();
        facade.logout();





    }
}
