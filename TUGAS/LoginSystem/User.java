public class User {
    private final String nama;
    private final String nim;

    public User(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public boolean login(String inputNama, String inputNIM) {
        return false; // Akan di-override
    }

    public void displayInfo() {
    }
}
