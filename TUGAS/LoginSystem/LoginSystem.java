import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pilih login:");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Masukkan pilihan: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); // buang newline

        if (pilihan == 1) {
            // Login sebagai Admin
            System.out.print("Masukkan username: ");
            String inputUsername = scanner.nextLine();
            System.out.print("Masukkan password: ");
            String inputPassword = scanner.nextLine();

            Admin admin = new Admin("Admin Name", "511", "naqiy", "umm123");
            if (admin.login(inputUsername, inputPassword)) {
                admin.displayInfo();
            } else {
                System.out.println("Login gagal! Username atau password salah.");
            }

        } else if (pilihan == 2) {
            // Login sebagai Mahasiswa
            System.out.print("Masukkan nama: ");
            String inputNama = scanner.nextLine();
            System.out.print("Masukkan NIM: ");
            String inputNim = scanner.nextLine();

            Mahasiswa mhs = new Mahasiswa("Hilmiy An Naqiy Bilal", "202410370110511");
            if (mhs.login(inputNama, inputNim)) {
                mhs.displayInfo();
            } else {
                System.out.println("Login gagal! Nama atau NIM salah.");
            }

        } else {
            System.out.println("Pilihan tidak valid.");
        }

        scanner.close();
    }
}
