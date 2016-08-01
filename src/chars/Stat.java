package chars;

public class Stat {
    private double num, max, base;
    private boolean isEmpty;

    public Stat(double base) {
        this.base = base;
        max = base;
    }

    public double getNum() {
        return num;
    }

    public double getBase() {
        return base;
    }

    public void changeNum(double num) {
        this.num = num;
        isEmpty = checkVal();
    }

    public double getMax() {
        return max;
    }

    public void changeMax(double max) {
        this.max = max;
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
