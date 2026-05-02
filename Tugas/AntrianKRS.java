package Tugas;

public class AntrianKRS {
    MahasiswaKRS[] data;
    int front;
    int rear;
    int size;
    int max;
    int sudahKRS;
    int maxDilayani;

    public AntrianKRS(int max, int maxDilayani) {
        this.max = max;
        this.maxDilayani = maxDilayani;
        this.data = new MahasiswaKRS[max];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
        this.sudahKRS = 0;
    }

    public boolean IsEmpty() {
        return size == 0;
    }

    public boolean IsFull() {
        return size == max;
    }

    public void kosongkanAntrian() {
        for (int i = 0; i < max; i++) {
            data[i] = null;
        }
        front = 0;
        rear = -1;
        size = 0;
        System.out.println("Semua antrian berhasil dikosongkan.");
    }

    public void tambahAntrian(MahasiswaKRS mhs) {
        if (IsFull()) {
            System.out.println("Antrian penuh! Maksimal " + max + " mahasiswa.");
            return;
        }
        if (sudahKRS >= maxDilayani) {
            System.out.println("DPA sudah menangani " + maxDilayani + " mahasiswa. Sesi selesai.");
            return;
        }
        rear = (rear + 1) % max;
        data[rear] = mhs;
        size++;
        System.out.println(mhs.nama + " berhasil masuk ke antrian.");
    }

    public void panggilAntrian() {
        if (IsEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("=== Memanggil 2 Mahasiswa untuk Proses KRS ===");
        int dipanggil = 0;
        while (dipanggil < 2 && !IsEmpty()) {
            if (sudahKRS >= maxDilayani) {
                System.out.println("DPA sudah mencapai batas " + maxDilayani + " mahasiswa.");
                break;
            }
            MahasiswaKRS mhs = data[front];
            data[front] = null;
            front = (front + 1) % max;
            size--;
            sudahKRS++;
            System.out.print(sudahKRS + ". ");
            mhs.tampilkanData();
            dipanggil++;
        }
        if (dipanggil == 1) {
            System.out.println("Hanya 1 mahasiswa tersisa yang dipanggil.");
        }
    }

    public void tampilkanSemua() {
        if (IsEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("=== Semua Antrian KRS ===");
        System.out.println("NIM - NAMA - PRODI - KELAS");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % max;
            System.out.print((i + 1) + ". ");
            data[index].tampilkanData();
        }
    }

    public void tampilkanDuaTerdepan() {
        if (IsEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("=== 2 Antrian Terdepan ===");
        System.out.println("NIM - NAMA - PRODI - KELAS");
        int tampil = Math.min(2, size);
        for (int i = 0; i < tampil; i++) {
            int index = (front + i) % max;
            System.out.print((i + 1) + ". ");
            data[index].tampilkanData();
        }
    }

    public void tampilkanPalingAkhir() {
        if (IsEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.println("=== Antrian Paling Akhir ===");
            System.out.print("-> ");
            data[rear].tampilkanData();
        }
    }

    public void cetakJumlahAntrian() {
        System.out.println("Jumlah mahasiswa dalam antrian : " + size);
    }

    public void cetakSudahKRS() {
        System.out.println("Jumlah sudah KRS               : " + sudahKRS);
    }

    public void cetakBelumKRS() {
        int belum = maxDilayani - sudahKRS;
        if (belum < 0) belum = 0;
        System.out.println("Jumlah belum KRS (sisa kuota)  : " + belum);
    }
}