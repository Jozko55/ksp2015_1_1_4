import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Riesenie {
    public static void main(String[] args) throws FileNotFoundException {
        File subor = new File(args[0]);
        Scanner scanner = null;
        try {
            scanner = new Scanner(subor);
            int pocet_samponov = Integer.parseInt(scanner.nextLine());
            String[]rano = scanner.nextLine().split(" ", -1);
            String[]vecer = scanner.nextLine().split(" ", -1);
            int aktualny_pocet = 0;
            int hladany_pocet = 0;
            for (int i = pocet_samponov - 1; i > - 1 ; i--) {
                aktualny_pocet++;
                if (vecer[i].equals(rano[i])){
                }else{
                    hladany_pocet = aktualny_pocet;
                    rano = odstran_z_pola(rano, Arrays.asList(rano).indexOf(vecer[i]));
                    vecer = odstran_z_pola(vecer, i);
                }
            }
            System.out.println(hladany_pocet);
            System.out.println(pocet_samponov);
        } finally {
            if (scanner != null)
                scanner.close();
        }
    }
    public static String[] odstran_z_pola(String[] pole, int index){
        String[]nove_pole = new String[pole.length - 1];
        System.arraycopy(pole, 0, nove_pole, 0, index);
        System.arraycopy(pole, index + 1, nove_pole, index, pole.length - index - 1);
        return nove_pole;
}
}
