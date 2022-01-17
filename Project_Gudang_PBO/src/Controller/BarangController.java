package Controller;

import Model.AllObjectModel;
import Entity.BarangEntity;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class BarangController implements BarangInterfaces {
   
  
    
    
    public List<BarangEntity> getById(int ceklogin){
        return AllObjectModel.barangModel.getBarang(ceklogin);
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
