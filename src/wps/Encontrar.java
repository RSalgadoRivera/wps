/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wps;

/**
 *
 * @author rabdos7
 */
public class Encontrar {
    public static String area(String s)
    {
    String a="";
    String scan[]=s.split(",");
    String mac[]=new String[scan.length/2];
    String dbm[]=new String [mac.length];
    
    RadixSort.separa(scan, mac, dbm);
    
    RadixSort.sort(mac, dbm);
    
    MysqlConnect conn = new MysqlConnect();
        for (String mac1 : mac) {
            a = conn.consulta(mac1);
            //System.out.println(a);
            if (a!=null) {
                break;
            }
        }
    conn.desconectar();
    
    return a;
    }
}
