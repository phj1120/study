package extend;

public class Book extends Item {
    private String writer;

    public Book(String name, int price, String writer) {
        super(name, price);
        this.writer = writer;
    }

    @Override
    public void produce() {
        super.produce();
        System.out.println("지은이는 " + writer + "입니다.");
        this.printPrice(); // 현재 객체의 printPrice()
        super.printPrice(); // 부모 객체의 printPrice()
    }

    @Override
    public void printPrice() {
        System.out.println("1권에 " + super.getPrice() + "원 입니다.");
    }
}
