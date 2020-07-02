package generics.simple_generic_type;

public class GenericType<T> {

    private T t;

    public GenericType(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
