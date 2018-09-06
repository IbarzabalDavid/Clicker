import amelioration.*;
import com.sun.org.glassfish.gmbal.AMXMetadata;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;



public class Main extends Application {
    public static void main(String[] args) { launch(args); }

    public void start(Stage primaryStage){

        //VARIABLES
        final int[] nbpts = {0};
        final int[] upper = {1};
        Label pts= new Label("Pts : "+ nbpts[0]);
        Button clicker= new Button("CLIC");
        Amelioration up1=new PtsX2();
        Amelioration up2=new Rabais();
        Amelioration up3=new Timer();
        Amelioration up4=new BigHelp();
        Amelioration up5=new Marde();
         final boolean[] stop={false,false,false,false,false};



        //PLACEMENTS & NAMES
        up1.getUp().setPrefSize(200,30);
        up2.getUp().setPrefSize(200,30);
        up3.getUp().setPrefSize(200,30);
        up4.getUp().setPrefSize(200,30);
        up5.getUp().setPrefSize(200,30);
        up1.getUp().setTranslateY(100);
        up2.getUp().setTranslateY(130);
        up3.getUp().setTranslateY(160);
        up4.getUp().setTranslateY(190);
        up5.getUp().setTranslateY(220);
        clicker.setTranslateX(300);
        clicker.setTranslateY(350);
        pts.setScaleX(4);
        pts.setScaleY(4);
        pts.setTranslateX(350);
        pts.setTranslateY(30);
        clicker.setPrefSize(120,80);
        primaryStage.setWidth(700);
        primaryStage.setHeight(700);
        primaryStage.setTitle("Clicker");


        //GROUPE
        Group root=new Group(pts,clicker,up1.getUp(),up2.getUp(),up3.getUp(),up4.getUp(),up5.getUp());
        primaryStage.setScene(
                new Scene(root)
        );


        //ACTIONS
        clicker.setOnAction((event) ->{
            nbpts[0]+=upper[0];
            pts.setText("Pts : "+nbpts[0]);

        });
        up1.getUp().setOnAction((event) ->{
            if (nbpts[0]>=up1.getCout()){
                nbpts[0]-=up1.getCout();
                upper[0]*=2;
                up1.setCout(up1.getCout()*4-200);
                up1.getUp().setText("Clic X2---------------"+up1.getCout());
                pts.setText("Pts : "+nbpts[0]);
            }
        });
        up2.getUp().setOnAction((event) ->{
            if (nbpts[0]>=up2.getCout()&&!stop[1]){
                nbpts[0]-=up2.getCout();

                up1.setCout(up1.getCout()-(up1.getCout()/100*((Rabais) up2).getRabais()));
                up3.setCout(up3.getCout()-(up3.getCout()/100*((Rabais) up2).getRabais()));
                up4.setCout(up4.getCout()-(up4.getCout()/100*((Rabais) up2).getRabais()));
                up5.setCout(up5.getCout()-(up5.getCout()/100*((Rabais) up2).getRabais()));
                up1.getUp().setText("Clic X2---------------"+up1.getCout());
                up3.getUp().setText("+1 Clic /s                        "+up3.getCout());
                up4.getUp().setText("+5 Clic /s                    "+up4.getCout());
                up5.getUp().setText("Caca                   "+up5.getCout());

                ((Rabais) up2).setRabais(((Rabais) up2).getRabais()*2);
                up2.setCout(up2.getCout()*2);
                if (((Rabais) up2).getRabais()==40){
                    up2.getUp().setText("MAX");
                    stop[1]=true;
                }
                else {
                    up2.getUp().setText(((Rabais) up2).getRabais()+"% de Rabais sur Tout           "+up2.getCout());
                }

                pts.setText("Pts : "+nbpts[0]);
            }
        });
        up3.getUp().setOnAction((event) ->{
            if (nbpts[0]>=up3.getCout()){
                nbpts[0]-=up3.getCout();

                pts.setText("Pts : "+nbpts[0]);
            }
        });
        up4.getUp().setOnAction((event) ->{
            if (nbpts[0]>=up4.getCout()){
                nbpts[0]-=up4.getCout();

                pts.setText("Pts : "+nbpts[0]);
            }
        });
        up5.getUp().setOnAction((event) ->{
            if (nbpts[0]>=up5.getCout()){
                nbpts[0]=0;
                up5.getUp().setText("Caca! un troll te vole de cash  "+up5.getCout());
                pts.setText("Pts : "+nbpts[0]);
            }
        });




        //SHOW
        primaryStage.show();
    }
}
