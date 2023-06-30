/*
this program for DNA sequencing
*/
public class DNA {
    public static void main(String[] args) {
        //  -. .-.   .-. .-.   .
        //    \   \ /   \   \ /
        //   / \   \   / \   \
        //  ~   `-~ `-`   `-~ `-
        String dna1 = "ATGCGATACGCTTGA";
        String dna2 = "ATGCGATACGTGA";
        String dna3 = "ATTAATATGTACTGA";

        String dna = dna1;

        int dnaLength = dna.length();
        System.out.println("dna length: " + dnaLength);

        int start = dna.indexOf("ATG");
        System.out.println("start: " + start);

        int stop = dna.indexOf("TGA");
        System.out.println("stop: " + stop);

        if (start != -1 && stop != -1 && (start - stop) % 3 == 0) {
            String protein = dna.substring(start, stop + 3);
            System.out.println(protein);
        }
    }
}
