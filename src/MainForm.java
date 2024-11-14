import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame{
    private JTextField tfVzorek;
    private JButton nextButton;
    private JTextField tfText;
    private JPanel panelMain;
    private JButton fastBt;

    private JButton btStep;
    private JTextArea taPopis;
    private JButton resetButton;
    public static int hotovo = 0;

    public JTextField getTfText() {
        return tfText;
    }

    public void setTfText(JTextField tfText) {
        this.tfText = tfText;
    }

    public MainForm(){

        setContentPane(panelMain);
        DemonstraceAlgoritmu demonstrace = new DemonstraceAlgoritmu(tfText, tfVzorek);
//        demonstrace.setText("ab");
//        demonstrace.setVzorek("b");
        setTitle("D.A.BF.S., s. r. o.");
        setSize(1000,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        resetButton.addActionListener(e -> {
            demonstrace.reset();
        });
        /*nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                demonstrace.setVzorek("software");
//                demonstrace.setText("Čím se vyznačuje svobodný software (free software)?");
                demonstrace.setVzorek(tfVzorek.getText());
                demonstrace.setText(tfText.getText());
                if (hotovo == 0){
                    popisKroku(demonstrace, true);
                    demonstrace.provedKrok();
                    demonstrace.setPocetKroku(demonstrace.getPocetKroku()+1);
                    //demonstrace.provedKrok();
                }
                System.out.println("Počet provedených kroků: " + demonstrace.getPocetKroku());
                if(hotovo == -1){
                    JOptionPane.showMessageDialog(panelMain,"nenalezeno");
//                    System.out.println("nenalezeno");
                } else if (hotovo == 1){
                    JOptionPane.showMessageDialog(panelMain,"nalezeno");
//                    System.out.println("nalezeno");
                }
            }
        });*/
        fastBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                demonstrace.setVzorek(tfVzorek.getText());
                demonstrace.setText(tfText.getText());
                while(hotovo==0){

                    popisKroku(demonstrace, false);
                    demonstrace.provedKrok();
                    demonstrace.setPocetKroku(demonstrace.getPocetKroku()+1);
                }
                System.out.println("Počet provedených kroků: " + demonstrace.getPocetKroku());
                if(hotovo == -1){
                    JOptionPane.showMessageDialog(panelMain,"nenalezeno");
//                    System.out.println("nenalezeno");
                } else if (hotovo == 1){
                    JOptionPane.showMessageDialog(panelMain,"nalezeno");
//                    System.out.println("nalezeno");
                }
            }
        });
        btStep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                demonstrace.setVzorek(tfVzorek.getText());
                demonstrace.setText(tfText.getText());
                if (hotovo==0){
                    popisKroku(demonstrace, true);
                    demonstrace.provedKrok();
                    demonstrace.setPocetKroku(demonstrace.getPocetKroku()+1);
                    while(demonstrace.getKroky() != Kroky.krok1 && demonstrace.getKroky() != Kroky.krok7 && demonstrace.getKroky() != Kroky.krok8){
                        popisKroku(demonstrace, true);
                        demonstrace.provedKrok();
                        demonstrace.setPocetKroku(demonstrace.getPocetKroku()+1);
                    }
                }
                System.out.println("Počet provedených kroků: " + demonstrace.getPocetKroku());
                if(hotovo == -1){
                    JOptionPane.showMessageDialog(panelMain,"nenalezeno");
//                    System.out.println("nenalezeno");
                } else if (hotovo == 1){
                    JOptionPane.showMessageDialog(panelMain,"nalezeno" );
//                    System.out.println("nalezeno");
                }
            }
        });
    }



    public static void main(String[] args) {
        MainForm mainForm = new MainForm();
        mainForm.setVisible(true);
    }
    public void popisKroku(DemonstraceAlgoritmu demonstrace, boolean is){
                    String aktualniKrok = "";

        switch (demonstrace.getKroky()) {
            case krok0 -> aktualniKrok = "Krok 0:\n" +
                    "Nastav kurzory na první znaky v textu i vzorku, které se budou následně porovnávat.\n";
            case krok1 -> aktualniKrok = "Krok 1:\nZapamatuj si místo v textu. Na něj se v průběhu vrátíme.\n";
            case krok2 -> aktualniKrok = "Krok 2:\nPorovnej znaky na kurzorech, jestli se shodují.\n" +
                    "Pokud se neshodují, následuje krok 3, jinak následuje krok 4.\n";
            case krok3 ->
                    aktualniKrok = "Krok 3:\nPřesuň kurzor na další znak po zapamatovaném místě a nastav kurzor na 1" +
                            "                znak ve vzorku, aby se mohl porovnávat o kousek dál celý vzorek.\n";
            case krok4 -> aktualniKrok = "Krok 4:\nPosuň kurzory na další znak. Pokračujeme v porovnávání.\n" +
                    "Následuje krok 5.\n";
            case krok5 -> aktualniKrok = "Krok 5:" +
                    "\nZjisti, jestli jsme na konci vzorku a máme co dál hledat.\n" +
                    "Pokud jsme, následuje krok 8, jinak následuje krok 6.\n";
            case krok6 -> aktualniKrok = "Krok 6:\nZjisti, jestli jsme na konci textu a máme co dál porovnávat.\n" +
                    "Pokud jsme, následuje krok 7, jinak následuje krok 1. \n";
            case krok7 -> aktualniKrok = "Krok 7:\nInformuj uživatele o nenalezení. Vypiš hlášku „nenalezeno“.\n";
            case krok8 -> aktualniKrok = "Krok 8:\nInformuj uživatele o nalezení. Vypiš hlášku „nalezeno“.\n";
        }
            if(is) {
                taPopis.setText(taPopis.getText() + "\n" + aktualniKrok);
            }

    }




}
