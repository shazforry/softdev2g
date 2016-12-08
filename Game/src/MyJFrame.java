import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;



public class MyJFrame extends JFrame{
	
	GameBoard gameBoard = new GameBoard();
	final int keyUp=38;
	final int keyDown=40;
	final int keyLeft=37;
	final int keyRight=39;
	
	public MyJFrame(){
		super();
		initUI();
		placeComponents();
		bindListeners();
	}

	private void initUI() {
		this.setSize(600,600);
		this.setTitle("canvas");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}

	private void placeComponents() {
		this.getContentPane().add(gameBoard);
		
	}

	private void bindListeners() {
		this.addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent arg0) {
				onKey(arg0,true);
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				onKey(arg0,false);
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	}
	
	 void onKey(KeyEvent e, boolean yes){
		int keyCode =e.getKeyCode();
		System.out.println("key "+ keyCode+ "-"+e.getKeyChar());
		if (keyCode== this.keyUp){
			gameBoard.shipUp(yes);
		}
		if (keyCode== this.keyDown){
			gameBoard.shipDown(yes);
		}
		if (keyCode== this.keyLeft){
			gameBoard.shipLeft(yes);
		}
		if (keyCode== this.keyRight){
			gameBoard.shipRight(yes);
		}
	}
}
