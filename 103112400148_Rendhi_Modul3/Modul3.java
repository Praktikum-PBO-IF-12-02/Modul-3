/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.renwxyz.modul3;

/**
 *
 * @author Rendy
 */
public class Modul3 {
    public static void main(String[] args) {
        VendingMachine mesin = new VendingMachine("mesin02", 1, 0, 2, 4000, 6000, 5000);

        mesin.tampilkanStatus();

        mesin.masukkanUang(10000);
        mesin.pilihMinuman("kopi");

        mesin.masukkanUang(2000);
        mesin.pilihMinuman("susu");

        mesin.masukkanUang(5000);
        mesin.pilihMinuman("susu");

        mesin.masukkanUang(8000);
        mesin.batalkanTransaksi();

        mesin.tampilkanStatus();
    }
}
