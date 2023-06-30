public class OverLoadExercise {
    public static void main(String[] args) {
        Method myMethod = new Method();
        System.out.println(myMethod.max(1,3));
        System.out.println(myMethod.max(1.1,3.3));
        System.out.println(myMethod.max(1.1,3.3,5.5));
    }
}

class Method {
    public int max(int n1, int n2) {
        return n1 > n2 ? n1 : n2;
    }

    public double max(double n1, double n2) {
        return n1 > n2 ? n1: n2;
    }

    public double max(double n1, double n2, double n3) {
        double max1 = n1 > n2 ? n1 : n2;
        return max1 > n3 ? max1 : n3;
    }
}
