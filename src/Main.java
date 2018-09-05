import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;



public class Main extends Application {
    public static void main(String[] args) { launch(args);}

    public void start(Stage primaryStage){
        final int[] nbpts = {0};
        Label pts= new Label("Pts : "+ nbpts[0]);
        Button clicker= new Button("CLIC");

        clicker.setTranslateX(300);
        clicker.setTranslateY(350);
        pts.setScaleX(4);
        pts.setScaleY(4);
        pts.setTranslateX(350);
        pts.setTranslateY(30);
        clicker.setPrefSize(120,80);

        Group root=new Group(pts,clicker);
        primaryStage.setScene(
                new Scene(root)
        );

        primaryStage.setWidth(700);
        primaryStage.setHeight(700);
        primaryStage.setTitle("Clicker");
        clicker.setOnAction((event) ->{
            nbpts[0]++;
            pts.setText("Pts : "+nbpts[0]);
            if (nbpts[0]==20){
                Button lol=new Button("LOL");
                root.getChildren().add(lol);
            }
        });
        primaryStage.show();
    }
}
