public class GenericTypeTest {

}

class A {
}

class B extends A {
}

class C extends B {
}

class Player1<T> {
    T obj;

    public Player1(T t) {
        this.obj = t;
    }

    T method() {
        return obj;
    }
}