package Modelo.Materiales;

public abstract class Material {

    protected int durabilidad;

    public void desgastar(int fuerzaDeDesgaste) { this.durabilidad -= fuerzaDeDesgaste; }

    public int getDurabilidad(){
        return this.durabilidad;
    }
}
