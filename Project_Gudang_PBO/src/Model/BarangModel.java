package Model;

import Controller.AllObjectModel;
import Entity.BarangEntity;
import Helper.KoneksiDb;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class BarangModel {
    Connection conn = KoneksiDb.getconnection();
    private String sql;
    
    public List<BarangEntity> getDataBarang(){
        return AllObjectModel.barangModel.getBarang();
    }
    public List<BarangEntity> getBarang(){ 
        List<BarangEntity> ListBarang = new ArrayList<>();
        try {
            Statement stat = conn.createStatement();
            sql = "SELECT * FROM barang";
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()) {
                BarangEntity barangEntity = new BarangEntity();
                barangEntity.setId(rs.getString("id"));
                barangEntity.setNama(rs.getString("nama"));
                barangEntity.setJumlah(rs.getString("jumlah"));
                barangEntity.setBerat(rs.getString("berat"));
                barangEntity.setStatus(rs.getInt("status"));
                ListBarang.add(barangEntity);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return ListBarang; //mengembalikan kumpulandata yg  didpt kedlm arraylistBrg
    }
    
    public List<BarangEntity> getBarang(int id){
        List<BarangEntity> arrMahasiswa = new ArrayList<>();
        try {
            sql = "SELECT * FROM barang where id =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
                BarangEntity barangEntity = new BarangEntity();
                
                barangEntity.setId(rs.getString("id"));
                barangEntity.setNama(rs.getString("nama"));
                barangEntity.setJumlah(rs.getString("jumlah"));
                barangEntity.setBerat(rs.getString("berat"));
                barangEntity.setStatus(rs.getInt("status"));
                arrMahasiswa.add(barangEntity);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }return arrMahasiswa;
    }
    
    public void insertData(BarangEntity barangEntity) {
        try {
            sql = "INSERT INTO barang (id, nama, jumlah, berat) Values(?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, barangEntity.getId());
            stat.setString(2, barangEntity.getNama());
            stat.setString(3, barangEntity.getJumlah());
            stat.setString(4, barangEntity.getBerat());
            
            
            
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            System.out.println("GAGAL INPUT DATA!!!");
            e.printStackTrace();
        }
    }
    public DefaultTableModel dataBarang(){
        DefaultTableModel dataBarang = new DefaultTableModel();
        Object[] kolom = {"ID", "NAMA", "JUMLAH", "BERAT", "STATUS"};
        dataBarang.setColumnIdentifiers(kolom);
        int size = getDataBarang().size();
        for(int i = 0; i < size; i++ ){
            Object[] data = new Object[5];
            data[0] = AllObjectModel.barangModel.getBarang().get(i).getId();
            data[1] = AllObjectModel.barangModel.getBarang().get(i).getNama();
            data[2] = AllObjectModel.barangModel.getBarang().get(i).getJumlah();
            data[3] = AllObjectModel.barangModel.getBarang().get(i).getBerat();
            data[4] = AllObjectModel.barangModel.getBarang().get(i).getStatus();
            dataBarang.addRow(data);
        }
        return dataBarang;
    }
    
}