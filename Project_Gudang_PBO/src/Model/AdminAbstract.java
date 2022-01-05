/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Helper.KoneksiDb;
import java.sql.Connection;


public abstract class AdminAbstract {
    Connection conn = KoneksiDb.getconnection();
     public abstract void updatePassword(String password, int id);
    public abstract int cekLogin(String nama, String Password);
}
