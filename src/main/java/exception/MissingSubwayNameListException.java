package exception;

public class MissingSubwayNameListException extends RuntimeException {
    public MissingSubwayNameListException(String s) {
        super(s);
    }
}
