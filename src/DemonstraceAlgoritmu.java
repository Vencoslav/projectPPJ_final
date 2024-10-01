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

    public void naZacatek(){
        int indexTextu,indexVzorku,zapamatovanyIndex = 0;
        setKroky(Kroky.krok0);
    }

    public void provedKrok(){

        switch (getKroky()){
            case krok0 -> naZacatek();
            case krok1 -> setKroky(Kroky.krok1);

        }
    }
}
