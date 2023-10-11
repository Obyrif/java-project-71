package hexlet.code;

public final class KeyDifference {
    private final String key;
    private String status;
    private Object value1;
    private Object value2;

    public KeyDifference(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public String getStatus() {
        return status;
    }

    public Object getValue1() {
        return value1;
    }

    public Object getValue2() {
        return value2;
    }

    public void setValue1(Object value1) {
        this.value1 = value1;
    }

    public void setValue2(Object value2) {
        this.value2 = value2;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
