public class Poetry {
    public static void main(String[] args) {
        String line = "The Heav'ns and all the Constellations rung";
        System.out.println(line.indexOf("H"));
        System.out.println(line.indexOf("s"));
        System.out.println(line.substring(line.indexOf("H"), line.indexOf("s") + 1 ));
    }
}
