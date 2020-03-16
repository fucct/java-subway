package model;

public class UpOrDown {
    private final int upOrDown;

    public UpOrDown(String upOrDown) {
        validate(upOrDown);
        this.upOrDown = Integer.parseInt(upOrDown);
    }

    private void validate(String upOrDown) {
        if(upOrDown!="0" && upOrDown!="1"){

        }
    }

    public int getUpOrDown() {
        return upOrDown;
    }
}
