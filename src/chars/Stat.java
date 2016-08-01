package chars;

public class Stat {
    private int num, max;
    private boolean isEmpty;

    public Stat(int max) {
        this.max = max;
    }

    public int getNum() {
        return num;
    }

    public void changeNum(int num) {
        this.num = num;
        isEmpty = checkVal();
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    private boolean checkVal() {
        if (num > max) {
            num = max;
            return false;
        } else if (num <= 0) {
            num = 0;
            return true;
        } else
            return false;
    }
}
