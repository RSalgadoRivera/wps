/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wps;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rabdos7
 */
public class Verificar {

    public static String verificar() {
        int i = 0;
        String result = "";
        //System.out.println("buscando...");
        do {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Verificar.class.getName()).log(Level.SEVERE, null, ex);
            }
            //System.out.println("buscando...");
            String scan = Scanear.scan();
            String s[] = scan.split(",");
            if (s.length > 4) {
                result = scan;
                //System.out.println(result);
                i = 1;
            } else {
                i = 0;
                scan = "";
            }
        } while (i == 0);

        return result;
    }
}
