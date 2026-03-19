/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.renwxyz.modul3;

/**
 *
 * @author Rendy
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
            System.out.println("Saldo masuk: Rp" + jumlah);
            System.out.println("Total saldo: Rp" + saldoMasuk);
        } else {
            System.out.println("Nominal tidak valid!");
        }
    }

    public void pilihMinuman(String jenis) {
        if (jenis.equalsIgnoreCase("teh")) {
            if (stokTeh == 0) {
                System.out.println("Stok teh habis!");
                return;
            }
            if (saldoMasuk < hargaTeh) {
                System.out.println("Uang tidak cukup untuk membeli teh!");
                return;
            }
            stokTeh--;
            totalPenjualan += hargaTeh;
            double kembalian = saldoMasuk - hargaTeh;
            saldoMasuk = 0;
            System.out.println("Teh berhasil dibeli.");
            System.out.println("Kembalian: Rp" + kembalian);

        } else if (jenis.equalsIgnoreCase("kopi")) {
            if (stokKopi == 0) {
                System.out.println("Stok kopi habis!");
                return;
            }
            if (saldoMasuk < hargaKopi) {
                System.out.println("Uang tidak cukup untuk membeli kopi!");
                return;
            }
            stokKopi--;
            totalPenjualan += hargaKopi;
            double kembalian = saldoMasuk - hargaKopi;
            saldoMasuk = 0;
            System.out.println("Kopi berhasil dibeli.");
            System.out.println("Kembalian: Rp" + kembalian);

        } else if (jenis.equalsIgnoreCase("susu")) {
            if (stokSusu == 0) {
                System.out.println("Stok susu habis!");
                return;
            }
            if (saldoMasuk < hargaSusu) {
                System.out.println("Uang tidak cukup untuk membeli susu!");
                return;
            }
            stokSusu--;
            totalPenjualan += hargaSusu;
            double kembalian = saldoMasuk - hargaSusu;
            saldoMasuk = 0;
            System.out.println("Susu berhasil dibeli.");
            System.out.println("Kembalian: Rp" + kembalian);

        } else {
            System.out.println("Minuman " + jenis + " tidak tersedia!");
        }
    }

    public void batalkanTransaksi() {
        if (saldoMasuk > 0) {
            System.out.println("Transaksi dibatalkan.");
            System.out.println("Uang dikembalikan: Rp" + saldoMasuk);
            saldoMasuk = 0;
        } else {
            System.out.println("Tidak ada saldo yang bisa dibatalkan.");
        }
    }

    public void tampilkanStatus() {
        System.out.println("=== Status Mesin ===");
        System.out.println("Kode Mesin     : " + kodeMesin);
        System.out.println("Stok Teh       : " + stokTeh);
        System.out.println("Stok Kopi      : " + stokKopi);
        System.out.println("Stok Susu      : " + stokSusu);
        System.out.println("Total Penjualan: Rp" + totalPenjualan);
        System.out.println("====================");
    }
}