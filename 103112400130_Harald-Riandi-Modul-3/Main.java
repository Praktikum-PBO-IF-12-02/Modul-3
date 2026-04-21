class VendingMachine {
    private String kodeMesin;
    private double saldoMasuk;
    private int stokTeh;
    private int stokKopi;
    private int stokSusu;
    private double hargaTeh;
    private double hargaKopi;
    private double hargaSusu;
    private double totalPenjualan;

    public VendingMachine(String kodeMesin, int stokTeh, int stokKopi, int stokSusu, 
                          double hargaTeh, double hargaKopi, double hargaSusu) {
        this.kodeMesin = kodeMesin;
        this.stokTeh = stokTeh;
        this.stokKopi = stokKopi;
        this.stokSusu = stokSusu;
        this.hargaTeh = hargaTeh;
        this.hargaKopi = hargaKopi;
        this.hargaSusu = hargaSusu;
        this.saldoMasuk = 0.0;
        this.totalPenjualan = 0.0;
    }

    public void masukkanUang(double jumlah) {
        if (jumlah <= 0) {
            System.out.println("Error: Jumlah uang tidak valid.");
            return;
        }
        this.saldoMasuk += jumlah;
        System.out.println("Uang masuk: Rp" + jumlah + " | Total Saldo: Rp" + this.saldoMasuk);
    }

    public void pilihMinuman(String jenis) {
        double hargaTerpilih = 0;
        int stokTerpilih = 0;

        jenis = jenis.toLowerCase();

        switch (jenis) {
            case "teh":
                hargaTerpilih = hargaTeh;
                stokTerpilih = stokTeh;
                break;
            case "kopi":
                hargaTerpilih = hargaKopi;
                stokTerpilih = stokKopi;
                break;
            case "susu":
                hargaTerpilih = hargaSusu;
                stokTerpilih = stokSusu;
                break;
            default:
                System.out.println("Error: Minuman tidak valid.");
                return;
        }

        if (stokTerpilih <= 0) {
            System.out.println("Transaksi Gagal: Stok " + jenis + " habis.");
            return;
        }

        if (this.saldoMasuk < hargaTerpilih) {
            System.out.println("Transaksi Gagal: Saldo tidak mencukupi. Harga " + jenis + " adalah Rp" + hargaTerpilih);
            return;
        }

        // Eksekusi Transaksi
        if (jenis.equals("teh")) this.stokTeh--;
        else if (jenis.equals("kopi")) this.stokKopi--;
        else if (jenis.equals("susu")) this.stokSusu--;

        double kembalian = this.saldoMasuk - hargaTerpilih;
        this.totalPenjualan += hargaTerpilih;
        this.saldoMasuk = 0; // Reset saldo setelah transaksi

        System.out.println("Transaksi Berhasil: Mengeluarkan " + jenis + ".");
        System.out.println("Kembalian Anda: Rp" + kembalian);
    }

    public void batalkanTransaksi() {
        if (this.saldoMasuk > 0) {
            System.out.println("Transaksi dibatalkan. Mengembalikan uang: Rp" + this.saldoMasuk);
            this.saldoMasuk = 0;
        } else {
            System.out.println("Tidak ada saldo untuk dikembalikan.");
        }
    }

    public void tampilkanStatus() {
        System.out.println("\n=== STATUS MESIN [" + this.kodeMesin + "] ===");
        System.out.println("Stok Teh  : " + this.stokTeh);
        System.out.println("Stok Kopi : " + this.stokKopi);
        System.out.println("Stok Susu : " + this.stokSusu);
        System.out.println("Saldo Berjalan  : Rp" + this.saldoMasuk);
        System.out.println("Total Penjualan : Rp" + this.totalPenjualan);
        System.out.println("================================\n");
    }
}

public class Main {
    public static void main(String[] args) {
        // Inisialisasi: Kode Mesin, Stok(Teh, Kopi, Susu), Harga(Teh, Kopi, Susu)
        VendingMachine vm = new VendingMachine("VM-01", 1, 5, 5, 5000, 8000, 7000);
        
        vm.tampilkanStatus();

        // Skenario 1: Masukkan uang dan pilih minuman (Sukses)
        System.out.println("--- Skenario 1: Pembelian Berhasil ---");
        vm.masukkanUang(10000);
        vm.pilihMinuman("kopi");

        // Skenario 2: Coba beli saat stok habis
        System.out.println("\n--- Skenario 2: Stok Habis ---");
        vm.masukkanUang(10000);
        vm.pilihMinuman("teh"); // Stok teh sisa 0 karena diinisialisasi 1 dan (asumsi) belum dibeli, tapi mari kita beli dulu
        vm.pilihMinuman("teh"); // Beli teh pertama berhasil (stok menjadi 0)
        vm.masukkanUang(5000);
        vm.pilihMinuman("teh"); // Gagal karena stok 0

        // Skenario 3: Coba beli dengan uang kurang
        System.out.println("\n--- Skenario 3: Uang Kurang ---");
        vm.masukkanUang(2000);
        vm.pilihMinuman("susu");

        // Skenario 4: Batalkan transaksi
        System.out.println("\n--- Skenario 4: Batal Transaksi ---");
        vm.masukkanUang(10000); // Saldo saat ini 2000 (dari skenario 3) + 10000 = 12000
        vm.batalkanTransaksi();

        vm.tampilkanStatus();
    }
}