public class DemonstraceAlgoritmu {
    private String text;
    private String vzorek;
    private Kroky kroky;
    private String popisKroku;
    private Integer pocetKroku = 0;
    private Integer indexTextu,indexVzorku,zapamatovanyIndex;

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

    public DemonstraceAlgoritmu(){
        naZacatek();
    }

    public void naZacatek(){
        setKroky(Kroky.krok0);
    }

    public void provedKrok0(){
        indexTextu = 0;
        indexVzorku = 0;
        zapamatovanyIndex = 0;
        setKroky(Kroky.krok1);
    }

    public void provedKrok1(){
        zapamatovanyIndex = indexTextu;
        setKroky(Kroky.krok2);
    }
    public void provedKrok2(){
        if (text.charAt(indexTextu) != vzorek.charAt(indexVzorku)) {
            setKroky(Kroky.krok3);
        } else {
            setKroky(Kroky.krok4);
        }
    }
    public void provedKrok3(){
        indexTextu = zapamatovanyIndex+1;
        indexVzorku = 0;
        setKroky(Kroky.krok6);
    }
    public void provedKrok4(){
        indexTextu++;
        indexVzorku++;
        setKroky(Kroky.krok5);
    }
    public void provedKrok5(){
        if (indexVzorku != vzorek.length()) {
            setKroky(Kroky.krok6);
        } else {
            setKroky(Kroky.krok8);
        }
    }
    public void provedKrok6(){
        if(indexTextu == text.length()){
            setKroky(Kroky.krok7);
        } else {
            setKroky(Kroky.krok1);
        }
    }
    public void provedKrok7(){
        //System.out.println("nenalezeno");
        Main/*Form*/.hotovo = -1;

    }
    public void provedKrok8(){
        //System.out.println("nalezeno");
        Main/*Form*/.hotovo = 1;

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
