package com.thrs;



import com.thrs.controllers.MenuController;
import com.thrs.vistas.MenuTemplate;
import javax.swing.SwingUtilities;

/**
 *
 * @author Usuario
 */
public class Main {
    
    public static void main(String[] args) {
        Runnable runApplication = new Runnable() {
            @Override
            public void run() {
                MenuController menu = new MenuController();
                menu.getClass();
            }
        };
        SwingUtilities.invokeLater(runApplication);
    }
    
}
