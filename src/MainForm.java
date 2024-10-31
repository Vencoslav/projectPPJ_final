import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame{
    private JTextField tfVzorek;
    private JButton nextButton;
    private JTextField tfText;
    private JPanel panelMain;
    public static int hotovo = 0;

    public MainForm(){
        setContentPane(panelMain);
        DemonstraceAlgoritmu demonstrace = new DemonstraceAlgoritmu();
        demonstrace.setText("ab");
        demonstrace.setVzorek("b");
        setSize(500,150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                demonstrace.setText("Čím se vyznačuje svobodný software (free software)?");
//                demonstrace.setVzorek("software");
                if (hotovo == 0){
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
        });
    }


}
