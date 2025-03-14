public class codelab2 { static class RekeningBank {
    private final String nomorRekening;
    private final String namaPemilik;
    private double saldo;

    public RekeningBank(String nomorRekening, String namaPemilik, double saldo) {
        this.nomorRekening = nomorRekening;
        this.namaPemilik = namaPemilik;
        this.saldo = saldo;
    }

    public void tampilkanInfo() {
        System.out.println("Nomor Rekening: " + nomorRekening);
        System.out.println("Nama Pemilik: " + namaPemilik);
        System.out.println("Saldo: Rp" + saldo);
        System.out.println();
    }

    public void setorUang(double jumlah) {
        saldo += jumlah;
        System.out.println(namaPemilik + " menyetor Rp" + jumlah + ". Saldo sekarang: Rp" + saldo);
    }

    public void tarikUang(double jumlah) {
        if (saldo >= jumlah) {
            saldo -= jumlah;
            System.out.println(namaPemilik + " menarik Rp" + jumlah + ". (Berhasil) Saldo sekarang: Rp" + saldo);
        } else {
            System.out.println(namaPemilik + " menarik Rp" + jumlah + ". (Gagal, Saldo tidak mencukupi) Saldo saat ini: Rp" + saldo);
        }
    }
}

    public static class Main {
        public static void main(String[] args) {
            RekeningBank rekening1 = new RekeningBank("202310370311129", "Rehan", 500000);
            RekeningBank rekening2 = new RekeningBank("202310370311307", "Sabita", 1000000);

            rekening1.tampilkanInfo();
            rekening2.tampilkanInfo();

            rekening1.setorUang(200000);
            rekening2.setorUang(500000);

            rekening1.tarikUang(800000);
            rekening2.tarikUang(300000);

            rekening1.tampilkanInfo();
            rekening2.tampilkanInfo();
        }
    }

}
