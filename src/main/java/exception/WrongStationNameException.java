package exception;

public class WrongStationNameException extends RuntimeException {
    public WrongStationNameException(String s) {
        super(s);
    }
}
