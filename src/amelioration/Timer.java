package amelioration;

public class Timer extends Amelioration {
    private int counter=0;

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public Timer() {
        setCout(200);
        getUp().setText("+1 Clic /s                        "+getCout());
    }
}
