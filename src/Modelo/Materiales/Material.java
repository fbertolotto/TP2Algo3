package Modelo.Materiales;

import Modelo.Herramientas.*;

public abstract class Material {

    protected int durabilidad;

    public abstract void desgastar(Herramienta herramienta);

    public int getDurabilidad(){
        return this.durabilidad;
    }
}
