package Vista;

import Controlador.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import static Vista.Cancion.reproducirCancion;
import static Vista.Video.elegirVideoDeFondo;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane contenedorMenu = new Pane();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("AlgoCraft");
        primaryStage.setScene(new Scene(root, 1920, 1080));


        MediaPlayer intro = reproducirCancion("media/audio/minecraft__remix.mp3", 0.25);
        elegirVideoDeFondo("media/video/Fondo.mp4", contenedorMenu);

        BotonGenerico botonplay = new BotonPlay();
        contenedorMenu.getChildren().add(botonplay);

        BotonGenerico botonexit = new BotonExit();
        contenedorMenu.getChildren().add(botonexit);
        botonexit.setLayoutY(820);

        Scene scene = new Scene(contenedorMenu);

        ControladorCerrarApp controladorbotonsalir = new ControladorCerrarApp(intro,primaryStage);
        ControladorCambiarAMenu controladorbotonjugar = new ControladorCambiarAMenu(intro, contenedorMenu, primaryStage);

        botonexit.setOnAction(controladorbotonsalir);
        botonplay.setOnAction(controladorbotonjugar);

        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ESCAPE) {
                System.out.println("Cerrando App");
                primaryStage.close();
            }
            if (e.getCode() == KeyCode.ENTER) {
                System.out.println("Entrando al mundo");
                intro.stop();
                new JuegoVista().empezarJuego(primaryStage , contenedorMenu);
            }
        });

        Button BotondelVolumen = new BotonVolumen();
        contenedorMenu.getChildren().add(BotondelVolumen);
        ControladorVolumen controladorVolumen = new ControladorVolumen(BotondelVolumen, contenedorMenu, intro);
        BotondelVolumen.setOnAction(controladorVolumen);

        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }

}
