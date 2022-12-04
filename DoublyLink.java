// Eliezer, Gabriel

public class DoublyLink {

    public DoublyLink prev;
    public DoublyLink next;
    public Object data;

    public DoublyLink(Object data) {
        this.data = data;
        prev = null;
        next = null;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}