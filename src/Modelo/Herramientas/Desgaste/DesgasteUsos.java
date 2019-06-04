package Modelo.Herramientas.Desgaste;

public class DesgasteUsos extends Desgaste {

    private int usos = 0;

    @Override
    public float desgastar(float numero) {
        this.usos++;
        if (this.usos == this.usosmaximos) return numero;
        return 0;
    }

}