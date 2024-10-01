public class BruteForceSearch {
    private String text;
    private String vzorek;

    public BruteForceSearch(String text, String vzorek) {
        this.text = text;
        this.vzorek = vzorek;
    }

    public boolean hledej() {
        int indexTextu = 0;
        int hotovo = 0;


        while (hotovo == 0) {
            int indexVzorku = 0;
            int zapamatovanyIndex = indexTextu;

            while (indexTextu < text.length() && indexVzorku < vzorek.length()
                    && text.charAt(indexTextu) == vzorek.charAt(indexVzorku)) {
                indexTextu++;
                indexVzorku++;
            }

            if (indexVzorku == vzorek.length()) {
                hotovo = 1;
            }
            else if (indexTextu == text.length()) {
                hotovo = -1;
            }
            else {
                indexTextu = zapamatovanyIndex + 1;
                if (indexTextu == text.length()) {
                    hotovo = -1;
                }
            }
        }

        return hotovo == 1;
    }

}
