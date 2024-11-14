import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.awt.*;

public class DemonstraceAlgoritmu {
    private String text;
    private String vzorek;
    private Kroky kroky;
    private String popisKroku;
    private Integer pocetKroku = 0;
    private Integer indexTextu,indexVzorku,zapamatovanyIndex;
    private Highlighter.HighlightPainter inspectPainter;
    private Highlighter.HighlightPainter matchPainter;
    private JTextField tfVzorek;

    private JTextField tfText;
    private int foundCount;

    public Kroky getKroky() {
        return kroky;
    }

    public void setKroky(Kroky kroky) {
        this.kroky = kroky;
    }

    public String getPopisKroku() {
        return popisKroku;
    }

    public void setPopisKroku(String popisKroku) {
        this.popisKroku = popisKroku;
    }

    public Integer getPocetKroku() {
        return pocetKroku;
    }

    public void setPocetKroku(Integer pocetKroku) {
        this.pocetKroku = pocetKroku;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getVzorek() {
        return vzorek;
    }

    public void setVzorek(String vzorek) {
        this.vzorek = vzorek;
    }

    public DemonstraceAlgoritmu(JTextField textField, JTextField textField1){
        this.tfText = textField;
        this.tfVzorek = textField1;
        this.inspectPainter = new DefaultHighlighter.DefaultHighlightPainter(new Color(15, 245, 229));
        this.matchPainter = new DefaultHighlighter.DefaultHighlightPainter(new Color(153, 245, 15));
        naZacatek();
    }

    public void naZacatek(){
        setKroky(Kroky.krok0);
    }
    public void reset(){
        pocetKroku = 0;
        kroky = Kroky.krok0;
        foundCount = 0;
        indexVzorku = indexTextu = zapamatovanyIndex = 0;
        tfText.getHighlighter().removeAllHighlights();
        tfVzorek.getHighlighter().removeAllHighlights();

    }
    public static void main(String[] args) {
        MainForm mainForm = new MainForm();
        mainForm.setVisible(true);
    }
    public void provedKrok0(){
        indexTextu = 0;
        indexVzorku = 0;
        zapamatovanyIndex = 0;
        setKroky(Kroky.krok1);
        System.out.println("Krok 0:\n" +
                "Natav kurzory na první znaky v textu i vzorku, které se budou následně porovnávat.\n");
    }

    public void provedKrok1(){
        zapamatovanyIndex = indexTextu;
        setKroky(Kroky.krok2);
        System.out.println("Krok 1:\nZapamatuj si místo v textu. Na něj se v průběhu vrátíme.\n");

    }
    public void provedKrok2(){
        if (text.charAt(indexTextu) != vzorek.charAt(indexVzorku)) {
            setKroky(Kroky.krok3);

        } else {
            foundCount++;
            setKroky(Kroky.krok4);
        }
        System.out.println("Krok 2:\nPorovnej znaky na kurzorech, jestli se shodují.\n" +
                "Pokud se neshodují, následuje krok 3, jinak následuje krok 4.\n");
    }
    public void provedKrok3(){
        indexTextu = zapamatovanyIndex+1;
        try {
            hightlightCharacter(indexTextu, tfText);
        } catch (BadLocationException e) {
            JOptionPane.showMessageDialog(null, "help highlighting");
        }
        indexVzorku = 0;
        setKroky(Kroky.krok6);
        System.out.println("Krok 3:\nPřesuň kurzor na další znak po zapamatovaném místě a nastav kurzor na 1. " +
                "znak ve vzorku, aby se mohl porovnávat o kousek dál celý vzorek.\n");
    }
    public void provedKrok4(){
        try {
            hightlightCharacter(indexTextu, tfText);
        } catch (BadLocationException e) {
            JOptionPane.showMessageDialog(null, "help highlighting");
        }
        indexTextu++;
        indexVzorku++;
        setKroky(Kroky.krok5);
        System.out.println("Krok 4:\nPosuň kurzory na další znak. Pokračujeme v porovnávání.\n" +
                "Následuje krok 5.\n");
    }
    public void provedKrok5(){
        if (indexVzorku != vzorek.length()) {
            setKroky(Kroky.krok6);
        } else {
            setKroky(Kroky.krok8);
        }
        System.out.println("Krok 5:\nZjisti, jestli jsme na konci vzorku a máme co dál hledat.\n" +
                "Pokud jsme, následuje krok 8, jinak následuje krok 6.\n");
    }
    public void provedKrok6(){
        if(indexTextu == text.length()){
            setKroky(Kroky.krok7);
        } else {
            setKroky(Kroky.krok1);
        }
        System.out.println("Krok 6:\nZjisti, jestli jsme na konci textu a máme co dál porovnávat.\n" +
                "Pokud jsme, následuje krok 7, jinak následuje krok 1. \n");
    }
    public void provedKrok7(){
        //System.out.println("nenalezeno");
        MainForm.hotovo = -1;
        System.out.println("Krok 7:\nInformuj uživatele o nenalezení. Vypiš hlášku „nenalezeno“.\n");

    }
    public void provedKrok8(){
        //System.out.println("nalezeno");
        MainForm.hotovo = 1;
        System.out.println("Krok 8:\nInformuj uživatele o nalezení. Vypiš hlášku „nalezeno“.\n");

    }
    public void hightlightCharacter(int index, JTextField textField) throws BadLocationException {
        try {

            textField.getHighlighter().removeAllHighlights();
            if(foundCount>0){
                highlightTextArea(index - foundCount + 1, index + 1);
                highlightPatternField(foundCount, tfVzorek);
            }
            else {

                textField.getHighlighter().addHighlight(index-1, index, inspectPainter);
            }
            tfText.setCaretPosition(index + 1);
        }

     catch (BadLocationException e) {
        JOptionPane.showMessageDialog(null,"Error while highlighting character: " + e.getMessage());
    }



    }
    public void highlightPatternField(int endIndex, JTextField patternField) {
        try {
            patternField.getHighlighter().removeAllHighlights();
            patternField.getHighlighter().addHighlight(0, endIndex, matchPainter);
            patternField.setCaretPosition(endIndex);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error while highlighting pattern field: " + e.getMessage());
        }}


    public void highlightTextArea(int startIndex, int endIndex) {
        try {
            tfText.getHighlighter().addHighlight(startIndex, endIndex, matchPainter);
            tfText.setCaretPosition(endIndex);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error while highlighting text area: " + e.getMessage());
        }
    }

    public void provedKrok(){

        switch (getKroky()){
            case krok0 -> provedKrok0();
            case krok1 -> provedKrok1();
            case krok2 -> provedKrok2();
            case krok3 -> provedKrok3();
            case krok4 -> provedKrok4();
            case krok5 -> provedKrok5();
            case krok6 -> provedKrok6();
            case krok7 -> provedKrok7();
            case krok8 -> provedKrok8();
        }
    }
}
