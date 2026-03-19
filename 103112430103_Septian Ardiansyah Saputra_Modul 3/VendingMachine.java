import java.util.Scanner;

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

    public VendingMachine(String kodeMesin, int stokTeh, int stokKopi, int stokSusu, double hargaTeh, double hargaKopi, double hargaSusu) {
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
            System.out.println("Uang masuk : " + jumlah);
        }
    }

    public void pilihMinuman(String jenis) {
        Scanner input = new Scanner(System.in);

        switch (jenis.toLowerCase()) {

            case "teh":
                if (stokTeh <= 0) {
                    System.out.println("Stok teh habis!");
                } else if (saldoMasuk < hargaTeh) {
                    System.out.println("Uang tidak cukup untuk membeli teh.");
                } else {
                    System.out.println("Apakah Anda yakin ingin membeli teh? (y/n)");
                    String konfirmasi = input.nextLine();
                    boolean batal = konfirmasi.equalsIgnoreCase("n");   
                    if (batal) {
                        batalkanTransaksi();
                    } else {
                        stokTeh--;
                        saldoMasuk -= hargaTeh;
                        totalPenjualan += hargaTeh;
                        System.out.println("Berhasil membeli teh!");
                        kembalian();
                    }
                }
                break;

            case "kopi":
                if (stokKopi <= 0) {
                    System.out.println("Stok kopi habis!");
                } else if (saldoMasuk < hargaKopi) {
                    System.out.println("Uang tidak cukup untuk membeli kopi.");
                } else {
                    System.out.println("Apakah Anda yakin ingin membeli kopi? (y/n)");
                    String konfirmasi = input.nextLine();
                    boolean batal = konfirmasi.equalsIgnoreCase("n");   
                    if (batal) {
                        batalkanTransaksi();
                    } else {
                        stokKopi--;
                        saldoMasuk -= hargaKopi;
                        totalPenjualan += hargaKopi;
                        System.out.println("Berhasil membeli kopi!");
                        kembalian();
                    }
                }
                break;

            case "susu":
                if (stokSusu <= 0) {
                    System.out.println("Stok susu habis!");
                } else if (saldoMasuk < hargaSusu) {
                    System.out.println("Uang tidak cukup untuk membeli susu.");
                } else {
                    System.out.println("Apakah Anda yakin ingin membeli susu? (y/n)");
                    String konfirmasi = input.nextLine();
                    boolean batal = konfirmasi.equalsIgnoreCase("n");   
                    if (batal) {
                        batalkanTransaksi();
                    } else {
                        stokSusu--;
                        saldoMasuk -= hargaSusu;
                        totalPenjualan += hargaSusu;
                        System.out.println("Berhasil membeli susu!");
                        kembalian();
                    }
                }
                break;
                
            default:
                System.out.println("Minuman tidak tersedia.");
        }
    }

    private void kembalian() {
        if (saldoMasuk > 0) {
            System.out.println("Kembalian : " + saldoMasuk);
            saldoMasuk = 0;
        }
    }

    public void batalkanTransaksi() {
        if (saldoMasuk > 0) {
            System.out.println("Transaksi dibatalkan.");
            System.out.println("Uang dikembalikan : " + saldoMasuk);
            saldoMasuk = 0;
        } else {
            System.out.println("Tidak ada transaksi untuk dibatalkan.");
        }
    }

    public void tampilkanStatus() {
        System.out.println("\n=== STATUS VENDING MACHINE ===");
        System.out.println("Kode Mesin : " + kodeMesin);
        System.out.println("Stok Teh   : " + stokTeh);
        System.out.println("Stok Kopi  : " + stokKopi);
        System.out.println("Stok Susu  : " + stokSusu);
        System.out.println("Total Penjualan : " + totalPenjualan);
        System.out.println("==============================\n");
    }
}