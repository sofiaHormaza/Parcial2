package vista;

import modelo.Logica;
import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet {
	
	Logica logica;

	public static void main(String[] args) {
		PApplet.main("vista.Main");
	}
	
	public void settings() {
		size(800,600);
	}
	
	public void setup() {
		logica=new Logica(this);
	}
	
	public void draw() {
		background(255);
		fill(255,255,0);
		rect(0,0,250,600);
		
		
		logica.crearBoton();
		logica.pintarPersonajes();
		logica.moverPersonaje();
		logica.pintarIzquierda();
		logica.noAgregarMas();
		
	}
	
	public void mousePressed() {
		logica.crearPersonaje();
		logica.aLaIzquierda();
	}

}
