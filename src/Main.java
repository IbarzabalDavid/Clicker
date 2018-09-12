import amelioration.*;
import com.sun.org.glassfish.gmbal.AMXMetadata;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;


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
        Timer up3=new Timer();
        BigHelp up4=new BigHelp();
        Amelioration up5=new Marde();
        Label counter= new Label("Clic automatique : "+ up3.getCounter()+"/s");
        Label multi= new Label("Clic manuel : "+ upper[0]+"/clic");
         final boolean[] stop={false,false,false,false,false};



        //PLACEMENTS & NAMES
        up1.getUp().setPrefSize(250,70);
        up2.getUp().setPrefSize(250,70);
        up3.getUp().setPrefSize(250,70);
        up4.getUp().setPrefSize(250,70);
        up5.getUp().setPrefSize(250,70);
        up1.getUp().setTranslateY(100);
        up2.getUp().setTranslateY(170);
        up3.getUp().setTranslateY(240);
        up4.getUp().setTranslateY(310);
        up5.getUp().setTranslateY(380);
        clicker.setTranslateX(400);
        clicker.setTranslateY(250);
        pts.setScaleX(4);
        pts.setScaleY(4);
        pts.setTranslateX(350);
        pts.setTranslateY(30);
        clicker.setPrefSize(200,200);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("Clicker");
        counter.setTranslateX(50);
        counter.setTranslateY(500);
        multi.setTranslateX(50);
        multi.setTranslateY(550);
        counter.setPrefSize(150,50);
        multi.setPrefSize(150,50);


        //GROUPE
        Group root=new Group(pts,clicker,up1.getUp(),up2.getUp(),up3.getUp(),up4.getUp(),up5.getUp(),multi,counter);
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
                multi.setText("Clic manuel : "+ upper[0]+"/clic");
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
                up3.setCounter(up3.getCounter()+1);
                up3.setCout(up3.getCout()*2);
                up3.getUp().setText("+1 Clic /s             "+up3.getCout());
                pts.setText("Pts : "+nbpts[0]);
                counter.setText("Clic automatique : "+ (up3.getCounter()+(up4.getCounter()*5))+"/s");
            }
        });
        up4.getUp().setOnAction((event) ->{
            if (nbpts[0]>=up4.getCout()){
                nbpts[0]-=up4.getCout();
                up4.setCounter(up4.getCounter()+1);
                up4.setCout(up4.getCout()*2);
                up4.getUp().setText("+5 Clic /s         "+up4.getCout());
                pts.setText("Pts : "+nbpts[0]);
                counter.setText("Clic automatique : "+( up3.getCounter()+(up4.getCounter()*5))+"/s");
            }
        });
        up5.getUp().setOnAction((event) ->{
            if (nbpts[0]>=up5.getCout()){
                nbpts[0]=0;
                up5.getUp().setText("Caca! un troll te vole de cash  "+up5.getCout());
                pts.setText("Pts : "+nbpts[0]);
            }
        });

        //TimeLine
        final Timeline autoCli = new Timeline(new KeyFrame(Duration.millis(1000), event -> {
            nbpts[0]+=(up3.getCounter()+(up4.getCounter()*5));
            pts.setText("Pts : "+nbpts[0]);
        }));
        autoCli.setCycleCount(autoCli.INDEFINITE);
        autoCli.play();



        //SHOW
        primaryStage.show();
    }
}
