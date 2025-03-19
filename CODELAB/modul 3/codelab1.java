public class codelab1 {
    static class KarakterGame {
    private final String nama;
    private int kesehatan;

    public KarakterGame(String nama, int kesehatan) {
        this.nama = nama;
        this.kesehatan = kesehatan;
    }

    public String getNama() {
        return nama;
    }

    public int getKesehatan() {
        return kesehatan;
    }

    public void setKesehatan(int kesehatan) {
        this.kesehatan = kesehatan;
    }

    }

    static class Pahlawan extends KarakterGame {
        public Pahlawan(String nama, int kesehatan) {
            super(nama, kesehatan);
        }

        private void serang(KarakterGame target) {
            System.out.println(getNama() + " menyerang " + target.getNama() + " menggunakan Orbital Strike!");
            target.setKesehatan(target.getKesehatan() - 20);
            System.out.println(target.getNama() + " sekarang memiliki kesehatan " + target.getKesehatan());
        }
    }

    static class Musuh extends KarakterGame {
        public Musuh(String nama, int kesehatan) {
            super(nama, kesehatan);
        }

        private void serang(KarakterGame target) {
            System.out.println(getNama() + " menyerang " + target.getNama() + " menggunakan Snake Bite!");
            target.setKesehatan(target.getKesehatan() - 15);
            System.out.println(target.getNama() + " sekarang memiliki kesehatan " + target.getKesehatan());
        }
    }

    public static class Main {
        public static void main(String[] args) {
            Pahlawan brimstone = new Pahlawan("Brimstone", 150);
            Musuh viper = new Musuh("Viper", 200);

            System.out.println("Status awal:");
            System.out.println(brimstone.getNama() + " memiliki kesehatan: " + brimstone.getKesehatan());
            System.out.println(viper.getNama() + " memiliki kesehatan: " + viper.getKesehatan());

            brimstone.serang(viper);
            viper.serang(brimstone);
        }
    }

}
