import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class GameBoard extends JPanel {
	private static final int initialBalls =10;
	public static final double MAXBALLSPEED = 3;
	public static final int SHIPSPEED = 3; 
	
	Set <Actor> actors;
	Set<Ball> balls= new HashSet<Ball>();
    Thread thread;
    Ship ship;
    Exit GameOverSign = new Exit(this);
    boolean gameOver = false;
    

	public GameBoard (){
		super();

		this.setBackground(Color.LIGHT_GRAY);

		actors = new HashSet<Actor>();
		for (int i =0; i <initialBalls; i++){
			addBall();
		}
		ship=new Ship(this);
		actors.add(this.ship);
		
		thread = new Thread (new GameRunner(this));
		thread.start();
		
		
	}
	public void addBall(){
		Ball b = new Ball(this);
		actors.add(b);
		balls.add(b);
	
	}
	
	public void shipUp(boolean yes){
		ship.moveUp(yes);
	}
	
	public void shipDown(boolean yes){
		ship.moveDown(yes);
	}
	
	public void shipLeft(boolean yes){
		ship.moveLeft(yes);
		
		
	}
	public void shipRight(boolean yes){
		ship.moveRight(yes);
	}
	

	@Override 
	public void paint (Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;

		for (Actor actor : actors){
			actor.draw(g2d);
			
		}
	}
	
	
	public void moveAll (){
		for(Actor actor : actors ){
			actor.tick();
		}
		if (gameOver){
			actors.remove(ship);
			actors.add(GameOverSign);
			//thread.interrupt();
			
		}
		this.repaint();
	}
	
	public void gameOver(){
		gameOver = true;
		System.out.println("game over");
		
	}
	public void gameOn(){
		actors.remove(GameOverSign);
	}


}
