package extend;

public class Music extends Item {
    private String singer;

    public Music(String name, int price, String singer) {
        super(name, price);
        this.singer = singer;
    }

    @Override
    public void produce() {
        super.produce();
        System.out.println("가수는 " + singer + "입니다.");
    }

    @Override
    public void printPrice() {
        System.out.println("1곡에 " + super.getPrice() + "원 입니다.");
    }
}
