package Controller;

import Entity.BarangEntity;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class BarangController implements BarangInterfaces {
   
  
    public List<BarangEntity> getDataBarang(){
        return AllObjectModel.barangModel.getBarang();
    }
    
    public List<BarangEntity> getById(int ceklogin){
        return AllObjectModel.barangModel.getBarang(ceklogin);
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

    @Override
    public void insertBarang(String id, String nama, String jumlah, String berat) {
        BarangEntity barangEntities = new BarangEntity();
        barangEntities.setId(id);
        barangEntities.setNama(nama);
        barangEntities.setJumlah(jumlah);
        barangEntities.setBerat(berat);
        AllObjectModel.barangModel.insertData(barangEntities);
    }

}
