package Vista;

import Controlador.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import static Vista.Cancion.ReproducirCancion;

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

        ControladorCerrarApp controladorbotonsalir = new ControladorCerrarApp(botonexit, intro,primaryStage);
        ControladorCambiarAMenu controladorbotonjugar = new ControladorCambiarAMenu(botonplay,intro, primaryStage);

        botonexit.setOnAction(controladorbotonsalir);
        botonplay.setOnAction(controladorbotonjugar);

    }


    public static void main(String[] args) {
        launch(args);
    }


    public void ElegirVideoDeFondo(String ruta, Pane Contenedor){
        Media media = new Media(Main.class.getResource(ruta).toExternalForm());
        MediaPlayer player = new MediaPlayer(media);
        player.setOnError(() -> System.out.println("error player"));
        player.setAutoPlay(true);
        player.setCycleCount(1000);
        MediaView view = new MediaView(player);
        Contenedor.getChildren().add(view);
        System.out.println("Exito");
    }

}
