package Entity;

public class BarangEntity {
    private String id; 
    private String nama;
    private String jumlah;
    private String berat;
    private int status;
    
    
    public BarangEntity(){};
    
    //mengisi attr encap
    public String getId(){ return id; }
    public String getNama(){return nama; }
    public String getJumlah(){ return jumlah; }
    public String getBerat(){ return berat; }
    public int getStatus() {return status; }
    
    public void setId(String id) { this.id = id; }
    public void setNama(String nama) {this.nama = nama;}
    public void setJumlah(String jumlah) { this.jumlah = jumlah; }
    public void setBerat(String berat) { this.berat = berat; }

    public void setStatus(int status) {this.status = status; }
    
}