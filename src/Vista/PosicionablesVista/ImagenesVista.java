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

    private void crearImagen(Posicionable posicionable, String extra) {
        String ruta = generadorRuta("images", posicionable.getNombre(), extra);
        String nombreentidad = posicionable.getNombre() + extra;
        File file = new File(ruta);
        Image imagen = new Image(file.toURI().toString(), 80, 80, true, false);
        imagenes.put(nombreentidad, imagen);

    }

    private String generadorRuta(String tipo, String nombre, String extra) { return "media/" + tipo + "/" + nombre + extra + ".png/"; }

    private Image obtenerImagen(Posicionable posicionable, String extra) {
        String entidad = posicionable.getNombre() + extra;
        return imagenes.get(entidad);
    }

    private void crearImageView(Image imagen, Posicion posicion,int corrimientoX,int corrimientoY,Posicionable posicionable,boolean mostrarBarraDurabilidadHerramienta) {
        ImageView imageView = new ImageView();
        imageView.setImage(imagen);
        imageView.setLayoutX(posicion.getColumna() * 80 + corrimientoX);
        imageView.setLayoutY(posicion.getFila() * 80 + corrimientoY);

        BarraDurabilidad barraDurabilidad = new BarraDurabilidad(contenedor);
        contenedor.getChildren().add(imageView);
        if (mostrarBarraDurabilidadHerramienta) { if (posicionable instanceof Herramienta) { barraDurabilidad.mostrarBarra(posicionable, imageView, corrimientoX, corrimientoY, 80, posicion); }
        } else { barraDurabilidad.mostrarBarra(posicionable, imageView, corrimientoX, corrimientoY, 80, posicion); }
    }

    public void agregarImagen(Posicionable posicionable,String extra,Posicion posicion,int corrimientoX,int corrimientoY,boolean mostrarBarraDurabilidad) {
        Image imagen = obtenerImagen(posicionable,extra);
        crearImageView(imagen,posicion,corrimientoX,corrimientoY,posicionable,mostrarBarraDurabilidad);
    }
}
