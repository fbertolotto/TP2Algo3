package Vista;

import Modelo.Posicionable.Posicionable;

public class Comunicador {
	private double Y ;
	private double X ;
	private Posicionable posicionabletrasladado;

	public void asignarPosicionable(Posicionable posicionable){
		this.posicionabletrasladado = posicionable;
	}

	public Posicionable consultarPosicionable(){
		return posicionabletrasladado;
	}

	public void asignarPosicionMouse(double x, double y) {
		this.X = x;
		this.Y = y;
	}

	public double consultarPosicionMouseX(){
		return X;
	}

	public double consultarPosicionMouseY(){
		return Y;
	}
}
