package app.net;

public class CannotFindObject extends RuntimeException {
    public CannotFindObject() {
    }

    public CannotFindObject(String message) {
        super(message);
    }
}
