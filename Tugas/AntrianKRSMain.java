package Tugas;

import java.util.Scanner;

public class AntrianKRSMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AntrianKRS antrian = new AntrianKRS(10, 30);
        int pilihan;

        do {
            System.out.println("\n=== Menu Antrian KRS ===");
            System.out.println("1.  Tambah Mahasiswa ke Antrian");
            System.out.println("2.  Panggil Antrian (2 Mahasiswa)");
            System.out.println("3.  Tampilkan Semua Antrian");
            System.out.println("4.  Tampilkan 2 Antrian Terdepan");
            System.out.println("5.  Tampilkan Antrian Paling Akhir");
            System.out.println("6.  Cetak Jumlah Antrian");
            System.out.println("7.  Cetak Jumlah Sudah KRS");
            System.out.println("8.  Cetak Jumlah Belum KRS");
            System.out.println("9.  Cek Antrian Kosong");
            System.out.println("10. Cek Antrian Penuh");
            System.out.println("11. Kosongkan Antrian");
            System.out.println("0.  Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt(); sc.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("NIM    : ");
                    String nim = sc.nextLine();
                    System.out.print("Nama   : ");
                    String nama = sc.nextLine();
                    System.out.print("Prodi  : ");
                    String prodi = sc.nextLine();
                    System.out.print("Kelas  : ");
                    String kelas = sc.nextLine();
                    antrian.tambahAntrian(new MahasiswaKRS(nim, nama, prodi, kelas));
                    break;
                case 2:
                    antrian.panggilAntrian();
                    break;
                case 3:
                    antrian.tampilkanSemua();
                    break;
                case 4:
                    antrian.tampilkanDuaTerdepan();
                    break;
                case 5:
                    antrian.tampilkanPalingAkhir();
                    break;
                case 6:
                    antrian.cetakJumlahAntrian();
                    break;
                case 7:
                    antrian.cetakSudahKRS();
                    break;
                case 8:
                    antrian.cetakBelumKRS();
                    break;
                case 9:
                    System.out.println(antrian.IsEmpty() ? "Antrian kosong." : "Antrian tidak kosong.");
                    break;
                case 10:
                    System.out.println(antrian.IsFull() ? "Antrian penuh." : "Antrian belum penuh.");
                    break;
                case 11:
                    antrian.kosongkanAntrian();
                    break;
                case 0:
                    System.out.println("Terima kasih.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);
        sc.close();
    }
}