/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import helper.PasienHelper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class testAddNewPasien {
    public static void main(String[] args) throws ParseException {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            String tglLahir="19981230";
            Date date = format.parse(tglLahir);
            String noRm="2451";
            String nama="Dia";
            
            PasienHelper helper = new PasienHelper();
            String alamat ="seoul";
            String kelamin ="lelaki";
            helper.addNewPasien(noRm,nama, alamat, noRm, date, kelamin);
        } catch (ParseException ex) {
            Logger.getLogger(testAddNewPasien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
