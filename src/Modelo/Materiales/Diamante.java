package Modelo.Materiales;

import Modelo.Herramientas.*;

public class Diamante extends Material {

    public Diamante() {
        this.durabilidad = 100;
    }

    public void desgastar(PicoFino picoFino) { this.durabilidad -= picoFino.getFuerza(); }

    public void desgastar(Herramienta herramienta) { }
}
