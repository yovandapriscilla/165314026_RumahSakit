/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import helper.DokterHelper;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class testAddNewDokter {
    public static void main(String[] args) throws ParseException {
        try {
            String nama="Dia";
            String spesialis="mata";
            
            DokterHelper helper = new DokterHelper();
            helper.addNewDokter(nama, spesialis);
        } catch (Exception ex) {
            Logger.getLogger(testAddNewDokter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
