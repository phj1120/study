import org.junit.jupiter.api.Test;

public class ExtendStudy {

    static class A {
        public void print() {
            System.out.println("A");
        }
    }

    static class AA extends A {
        @Override
        public void print() {
            System.out.println("AA");
        }

        public void printSuper() {
            super.print();
        }

        public void printThis() {
            this.print();
        }
    }


    @Test
    public void 테스트() {
//        A a = new A();
//        a.print();

//        AA aa = (AA) a; 부모로 생성해서 자식으로 캐스팅 불가능

        AA aa = new AA();
        aa.print(); // AA

        A a = (AA) aa;
        a.print(); // AA

        A a1 = new A();
        a1.print(); // A

        aa.printSuper(); // A
        aa.printThis(); // AA
    }
}

