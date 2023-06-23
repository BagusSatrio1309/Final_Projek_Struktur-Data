import java.util.Scanner;

class Barang {
    String nama;
    int harga;

    public Barang(String nama, int harga) {
        this.nama = nama;
        this.harga = harga;
    }
}

class LinkedList {
    Barang[] daftarBarang;
    int jumlahBarang;

    public LinkedList(int capacity) {
        daftarBarang = new Barang[capacity];
        jumlahBarang = 0;
    }

    public void tambahBarang(Barang barang) {
        if (jumlahBarang < daftarBarang.length) {
            daftarBarang[jumlahBarang] = barang;
            jumlahBarang++;
            System.out.println("Barang ditambahkan ke daftar.");
        } else {
            System.out.println("Daftar barang penuh.");
        }
    }

    public void cetakDaftarBarang() {
        if (jumlahBarang == 0) {
            System.out.println("Daftar barang kosong.");
        } else {
            System.out.println("Daftar Barang:");
            for (int i = 0; i < jumlahBarang; i++) {
                System.out.println("Nama: " + daftarBarang[i].nama + ", Harga: " + daftarBarang[i].harga);
            }
        }
    }

    public void cariBarang(String nama) {
        if (jumlahBarang == 0) {
            System.out.println("Daftar barang kosong.");
        } else {
            boolean found = false;
            for (int i = 0; i < jumlahBarang; i++) {
                if (daftarBarang[i].nama.equalsIgnoreCase(nama)) {
                    System.out.println("Barang ditemukan:");
                    System.out.println("Nama: " + daftarBarang[i].nama + ", Harga: " + daftarBarang[i].harga);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Barang tidak ditemukan.");
            }
        }
    }

    public void urutkanBarang() {
        if (jumlahBarang == 0) {
            System.out.println("Daftar barang kosong.");
        } else {
            // Menggunakan algoritma Bubble Sort
            for (int i = 0; i < jumlahBarang - 1; i++) {
                for (int j = 0; j < jumlahBarang - i - 1; j++) {
                    if (daftarBarang[j].harga > daftarBarang[j + 1].harga) {
                        Barang temp = daftarBarang[j];
                        daftarBarang[j] = daftarBarang[j + 1];
                        daftarBarang[j + 1] = temp;
                    }
                }
            }

            System.out.println("Daftar barang setelah diurutkan berdasarkan harga:");
            for (int i = 0; i < jumlahBarang; i++) {
                System.out.println("Nama: " + daftarBarang[i].nama + ", Harga: " + daftarBarang[i].harga);
            }
        }
    }
}

public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList daftarBarang = new LinkedList(10);

        int pilihan = 0;
        while (pilihan != 5) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Cetak Daftar Barang");
            System.out.println("3. Cari Barang");
            System.out.println("4. Urutkan Barang");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");
            pilihan = input.nextInt();
            input.nextLine(); // Membersihkan newline character

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama barang: ");
                    String namaBarang = input.nextLine();
                    System.out.print("Masukkan harga barang: ");
                    int hargaBarang = input.nextInt();
                    input.nextLine(); // Membersihkan newline character
                    Barang barang = new Barang(namaBarang, hargaBarang);
                    daftarBarang.tambahBarang(barang);
                    break;
                case 2:
                    daftarBarang.cetakDaftarBarang();
                    break;
                case 3:
                    System.out.print("Masukkan nama barang yang akan dicari: ");
                    String cariBarang = input.nextLine();
                    daftarBarang.cariBarang(cariBarang);
                    break;
                case 4:
                    daftarBarang.urutkanBarang();
                    break;
                case 5:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih menu (1-5).");
            }
        }
        input.close();
    }
}