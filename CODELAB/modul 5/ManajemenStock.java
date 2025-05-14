import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class ManajemenStok {
    static final String YELLOW = "\033[33m";
    static final String RED = "\033[31m";
    static final String BLUE = "\033[34m";
    static final String RESET = "\033[0m";

    public static void main(String[] args) {
        ArrayList<Barang> daftarBarang = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        daftarBarang.add(new Barang("Pensil", 20));
        daftarBarang.add(new Barang("Parang", 5));

        boolean jalan = true;
        while (jalan) {
            System.out.println(YELLOW+"\n===== Manajemen Barang ATK ====="+RESET);
            System.out.println(BLUE+"1. Tambahkan Barang Baru");
            System.out.println("2. Tampilkan Semua Barang");
            System.out.println("3. Kurangi Stok Barang"+RESET);
            System.out.println(RED+ "0. Keluar"+RESET);
            System.out.print("Pilih opsi: ");

            int pilihan;
            try {
                pilihan = input.nextInt();
                input.nextLine(); // buang enter
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                input.nextLine();
                continue;
            }

            switch (pilihan) {
                case 1:
                    // Tambah Barang
                    System.out.print("Masukkan nama barang: ");
                    String nama = input.nextLine();
                    try {
                        System.out.print("Masukkan stok awal: ");
                        int stok = input.nextInt();
                        input.nextLine();
                        daftarBarang.add(new Barang(nama, stok));
                        System.out.println("Barang '" + nama + "' berhasil ditambahkan.");
                    } catch (InputMismatchException e) {
                        System.out.println("Input stok harus berupa angka!");
                        input.nextLine();
                    }
                    break;

                case 2:
                    // Tampilkan Semua Barang
                    if (daftarBarang.isEmpty()) {
                        System.out.println("Stok barang kosong.");
                    } else {
                        for (int i = 0; i < daftarBarang.size(); i++) {
                            Barang b = daftarBarang.get(i);
                            System.out.println(i + ". " + b.getNama() + " - Stok: " + b.getStok());
                        }
                    }
                    break;

                case 3:
                    // Kurangi Stok Barang
                    if (daftarBarang.isEmpty()) {
                        System.out.println("Tidak ada barang dalam daftar.");
                        break;
                    }

                    for (int i = 0; i < daftarBarang.size(); i++) {
                        Barang b = daftarBarang.get(i);
                        System.out.println(i + ". " + b.getNama() + " - Stok: " + b.getStok());
                    }

                    try {
                        System.out.print("Pilih nomor barang: ");
                        int indeks = input.nextInt();
                        System.out.print("Masukkan jumlah pengurangan stok: ");
                        int kurang = input.nextInt();
                        input.nextLine();

                        Barang barangTerpilih = daftarBarang.get(indeks);
                        if (kurang > barangTerpilih.getStok()) {
                            throw new stocktidakcukup("Stok tidak mencukupi!");
                        }

                        barangTerpilih.setStok(barangTerpilih.getStok() - kurang);
                        System.out.println("Stok berhasil dikurangi.");
                    } catch (InputMismatchException e) {
                        System.out.println("Input indeks atau jumlah harus berupa angka!");
                        input.nextLine();
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Indeks tidak valid!");
                        input.nextLine();
                    } catch (stocktidakcukup e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 0:
                    jalan = false;
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Opsi tidak dikenali.");
                    break;
            }
        }

        input.close();
    }
}