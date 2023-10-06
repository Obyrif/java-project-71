package hexlet.code;

public class KeyDifference {
    private final String key;
    private String status;
    private Object oldValue;
    private Object newValue;

    public KeyDifference(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public String getStatus() {
        return status;
    }

    public Object getOldValue() {
        return oldValue;
    }

    public Object getNewValue() {
        return newValue;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setOldValue(Object oldValue) {
        this.oldValue = oldValue;
    }

    public void setNewValue(Object newValue) {
        this.newValue = newValue;
    }
}
