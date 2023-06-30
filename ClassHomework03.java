public class ClassHomework03 {
    public static void main(String[] args) {
        //编写类Book,定义方法updatePrice，实现更改某本书的价格,
        //具体:如果价格>150,则更改为150,如果价格为>100,更改为100,否则不变
        Book myBook = new Book("格林童话", 300);
        myBook.info();
        myBook.updatePrice();
        myBook.info();
    }
}

class Book {
    String name;
    int price;
    public Book(String name, int price){
        this.name = name;
        this.price = price;
    }

    public void updatePrice() {
        if (this.price > 150) {
            this.price = 150;
        } else if (this.price >100) {
            this.price = 100;
        }
    }

    public void info() {
        System.out.println("书的名字 = " + this.name + " 书的价格为 = " + this.price);
    }
}
