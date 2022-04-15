/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.HashMap;
import java.util.Map;


public class OpzioniSelezionabili {

    private Map<Character, String> tipiFornitori;

    public OpzioniSelezionabili() {
        tipiFornitori = new HashMap<>();
        Character[] k = {'M', 'E', 'X'};
        String[] v = {"Materia Prima", "Utenza", "Altro"};
        for (int i = 0; i < k.length; i++) {
            tipiFornitori.put(k[i], v[i]);
        }
    }

    public Map<Character, String> getTipiFornitori() {
        System.out.println(tipiFornitori);
        return tipiFornitori;
    }

    public void setTipiFornitori(Map<Character, String> tipiFornitori) {
        this.tipiFornitori = tipiFornitori;
    }

}
