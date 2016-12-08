import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;

public class Ship extends Polygon implements Actor {
	int vx=0;
	int vy=0;
	GameBoard gameBoard;


	static final int[] initxPoints={-15,15,15,-15};
	static final int[] inityPoints={-15,-15,15,15};

	public Ship (GameBoard gameBoard) {
		super(initxPoints, inityPoints, inityPoints.length);
		this.translate(gameBoard.getWidth()/2, gameBoard.getHeight()/2);
		this.gameBoard= gameBoard;
		this.translate(200, 200);


	}
	@Override
	public void tick() {
		this.translate(vx, vy);
		// check bounds to gameboard
		
		// check collision
		for(Ball ball :gameBoard.balls){
			for (int i=0; i<inityPoints.length;i++){
				if (ball.contains(xpoints[i],ypoints[i])){
					gameBoard.gameOver();
				}
			}
		}

	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.fillPolygon(this);

	}

	public void moveUp(boolean yes){
		if(yes){
			vy = - GameBoard.SHIPSPEED;
		}else{
			vy = 0;
		}
	}

	public void moveDown(boolean yes){
		if(yes){
			vy =  GameBoard.SHIPSPEED;
		}else{
			vy = 0;
		}
	}

	public void moveLeft(boolean yes){
		if(yes){
			vx= - GameBoard.SHIPSPEED;
		}else{
			vx = 0;
		}
	}

	public void moveRight(boolean yes){
		if(yes){
			vx=  GameBoard.SHIPSPEED;
		}else{
			vx = 0;
		}
	}


}
