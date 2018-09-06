package amelioration;

public class Rabais extends Amelioration {
    private int rabais=5;
    public Rabais() {
        setCout(500);
        getUp().setText(getRabais()+"% de Rabais sur Tout           "+getCout());
    }

    public int getRabais() {
        return rabais;
    }

    public void setRabais(int rabais) {
        this.rabais = rabais;
    }
}
