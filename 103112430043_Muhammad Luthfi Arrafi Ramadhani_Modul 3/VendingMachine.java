class VendingMachine {
  
    private String kodeMesin;
    private double saldoMasuk;
    private int stokTeh, stokKopi, stokSusu;
    private double hargaTeh, hargaKopi, hargaSusu;
    private int totalPenjualan;

    public VendingMachine(String kodeMesin, int stokTeh, int stokKopi, int stokSusu,
                          double hargaTeh, double hargaKopi, double hargaSusu) {
        this.kodeMesin = kodeMesin;
        this.stokTeh = stokTeh;
        this.stokKopi = stokKopi;
        this.stokSusu = stokSusu;
        this.hargaTeh = hargaTeh;
        this.hargaKopi = hargaKopi;
        this.hargaSusu = hargaSusu;
        this.saldoMasuk = 0;
        this.totalPenjualan = 0;
    }

    public void masukkanUang(double jumlah) {
        if (jumlah > 0) {
            saldoMasuk += jumlah;
            System.out.println("Uang berhasil dimasukkan: " + jumlah);
        } else {
            System.out.println("Jumlah uang tidak valid!");
        }
    }

    public void pilihMinuman(String jenis) {
        double harga = 0;
        boolean stokTersedia = false;

        if (jenis.equalsIgnoreCase("teh")) {
            harga = hargaTeh;
            if (stokTeh > 0) stokTersedia = true;
        } 
        else if (jenis.equalsIgnoreCase("kopi")) {
            harga = hargaKopi;
            if (stokKopi > 0) stokTersedia = true;
        } 
        else if (jenis.equalsIgnoreCase("susu")) {
            harga = hargaSusu;
            if (stokSusu > 0) stokTersedia = true;
        } 
        else {
            System.out.println("Minuman tidak tersedia!");
            return;
        }

        if (!stokTersedia) {
            System.out.println("Transaksi gagal: stok habis!");
            return;
        }

        if (saldoMasuk < harga) {
            System.out.println("Transaksi gagal: uang tidak cukup!");
            return;
        }

        saldoMasuk -= harga;
        totalPenjualan++;

        if (jenis.equalsIgnoreCase("teh")) {
            stokTeh--;
        } else if (jenis.equalsIgnoreCase("kopi")) {
            stokKopi--;
        } else {
            stokSusu--;
        }

        System.out.println("Pembelian " + jenis + " berhasil!");
        System.out.println("Kembalian: " + saldoMasuk);

        saldoMasuk = 0; 
    }

    public void batalkanTransaksi() {
        if (saldoMasuk > 0) {
            System.out.println("Transaksi dibatalkan. Uang dikembalikan: " + saldoMasuk);
            saldoMasuk = 0;
        } else {
            System.out.println("Tidak ada transaksi untuk dibatalkan.");
        }
    }

    public void tampilkanStatus() {
        System.out.println("\n=== STATUS VENDING MACHINE ===");
        System.out.println("Kode Mesin      : " + kodeMesin);
        System.out.println("Stok Teh        : " + stokTeh);
        System.out.println("Stok Kopi       : " + stokKopi);
        System.out.println("Stok Susu       : " + stokSusu);
        System.out.println("Total Penjualan : " + totalPenjualan);
        System.out.println("================================\n");
    }
}