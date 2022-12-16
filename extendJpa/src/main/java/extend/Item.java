package extend;

public class Item {
    private String name;

    private int price;

    public int getPrice() {
        return price;
    }

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void produce() {
        System.out.println(name + "입니다.");
        printPrice();
    }

    public void printPrice() {
        System.out.println("1개에 " + price + "원 입니다.");
    }
}
