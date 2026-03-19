import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        VendingMachine vm = new VendingMachine(
                "VM01",
                3,
                0,
                5,
                5000,
                7000,
                6000
        );

        System.out.print("Masukkan uang : ");
        double uang = input.nextDouble();              
        if (uang <= 0) {
            System.out.println("Jumlah uang tidak valid.");
            return;
        } else {
            vm.masukkanUang(uang);
        }

        input.nextLine();
        System.out.print("Pilih minuman (teh/kopi/susu) : ");
        String minuman = input.nextLine();
        vm.pilihMinuman(minuman);
    }
}