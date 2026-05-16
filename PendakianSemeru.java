import java.util.Scanner;

public class PendakianSemeru {
    public static void main(String[] args) {
        int[][] peta = {
            {3, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 1, 2, 1, 0, 1, 0}, 
            {0, 1, 1, 1, 0, 2, 0, 0, 0, 0, 1, 0}, 
            {0, 2, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0}, 
            {0, 0, 1, 0, 0, 1, 2, 1, 1, 1, 1, 0}, 
            {2, 0, 1, 2, 0, 1, 0, 0, 0, 0, 0, 2}  
        };

        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan Tenaga Awal: ");
        int tenaga = sc.nextInt();
        System.out.print("Masukkan Jalur: ");
        String jalur = sc.next().toUpperCase();

        int baris = 5;
        int kolom = 11;
        boolean masukJurang = false;
        boolean istirahatIlegal = false;

        for (char langkah : jalur.toCharArray()) {
            if (langkah == '.') {
 
                if (peta[baris][kolom] == 2 || peta[baris][kolom] == 3 || (baris == 5 && kolom == 11)) {
                    tenaga += 10;
                } else {
                    istirahatIlegal = true;
                    break;
                }
                continue;
            }

            if (langkah == 'L') kolom--;
            else if (langkah == 'R') kolom++;
            else if (langkah == 'U') baris--;
            else if (langkah == 'D') baris++;

            tenaga -= 1;
            if (baris < 0 || baris > 5 || kolom < 0 || kolom > 11 || peta[baris][kolom] == 1) {
                masukJurang = true;
                break;
            }
            
            if (tenaga < 0) break;
        }

        if (istirahatIlegal) {
            System.out.println("Mohon maaf, istirahat hanya diperbolehkan di Pos-pos yang tersedia");
        } else if (masukJurang) {
            System.out.println("Jalur anda salah, anda masuk ke jurang di[" + baris + "," + kolom + "]");
        } else if (tenaga < 0) {
            System.out.println("Jalur anda benar, tapi tenaga anda tidak akan kuat, coba jalur lain atau sempatkan istirahat terlebih dahulu");
        } else if (peta[baris][kolom] == 3) {
            System.out.println("Selamat Pendakian anda berhasil mencapai Puncak Mahameru, sisa tenaga anda " + tenaga);
        } else {
            System.out.println("Anda belum sampai ke Puncak, posisi terakhir anda di [" + baris + "," + kolom + "]");
        }
        
        sc.close();
    }
}