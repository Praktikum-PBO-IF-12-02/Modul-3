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
        saldoMasuk = 0;
        totalPenjualan = 0;
    }

    public void masukkanUang(double jumlah) {
        saldoMasuk += jumlah;
        System.out.println("Input uang : " + jumlah);
        System.out.println("Saldo sekarang : " + saldoMasuk);
    }

    public void pilihMinuman(String jenis) {

        double harga = 0;

        if (jenis.equalsIgnoreCase("teh")) {
            if (stokTeh == 0) {
                System.out.println("Stok teh sudah habis");
                return;
            }
            harga = hargaTeh;
        }

        else if (jenis.equalsIgnoreCase("kopi")) {
            if (stokKopi == 0) {
                System.out.println("Stok kopi sudah habis");
                return;
            }
            harga = hargaKopi;
        }

        else if (jenis.equalsIgnoreCase("susu")) {
            if (stokSusu == 0) {
                System.out.println("Stok susu sudah habis");
                return;
            }
            harga = hargaSusu;
        }

        else {
            System.out.println("Pilihan minuman tidak tersedia");
            return;
        }

        if (saldoMasuk < harga) {
            System.out.println("Saldo tidak mencukupi");
            return;
        }

        saldoMasuk -= harga;
        totalPenjualan += harga;

        if (jenis.equalsIgnoreCase("teh")) stokTeh--;
        if (jenis.equalsIgnoreCase("kopi")) stokKopi--;
        if (jenis.equalsIgnoreCase("susu")) stokSusu--;

        System.out.println("Minuman " + jenis + " berhasil dibeli");

        if (saldoMasuk > 0) {
            System.out.println("Sisa uang : " + saldoMasuk);
            saldoMasuk = 0;
        }
    }

    public void batalkanTransaksi() {
        System.out.println("Transaksi dibatalkan");
        System.out.println("Uang yang dikembalikan : " + saldoMasuk);
        saldoMasuk = 0;
    }

    public void tampilkanStatus() {
        System.out.println("\nStatus Mesin : " + kodeMesin);
        System.out.println("Stok Teh  : " + stokTeh);
        System.out.println("Stok Kopi : " + stokKopi);
        System.out.println("Stok Susu : " + stokSusu);
        System.out.println("Total Penjualan : " + totalPenjualan);
        System.out.println("Saldo Mesin : " + saldoMasuk);
    }
}

public class Main {

    public static void main(String[] args) {

        VendingMachine mesin = new VendingMachine("VM01", 1, 5, 3, 5000, 7000, 6000);

        mesin.masukkanUang(10000);
        mesin.pilihMinuman("teh");      
        mesin.tampilkanStatus();

        mesin.masukkanUang(2000);
        mesin.pilihMinuman("kopi");     
        mesin.tampilkanStatus();

        mesin.masukkanUang(10000);
        mesin.pilihMinuman("teh");      
        mesin.tampilkanStatus();

        mesin.masukkanUang(5000);
        mesin.batalkanTransaksi();      
    }
}