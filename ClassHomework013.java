public class ClassHomework013 {
    public static void main(String[] args) {
        Circle01 myCircle01 = new Circle01();
        PassObject myPassObject = new PassObject();
        myPassObject.printAreas(myCircle01,5);
    }
}

class Circle01 {
    double radius;
    public double findArea() {
        return Math.PI * radius * radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
}

class PassObject {
    public void printAreas(Circle01 c, int times) {
        System.out.println("radius\tarea");
        for (int i = 0; i <= times; i++) {
            c.setRadius(i);
            System.out.println((double)i + "\t" + c.findArea());
        }
    }
}
