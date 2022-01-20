package Entity;

public class AdminEntity {
    
    private String nama;
    private String Password;
    private String noTelp;

    public AdminEntity( String nama, String Password,String noTelp) {
        this.nama = nama;
        this.Password = Password;
        this.noTelp = noTelp;
    }
    
    public String getNama() { return nama; }
    public String getPassword() { return Password; }
    public String getNoTelp() { return noTelp; }
    
    public void setNama(String nama) { this.nama = nama; }
    public void setPassword(String Password) { this.Password = Password; }
    public void setNoTelp(String noTelp) { this.noTelp = noTelp; }
}
