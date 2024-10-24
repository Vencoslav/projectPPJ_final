import java.util.Scanner;

public class Main {
    static String text;
    static String vzorek;
    public static int hotovo = 0;
    public static void main(String[] args) {
//        try {
//            Scanner sc = new Scanner(System.in);
//            while (sc.hasNext()) {
//                String radek = sc.next();
//                if (radek != null) {
//                    text = radek;
//                    break;
//                }
//            }
//            while (sc.hasNext()) {
//                String radek = sc.next();
//                if (radek != null) {
//                    vzorek = radek;
//                    break;
//                }
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
        DemonstraceAlgoritmu demonstrace = new DemonstraceAlgoritmu();
        demonstrace.setText("Čím se vyznačuje svobodný software (free software)?");
        demonstrace.setVzorek("software");
        while(hotovo==0){
            demonstrace.provedKrok();
            demonstrace.setPocetKroku(demonstrace.getPocetKroku()+1);
        }
        System.out.println("Počet provedených kroků: " + demonstrace.getPocetKroku());
        if(hotovo == -1){
            System.out.println("nenalezeno");
        } else if (hotovo == 1){
            System.out.println("nalezeno");
        }
//        MainForm mainForm = new MainForm();
//        mainForm.setVisible(true);

//        BruteForceSearch force = new BruteForceSearch("text","vzorek");
//        System.out.println(force);

    }
}