/**
 *
 * @author wahyuuuwid
 */

class VendingMachine {
    private String kodeMesin;
    private double saldoMasuk;
    private int stokTeh, stokKopi, stokSusu;
    private double hargaTeh, hargaKopi, hargaSusu;
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
        this.saldoMasuk = 0;
        this.totalPenjualan = 0;
    }

    public void masukkanUang(double jumlah) {
        if (jumlah > 0) {
            saldoMasuk += jumlah;
            System.out.println("Uang masuk: " + jumlah);
        } else {
            System.out.println("Jumlah uang tidak valid!");
        }
    }

    public void pilihMinuman(String jenis) {
        double harga = 0;
        boolean tersedia = true;

        switch (jenis.toLowerCase()) {
            case "teh":
                harga = hargaTeh;
                if (stokTeh <= 0) tersedia = false;
                break;
            case "kopi":
                harga = hargaKopi;
                if (stokKopi <= 0) tersedia = false;
                break;
            case "susu":
                harga = hargaSusu;
                if (stokSusu <= 0) tersedia = false;
                break;
            default:
                System.out.println("Minuman tidak tersedia!");
                return;
        }

        if (!tersedia) {
            System.out.println("Stok habis!");
            return;
        }

        if (saldoMasuk < harga) {
            System.out.println("Uang kurang!");
            return;
        }

        if (jenis.equalsIgnoreCase("teh")) {
            stokTeh--;
        }
        else if (jenis.equalsIgnoreCase("kopi")) {
            stokKopi--;
        }
        else if (jenis.equalsIgnoreCase("susu")) {
            stokSusu--;
        }

        totalPenjualan += harga;

        double kembalian = saldoMasuk - harga;
        saldoMasuk = 0;

        System.out.println("Berhasil membeli " + jenis);
        System.out.println("Kembalian: " + kembalian);
    }

    public void batalkanTransaksi() {
        if (saldoMasuk > 0) {
            System.out.println("Transaksi dibatalkan. Uang kembali: " + saldoMasuk);
            saldoMasuk = 0;
        } else {
            System.out.println("Tidak ada transaksi!");
        }
    }

    public void tampilkanStatus() {
        System.out.println("Kode Mesin: " + kodeMesin);
        System.out.println("Stok Teh: " + stokTeh);
        System.out.println("Stok Kopi: " + stokKopi);
        System.out.println("Stok Susu: " + stokSusu);
        System.out.println("Total Penjualan: " + totalPenjualan);
    }
}