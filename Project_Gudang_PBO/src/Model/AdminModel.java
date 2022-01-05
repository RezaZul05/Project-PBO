package Model;

import Entity.AdminEntity;
import java.sql.*;

public class AdminModel extends AdminAbstract{
    private String sql;
    public void insertData(AdminEntity AdminEntity){
        try {
            sql = "INSERT INTO admin (nama, password, noTelp) Values(?,?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, AdminEntity.getNama());
            stat.setString(2, AdminEntity.getPassword());
            stat.setString(3, AdminEntity.getNoTelp());
            stat.executeUpdate();
        } catch(SQLException e) {
            System.out.println("GAGAL INPUT DATA!!!");
            System.out.println(e);
        }
    }
    
    @Override
    public void updatePassword(String password, int id){
        try {
            sql = "update admin SET password =? WHERE id =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, password);
            stat.setInt(2, id);
            stat.executeUpdate();
        } catch(SQLException e) {
            System.out.println("GAGAL RUBAH PASSWORD!!!");
            System.out.println(e);
        }
    }
    
    @Override
    public int cekLogin(String nama, String password){
        int cek = 0;
        try {
            sql = "SELECT * FROM admin where nama = ? and password = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, nama);
            stat.setString(2, password);
            ResultSet rs = stat.executeQuery();
            if(rs.next()){
               cek = rs.getInt("id");
            } else {
                cek = 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } return cek;
    }
    public void accBarang(int id){
        try {
            sql = "update barang SET status = 1 WHERE id =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteData(int id){
        try {
            sql = "DELETE FROM barang where id =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            stat.executeUpdate();
        } catch (SQLException e) {
            System.out.println("GAGAL Hapus DATA!!!");
        }
    }
    public void updateNama(String nama, int id){
        try{
            sql = "update barang SET nama =? WHERE id =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, nama);
            stat.setInt(2, id);
            stat.executeUpdate();
        } catch (SQLException e){
            System.out.println("GAGAL RUBAH NAMA!!!");
            e.printStackTrace();
        }
    }
    
    public void updateJumlah(String jumlah, int id){
        try{
            sql = "update barang SET jumlah =? WHERE id =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, jumlah);
            stat.setInt(2, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e){
            System.out.println("GAGAL RUBAH JUMLAH!!!");
            e.printStackTrace();
        }
    }
    
    public void updateBerat(String berat, int id){
        try{
            sql = "update barang SET berat =? WHERE id =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, berat);
            stat.setInt(2, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e){
            System.out.println("GAGAL RUBAH BERAT!!!");
            e.printStackTrace();
        }
    }
}