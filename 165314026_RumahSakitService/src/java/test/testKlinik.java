/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.google.gson.Gson;
import helper.KlinikHelper;
import java.util.List;
import pojos.Klinik;

/**
 *
 * @author ASUS
 */
public class testKlinik {
    public static void main(String[] args) {
        KlinikHelper test = new KlinikHelper();
        List<Klinik> list = test.getAllKlinik();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);
    }
}
