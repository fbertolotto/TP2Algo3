package Modelo.Materiales;

import Modelo.Herramientas.*;

public class Diamante extends Material {

    public Diamante() {
        this.durabilidad = 100;
    }

    @Override
    public void desgastar(Herramienta herramienta) {
        if (PicoFino.class == herramienta.getClass()) {
            this.durabilidad -= herramienta.getFuerza();
        }
    }
}
