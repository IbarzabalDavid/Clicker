package amelioration;

public class BigHelp extends Amelioration {
    private int counter=0;

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public BigHelp() {
        setCout(2000);
        getUp().setText("+5 Clic /s                    "+getCout());
    }
}
