package main;

import perpustakaan.*;

class Main {
    public static void main(String[] args) {
        perpustakaan.Buku nonFiksi = new perpustakaan.NonFiksi("Madilog oleh Tan Malaka", "Tan Malaka", "Sejarah & Ilmu Pengetahuan");
        perpustakaan.Buku fiksi = new perpustakaan.Fiksi("Sang Putri Kelapa oleh Lilis Hu", "Lilis Hu", "Dongeng");

        nonFiksi.displayInfo();
        fiksi.displayInfo();

        perpustakaan.Anggota anggota1 = new perpustakaan.Anggota("Wahyu Andhika (NIM: D01)", "D01");
        perpustakaan.Anggota anggota2 = new perpustakaan.Anggota("Ega Faiz (NIM: D02)", "D02");

        anggota1.pinjamBuku("Madilog");
        anggota2.pinjamBuku("Halimunet: Sang Putri Kelapa", 7);

        anggota1.kembalikanBuku("Madilog");
        anggota2.kembalikanBuku("Halimunet: Sang Putri Kelapa");
    }
}
