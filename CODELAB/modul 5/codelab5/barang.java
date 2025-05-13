package codelab5;

public class barang {
    private final String nama;
    private int stok;

    public barang(String nama, int stok) {
        this.nama = nama;
        this.stok = stok;
    }

    public void tambahStok(int jumlah) {
        this.stok += jumlah;
    }

    public void kurangiStok(int jumlah) throws Exception {
        if (jumlah > stok) {
            throw new Exception("Stok tidak cukup untuk dikurangi.");
        }
        this.stok -= jumlah;
    }

    @Override
    public String toString() {
        return "Nama: " + nama + ", Stok: " + stok;
    }
}
