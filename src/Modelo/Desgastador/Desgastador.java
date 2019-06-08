package Modelo.Desgastador;
import Modelo.Excepciones.DurabilidadAgotadaException;
import Modelo.Herramientas.*;
import Modelo.Materiales.*;

public class Desgastador {

    public void desgastar(Hacha hacha, Madera madera) throws DurabilidadAgotadaException {
        hacha.desgastar(); // La herramienta se desgasta primero por si debe lanzar una excepcion
        madera.desgastar(hacha.getFuerza());
    }

    public void desgastar(PicoFino picoFino, Diamante diamante) {
        picoFino.desgastar();
        diamante.desgastar(picoFino.getFuerza());
    }

    public void desgastar(PicoFino picoFino, Piedra piedra) {
        piedra.desgastar(picoFino.getFuerza());
    }

    public void desgastar(PicoDePiedra picoDePiedra, Metal metal) throws DurabilidadAgotadaException {
        picoDePiedra.desgastar();
        metal.desgastar(picoDePiedra.getFuerza());
    }

    public void desgastar(Pico pico, Piedra piedra) throws DurabilidadAgotadaException {
        pico.desgastar();
        piedra.desgastar(pico.getFuerza());
    }

    public void desgastar(PicoFino picoFino,Material material) {};

    public void desgastar(Herramienta herramienta,Material material) throws DurabilidadAgotadaException {
        herramienta.desgastar(); };
}
