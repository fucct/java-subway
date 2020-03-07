package exception;

public class JsonParseException extends RuntimeException {
    public JsonParseException() {
    }

    public JsonParseException(String s) {
        super(s);
    }
}
