package codelab5;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainProgram {
    static ArrayList<barang> daftarBarang = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Tampilkan Semua Barang");
            System.out.println("3. Barang Masuk");
            System.out.println("4. Barang Keluar");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilihan = input.nextInt();
            input.nextLine(); // bersihkan newline

            switch (pilihan) {
                case 1 -> tambahBarang();
                case 2 -> tampilkanBarang();
                case 3 -> barangMasuk();
                case 4 -> barangKeluar();
                case 0 -> System.out.println("Program selesai.");
                default -> System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);
    }

    static void tambahBarang() {
        System.out.print("Nama barang: ");
        String nama = input.nextLine();
        System.out.print("Jumlah stok awal: ");
        int stok = input.nextInt();
        daftarBarang.add(new barang(nama, stok));
        System.out.println("Barang berhasil ditambahkan.");
    }

    static void tampilkanBarang() {
        if (daftarBarang.isEmpty()) {
            System.out.println("Belum ada barang.");
        } else {
            for (int i = 0; i < daftarBarang.size(); i++) {
                System.out.println((i + 1) + ". " + daftarBarang.get(i));
            }
        }
    }

    static void barangMasuk() {
        tampilkanBarang();
        if (!daftarBarang.isEmpty()) {
            try {
                System.out.print("Pilih nomor barang: ");
                int index = input.nextInt() - 1;
                System.out.print("Jumlah masuk: ");
                int jumlah = input.nextInt();
                daftarBarang.get(index).tambahStok(jumlah);
                System.out.println("Stok berhasil ditambahkan.");
            } catch (Exception e) {
                System.out.println("Input tidak valid!");
            }
        }
    }

    static void barangKeluar() {
        tampilkanBarang();
        if (!daftarBarang.isEmpty()) {
            try {
                System.out.print("Pilih nomor barang: ");
                int index = input.nextInt() - 1;
                System.out.print("Jumlah keluar: ");
                int jumlah = input.nextInt();
                daftarBarang.get(index).kurangiStok(jumlah);
                System.out.println("Stok berhasil dikurangi.");
            } catch (InputMismatchException e) {
                System.out.println("Input harus angka!");
                input.nextLine(); // bersihkan
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
