package Modul3;

public class Main {
    public static void main(String[] args) {

        // Inisialisasi mesin
        VendingMachine mesin = new VendingMachine(
            "VM-TEL-001",
            5, 3000,   // stokTeh = 5, harga Rp 3.000
            0, 5000,   // stokKopi = 0 (habis!), harga Rp 5.000
            3, 7000    // stokSusu = 3, harga Rp 7.000
        );

        mesin.tampilkanStatus();

        // ── Skenario 1: Beli teh dengan uang lebih ──────────────────
        System.out.println("=== Skenario 1: Beli teh (uang lebih) ===");
        mesin.masukkanUang(10000);
        mesin.pilihMinuman("teh");
        mesin.tampilkanStatus();

        // ── Skenario 2: Beli kopi saat stok habis ───────────────────
        System.out.println("=== Skenario 2: Beli kopi (stok habis) ===");
        mesin.masukkanUang(5000);
        mesin.pilihMinuman("kopi");
        mesin.tampilkanStatus();

        // ── Skenario 3: Beli susu dengan uang kurang ────────────────
        System.out.println("=== Skenario 3: Beli susu (uang kurang) ===");
        // Saldo masih ada dari skenario 2 (Rp 5.000), tambah lagi Rp 2.000
        mesin.masukkanUang(2000);   // total saldo = 7.000 — pas untuk susu
        // Ubah contoh agar uang kurang: batalkan dulu, lalu masukkan Rp 2.000 saja
        mesin.batalkanTransaksi();  // kembalikan Rp 7.000 dulu
        mesin.masukkanUang(2000);   // saldo cuma Rp 2.000
        mesin.pilihMinuman("susu"); // gagal, kurang Rp 5.000
        mesin.tampilkanStatus();

        // ── Skenario 4: Batalkan transaksi ──────────────────────────
        System.out.println("=== Skenario 4: Batalkan transaksi ===");
        mesin.masukkanUang(10000);
        System.out.println("[USER] Memilih untuk tidak jadi beli...");
        mesin.batalkanTransaksi();
        mesin.tampilkanStatus();
    }
}
