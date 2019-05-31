package Modelo.Materiales;

public abstract class Material {

    protected int durabilidad;

    public void desgastar(int numero){
        this.durabilidad -= numero;
    }

    public int getDurabilidad(){
        return this.durabilidad;
    }
}
