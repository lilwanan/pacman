import java.util.concurrent.Semaphore;

public class Fantasma implements Runnable {

	private int posx;
	private int posy;
	private Tablero tab;
	private Semaphore semaforo;
	
	
	
	
	public Fantasma(int posx, int posy, Tablero tab) {
		
		this.posx = posx;
		this.posy = posy;
		this.tab=tab;
		this.semaforo = tab.getSemaforo();
		tab.actualizarPosicion(posx, posy, " F ");
	}
	
	public void mover() {
		int nuevax = posx;
		int nuevay = posy;
		int movimiento = (int) (Math.random()*4);
		switch (movimiento) {
			case 0:
				if(posx>1) {
					nuevax--;
				}
				break;
			case 1:
				if(posx<Tablero.getFilas()-2) {
					nuevax++;
				}
				break;
			case 2:
				if(posy>0) {
					nuevay--;
				}
				break;
			case 3:
				if(posy<Tablero.getColumnas()-2) {
					nuevay++;
				}
				break;
		}
		String posSiguiente = tab.getMatrTab()[nuevax][nuevay];
		if(posSiguiente.equals(" | ") || posSiguiente.equals("───") || posSiguiente.equals(" F ")) {
			return;
		}
		
		tab.moverFantasma(posx, posy);
		posx=nuevax;
		posy=nuevay;
		tab.actualizarPosicion(posx, posy, " F ");
		
		
	}




	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				tab.borrarMapa();
				semaforo.acquire();
				mover();
				tab.mostrarLaberinto();
				semaforo.release();
				if(tab.getDificultad()==1) {
					Thread.sleep(1200);
				} else if(tab.getDificultad()==2) {
					Thread.sleep(800);
				} else if(tab.getDificultad()==3) {
					Thread.sleep(400);
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	
}
