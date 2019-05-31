package Modelo.Materiales;

import Modelo.Herramientas.*;

public class Diamante extends Material {

    public Diamante() {
        this.durabilidad = 100;
    }

    public void desgastar(Herramienta herramienta) {
        if (PicoFino.class.isAssignableFrom(herramienta.getClass()) || PicoDePiedra.class.isAssignableFrom(herramienta.getClass())) {
            this.durabilidad -= herramienta.getFuerza();
        }
    }
}
