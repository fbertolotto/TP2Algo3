package Vista;

import Controlador.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

import static Vista.Cancion.ReproducirCancion;
import static Vista.Video.ElegirVideoDeFondo;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane contenedorMenu = new Pane();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("AlgoCraft");
        primaryStage.setScene(new Scene(root, 1920, 1080));


        AudioClip intro = ReproducirCancion("audio/minecraft__remix.mp3/", 0.25);

        ElegirVideoDeFondo("video/Fondo.mp4/", contenedorMenu);

        BotonGenerico botonplay = new BotonPlay();
        contenedorMenu.getChildren().add(botonplay);

        BotonGenerico botonexit = new BotonExit();
        contenedorMenu.getChildren().add(botonexit);
        botonexit.setLayoutY(820);

        Scene scene = new Scene(contenedorMenu);
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.show();

        ControladorCerrarApp controladorbotonsalir = new ControladorCerrarApp(intro,primaryStage);
        ControladorCambiarAMenu controladorbotonjugar = new ControladorCambiarAMenu(intro, primaryStage);

        botonexit.setOnAction(controladorbotonsalir);
        botonplay.setOnAction(controladorbotonjugar);

    }


    public static void main(String[] args) {
        launch(args);
    }

}
