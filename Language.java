public class Language {
    protected String name;
    protected int numSpeakers;
    protected String regionsSpoken;
    protected String wordOrder;

    Language(String langName, int speakers, String regions, String wdOrder) {
        this.name = langName;
        this.numSpeakers = speakers;
        this.regionsSpoken = regions;
        this.wordOrder = wdOrder;
    }

    public void getInfo() {
        System.out.println(this.name + " is spoken by " + this.numSpeakers +
                " people mainly in " + this.regionsSpoken + "." );
        System.out.println("The language follows the word order: " + this.wordOrder);
    }

    public static void main(String[] args) {
        Language Japanese = new Language("Japanese", 123 , "Japan", "subject-object-verb");
        Japanese.getInfo();

        Mayan kiche = new Mayan("Ki 'che'",233000);
        kiche.getInfo();

        Language mandarin = new SinoTibetan("Mandarin Chinese", 111100000);
        mandarin.getInfo();

        Language burmese = new SinoTibetan("Burmese", 430000);
        burmese.getInfo();
    }
}
