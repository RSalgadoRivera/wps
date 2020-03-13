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
public class RadixSort {

    static void sort(String mac[], String[] dbm) {
        int a[] = new int[dbm.length];
        RadixSort.convertir(dbm, a);
        int i, m = a[0], exp = 1, n = a.length;
        int[] b = new int[a.length];
        int ib;
        String[] ma = new String[mac.length];
        for (i = 1; i < n; i++) {
            if (a[i] > m) {
                m = a[i];
            }
        }
        while (m / exp > 0) {
            int[] temp = new int[10];

            for (i = 0; i < n; i++) {
                temp[(a[i] / exp) % 10]++;
            }
            for (i = 1; i < 10; i++) {
                temp[i] += temp[i - 1];
            }
            for (i = n - 1; i >= 0; i--) {
                ib = --temp[(a[i] / exp) % 10];
                b[ib] = a[i];
                ma[ib] = mac[i];
            }
            for (i = 0; i < n; i++) {
                a[i] = b[i];
                mac[i] = ma[i];
            }
            exp *= 10;
        }
    }

    static void convertir(String dbm[], int a[]) {
        for (int i = 0; i < dbm.length; i++) {
            a[i] = Integer.parseInt(dbm[i]);
        }
    }

    static void separa(String scan[], String mac[], String dbm[]) {
        mac[0] = scan[0];
        int conm = 1, cond = 0;
        for (int i = 1; i < scan.length; i++) {
            if (i % 2 == 0) {
                mac[conm] = scan[i];
                conm++;
            } else {
                dbm[cond] = scan[i];
                cond++;
            }

        }
    }
}
