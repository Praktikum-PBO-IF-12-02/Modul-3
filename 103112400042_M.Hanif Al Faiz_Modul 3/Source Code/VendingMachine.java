public class VendingMachine {
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
        if (jumlah > 0) {
            this.saldoMasuk += jumlah;
            System.out.println("Berhasil memasukkan uang: Rp" + jumlah + ". Saldo saat ini: Rp" + this.saldoMasuk);
        } else {
            System.out.println("Jumlah uang tidak valid. Saldo tidak boleh negatif.");
        }
    }

    public void pilihMinuman(String jenis) {
        double harga = 0;
        int stok = 0;

        jenis = jenis.toLowerCase();
        
        if (jenis.equals("teh")) {
            harga = hargaTeh;
            stok = stokTeh;
        } else if (jenis.equals("kopi")) {
            harga = hargaKopi;
            stok = stokKopi;
        } else if (jenis.equals("susu")) {
            harga = hargaSusu;
            stok = stokSusu;
        } else {
            System.out.println("Transaksi Gagal: Minuman '" + jenis + "' tidak tersedia di mesin ini.");
            return;
        }

        if (stok <= 0) {
            System.out.println("Transaksi Gagal: Stok " + jenis + " sudah habis.");
            return;
        }

        if (saldoMasuk < harga) {
            System.out.println("Transaksi Gagal: Saldo tidak mencukupi untuk membeli " + jenis + ". Harga: Rp" + harga + ", Saldo: Rp" + saldoMasuk);
            return;
        }

        if (jenis.equals("teh")) stokTeh--;
        else if (jenis.equals("kopi")) stokKopi--;
        else if (jenis.equals("susu")) stokSusu--;

        saldoMasuk -= harga;
        totalPenjualan += harga;
        
        System.out.println("Transaksi Berhasil: Anda membeli " + jenis + ".");
        
        if (saldoMasuk > 0) {
            System.out.println("Mengembalikan kembalian Anda sejumlah: Rp" + saldoMasuk);
            saldoMasuk = 0;
        }
    }

    public void batalkanTransaksi() {
        if (saldoMasuk > 0) {
            System.out.println("Transaksi dibatalkan. Mengembalikan uang Anda sejumlah: Rp" + saldoMasuk);
            saldoMasuk = 0;
        } else {
            System.out.println("Tidak ada transaksi yang bisa dibatalkan (Saldo Rp0).");
        }
    }

    public void tampilkanStatus() {
        System.out.println("\n=== Status Vending Machine [" + kodeMesin + "] ===");
        System.out.println("Stok Teh  : " + stokTeh + " | Harga: Rp" + hargaTeh);
        System.out.println("Stok Kopi : " + stokKopi + " | Harga: Rp" + hargaKopi);
        System.out.println("Stok Susu : " + stokSusu + " | Harga: Rp" + hargaSusu);
        System.out.println("Saldo Berjalan  : Rp" + saldoMasuk);
        System.out.println("Total Penjualan : Rp" + totalPenjualan);
        System.out.println("=========================================\n");
    }
}