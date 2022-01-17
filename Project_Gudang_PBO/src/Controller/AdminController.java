package Controller;

import Model.AllObjectModel;
import Entity.AdminEntity;


public class AdminController implements DataInterface {
    @Override
    public void insertData(String nama, String password, String noTelp){
        AllObjectModel.adminModel.insertData(new AdminEntity(nama,password,noTelp));
    }
    public void deleteData(int id){
        AllObjectModel.adminModel.deleteData(id);
    }
    public void updatePassword(String pass, int id){
            AllObjectModel.adminModel.updatePassword(pass, id);
    }
    public void accBarang(int id){
        AllObjectModel.adminModel.accBarang(id);
    }
    @Override
    public int login(String nama, String password){
        int log = AllObjectModel.adminModel.cekLogin(nama, password);
        return log;
    }
    public void updateData(int urut, String data, int id){
        switch(urut){
            case 1:
                AllObjectModel.adminModel.updateNama(data, id);
                break;
            case 2:
                AllObjectModel.adminModel.updateJumlah(data, id);
                break;
            case 4:
                AllObjectModel.adminModel.updateBerat(data, id);
                break;        
        }
    }

    
}
