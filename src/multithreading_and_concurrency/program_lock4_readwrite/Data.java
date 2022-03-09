package multithreading_and_concurrency.program_lock4_readwrite;

public class Data {
    private String value;

    public Data(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
