import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception { 
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        VendingMachine mesinTelU = new VendingMachine("TEL-U-01", 5, 3, 2, 5000, 8000, 7000);
        boolean isRunning = true;

        System.out.println("Vending Machine Telkom University");

        while (isRunning) {
            System.out.println("\nMenu: \n1. Masukkan Uang \n2. Beli \n3. Batal \n4. Status \n5. Keluar");
            System.out.print("Pilih (1-5): ");
            
            int pilihan = Integer.parseInt(reader.readLine());

            switch (pilihan) {
                case 1:
                    System.out.print("Nominal uang: Rp");
                    int uang = Integer.parseInt(reader.readLine());
                    mesinTelU.masukkanUang(uang);
                    break;
                case 2:
                    System.out.print("Pilih minuman (Teh/Kopi/Susu): ");
                    String jenis = reader.readLine();
                    mesinTelU.pilihMinuman(jenis);
                    break;
                case 3:
                    mesinTelU.batalTransaksi();
                    break;
                case 4:
                    mesinTelU.cekStatusMesin();
                    break;
                case 5:
                    System.out.println("Keluar dari program.");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}