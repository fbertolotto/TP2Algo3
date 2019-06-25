package Vista.PosicionablesVista;

import Modelo.Posicionable.Posicionable;
import Modelo.Tablero.Posicion;
import javafx.scene.image.Image;
import Modelo.Materiales.*;
import Modelo.Herramientas.*;
import Modelo.Jugador.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class ImagenesVista {

    private HashMap<String, Image> imagenes;
    private ArrayList<Posicionable> entidades;
    private Pane contenedor;

    public ImagenesVista(Pane contenedor) {
        this.imagenes = new HashMap<>();
        this.contenedor = contenedor;
        this.inicializarImagenes();
        this.crearImagenes();
    }

    private void inicializarImagenes() {

        Madera madera = new Madera();
        Piedra piedra = new Piedra();
        Metal metal = new Metal();
        Diamante diamante = new Diamante();
        HachaDeMadera hachaDeMadera = new HachaDeMadera();
        HachaDePiedra hachaDePiedra = new HachaDePiedra();
        HachaDeMetal hachaDeMetal = new HachaDeMetal();
        PicoDeMadera picoDeMadera = new PicoDeMadera();
        PicoDePiedra picoDePiedra = new PicoDePiedra();
        PicoDeMetal picoDeMetal = new PicoDeMetal();
        PicoFino picoFino = new PicoFino();
        this.entidades = new ArrayList<>();
        entidades.add(madera);
        entidades.add(piedra);
        entidades.add(metal);
        entidades.add(diamante);
        entidades.add(hachaDeMadera);
        entidades.add(hachaDePiedra);
        entidades.add(hachaDeMetal);
        entidades.add(picoDeMadera);
        entidades.add(picoDePiedra);
        entidades.add(picoDeMetal);
        entidades.add(picoFino);
    }

    private void crearImagenes() {
        for (Posicionable posicionable : entidades) {crearImagen(posicionable,"inventario"); }
        entidades.add(new Jugador()); //Se agregan despues porque no tienen imagen de inventario.
        entidades.add(new Zombie());
        for (Posicionable posicionable : entidades) { crearImagen(posicionable,""); }

    }

    public void crearImagen(Posicionable posicionable, String extra) {
        String ruta = generadorRuta(posicionable.getNombre(), extra);
        String nombreentidad = posicionable.getNombre() + extra;
        File file = new File(ruta);
        Image imagen = new Image(file.toURI().toString(), 80, 80, true, false);
        imagenes.put(nombreentidad, imagen);

    }

    private String generadorRuta(String nombre, String extra) { return "media/images" + "/" + nombre + extra + ".png/"; }

    private Image obtenerImagen(Posicionable posicionable, String extra) {
        String entidad = posicionable.getNombre() + extra;
        return imagenes.getOrDefault(entidad,null);
    }

    private ImageView crearImageView(Image imagen, Posicion posicion,int corrimientoX,int corrimientoY,int tam) {
        ImageView imageView = new ImageView();
        imageView.setImage(imagen);
        imageView.setLayoutX(posicion.getColumna() * tam + corrimientoX);
        imageView.setLayoutY(posicion.getFila() * tam + corrimientoY);
        imageView.setFitWidth(tam);
        imageView.setFitHeight(tam);
        return imageView;
    }

    public ImageView agregarView(Posicionable posicionable, String extra, Posicion posicion, int corrimientoX, int corrimientoY,int tam, boolean mostrarBarraDurabilidad) {
        Image imagen = obtenerImagen(posicionable,extra);
        ImageView imageView = crearImageView(imagen,posicion,corrimientoX,corrimientoY,tam);
        contenedor.getChildren().add(imageView);
        if(mostrarBarraDurabilidad) this.agregarBarraDurabilidad(posicionable,imageView,posicion,corrimientoX,corrimientoY);
        return imageView;
    }

    private void agregarBarraDurabilidad(Posicionable posicionable,ImageView imageView,Posicion posicion,int corrimientoX,int corrimientoY) {
        BarraDurabilidad barraDurabilidad = new BarraDurabilidad(contenedor);
        barraDurabilidad.mostrarBarra(posicionable, imageView, corrimientoX, corrimientoY, 80, posicion);
    }

}
