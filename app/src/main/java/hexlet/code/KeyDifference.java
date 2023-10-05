package hexlet.code;

public class KeyDifference {
    private String key;
    private String status;
    private Object oldValue;
    private Object newValue;

    public KeyDifference(String key) {
        this.key = key;
        this.status = status;
        this.oldValue = oldValue;
        this.newValue = newValue;
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

    public void setKey(String key) {
        this.key = key;
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
