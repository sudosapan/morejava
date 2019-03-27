public class GenericTypeTest {
    public <V extends B> Test<V> method(Test<V> a) {
        return new Test<V>((V) new C());
    }
}

class A {
}

class B extends A {
}

class C extends B {
}

class Test<T> {
    T obj;

    public Test(T t) {
        this.obj = t;
    }

    T method() {
        return obj;
    }
}