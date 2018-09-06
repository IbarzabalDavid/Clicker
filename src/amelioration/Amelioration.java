package amelioration;

import javafx.scene.control.Button;

public class Amelioration {
    private Button up=new Button();
    private int cout=0;

    public Button getUp() {
        return up;
    }

    public void setUp(Button up1) {
        this.up = up1;
    }

    public int getCout() {
        return cout;
    }

    public void setCout(int cout) {
        this.cout = cout;
    }
}
