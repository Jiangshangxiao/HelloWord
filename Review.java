public class Review {
    public static void main(String[] args) {
        String str1 = "JiangShangXiao";
        String str2 = "JiangShangzhao";

        System.out.println("The length of str1: " + str1.length());
        System.out.println("The length of str2: " + str2.length());

        System.out.println("str1 concat str2: " + str1.concat(str2));

        System.out.println("The index of s inside str1: " + str1.indexOf("s"));

        System.out.println("The char at 2 inside str2: " + str2.charAt(2));

        System.out.println("Are str1 and str2 the same?" + str1.equals(str2));

        System.out.println("Ignore whether case str1 and str2 are the same?" + str1.equalsIgnoreCase(str2));

        System.out.println("Intercept word: " + str1.substring(3, 12));

        System.out.println("to upper case: " + str1.toUpperCase());

        System.out.println("to lower case: " + str2.toLowerCase());
    }
}
