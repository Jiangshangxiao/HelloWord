public class Store {
    //instance fields
    String productType;
    double price;

    //constructor method
    public Store(String product, double initialPrice) {
        productType = product;
        price = initialPrice;
    }

    //increase price method
    public void increasePrice(double priceToAdd) {
        double newPrice = priceToAdd + price;
        price = newPrice;
    }

    //get price with tax method
    public double getPriceWithTax(double tax) {
        return price + price * tax;
    }

    public String toString() {
        return "this store sells " + productType + " at price of " + price;
    }

    //main method
    public static void main(String[] args){
        Store hotStore = new Store("hot", 3.5);
        Store meetStore = new Store("pigMeet", 1.5);
        System.out.println(hotStore);
        System.out.println(meetStore);
    }
}
