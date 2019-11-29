package modelo;

import processing.core.PApplet;
import processing.core.PImage;

public class Personaje implements Runnable {
	
	private PApplet app;
	private PImage img;
	private int posX;
	private int posY;
	private String link;
	private int edad;
	private int numSuerte;
	private int dirX=1;
	
	public Personaje(int edad, int numSuerte, PApplet app,int posX,int posY,String link) {
		this.edad=edad;
		this.numSuerte=numSuerte;
		this.posX=posX;
		this.posY=posY;
		this.app=app;
		img=app.loadImage("simpson/homero_simpson.png");
		
	}
	
	public void pintar() {
		app.image(img, posX, posY,70,70);
	}
	
	public void mover() {
		posX+=dirX;
		
		if(posX<=250 || posX>=700) {
			dirX*=-1;
		}
	}

	@Override
	public void run() {
		mover();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
