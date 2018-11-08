/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import helper.KlinikHelper;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class testAddNewKlinik {
    public static void main(String[] args) throws ParseException {
        try {
            String idKlinik="2509";
            String nama="gembel Akut";
            String spesialis="hati Akut";
            
            KlinikHelper helper = new KlinikHelper();
            helper.addNewKlinik(idKlinik, nama, spesialis);
        } catch (Exception ex) {
            Logger.getLogger(testAddNewDokter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
