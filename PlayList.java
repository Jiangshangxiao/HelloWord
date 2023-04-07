import java.util.ArrayList;
public class PlayList {
    public static void main(String[] args) {
        ArrayList<String> desertIslandPlayList = new ArrayList<>();

        desertIslandPlayList.add("叶わない恋でも");
        desertIslandPlayList.add("忘不掉的你");
        desertIslandPlayList.add("Taste");
        desertIslandPlayList.add("Broken Love");
        desertIslandPlayList.add("ありふれて花束");
        desertIslandPlayList.add("Tokyo Rain");
        desertIslandPlayList.add("Hurt");

        System.out.println(desertIslandPlayList);
        System.out.println(desertIslandPlayList.size());

        desertIslandPlayList.remove(1);
        desertIslandPlayList.remove("Taste");

        System.out.println(desertIslandPlayList.size());

        int indexA = desertIslandPlayList.indexOf("Broken Love");
        int indexB = desertIslandPlayList.indexOf("Tokyo Rain");
        String tempA = desertIslandPlayList.get(indexA);
        String tempB = desertIslandPlayList.get(indexB);
        desertIslandPlayList.set(indexA, tempB);
        desertIslandPlayList.set(indexB, tempA);

        System.out.println(desertIslandPlayList);
    }
}
