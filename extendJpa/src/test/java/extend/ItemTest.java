package extend;

import org.junit.jupiter.api.Test;

class ItemTest {

    @Test
    public void 상속_기본() {
        Item item = new Item("화분", 20000);
        Book book = new Book("비울수록 가득하네", 15000, "정목");
        Music music = new Music("주인공", 10000, "선미");

        System.out.println("item.produce");
        item.produce();
        System.out.println();

        System.out.println("book.produce");
        book.produce();
        System.out.println();

        System.out.println("music.produce");
        music.produce();
        System.out.println();
    }


    @Test
    public void 상속_업캐스팅() {
        // 부모로 업캐스팅을 해도,
        // 객체의 본질은 자식이기 때문에
        // 자식에서 오버로딩한 메서드가 실행 된다.
        Item item = new Item("화분", 20000);
        Item book = new Book("비울수록 가득하네", 15000, "정목");
        Item music = new Music("주인공", 10000, "선미");

        System.out.println("item.produce");
        item.produce();
        System.out.println();

        System.out.println("book.produce");
        book.produce();
        System.out.println();

        System.out.println("music.produce");
        music.produce();
        System.out.println();
    }


}