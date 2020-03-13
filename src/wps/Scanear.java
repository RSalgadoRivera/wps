/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author rabdos7
 */
public class Scanear {

    public static String scan() {

        try {
            //String so = System.getProperty("os.name");

            String comando;
            String result = "", line = "";

            comando = "gksudo -m <> /sbin/iwlist wlp3s0 scan";
            Process p = Runtime.getRuntime().exec(comando);

            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = br.readLine()) != null) {
                if (line.indexOf("Address:") > -1) {
                    int a = line.indexOf("Address:");
                    String b = line.substring(a + 9);
                    result += b + ",";
                }
                if (line.indexOf("level=") > -1) {
                    int a = line.indexOf("level=");
                    String b = line.substring(a + 7, a + 9);
                    result += b + ",";
                }
            }

            return result;

        } catch (IOException e) {
            return e.toString();
        }

    }
}
