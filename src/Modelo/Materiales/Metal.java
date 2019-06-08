package Modelo.Materiales;

import Modelo.Herramientas.*;

public class Metal extends Material {

    public Metal() {
        this.durabilidad = 50;
    }

    public void desgastar(PicoDePiedra picoDePiedra) { this.durabilidad -= picoDePiedra.getFuerza(); }

    public void desgastar(Herramienta herramienta) { }

}
