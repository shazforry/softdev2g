import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;




public class Ball extends java.awt.geom.Ellipse2D.Double implements Actor {
	
	Color color;
	GameBoard gameBoard;
	double vx,absVx;
	double vy,absVy;
	double size;
	
	static Color colors[] = {Color.BLACK, Color.PINK,Color.GREEN,Color.YELLOW,Color.BLUE,};
	
	
	public Ball(GameBoard gb){
		Random generator = new Random(); 
		
		this.gameBoard=gb;
		color = colors[generator.nextInt(colors.length)];
		
		Random randomGenerator=new Random();
		this.size = 30 + randomGenerator.nextDouble()*70;
		this.width=this.size;
		this.height=this.size;
		
		this.x=randomGenerator.nextDouble()* (400-this.size);
		this.y=randomGenerator.nextDouble()* (400-this.size);
		
		if (randomGenerator.nextInt(2)==0){
			this.x= randomGenerator.nextInt(2)*
	(gameBoard.getWidth()+this.size)-this.size;
			this.y=randomGenerator.nextDouble()*
	(gameBoard.getHeight()+this.size)-this.size;
			
			}
		else {
			
			this.x= randomGenerator.nextDouble()*(gameBoard.
	getWidth()-this.size);
			
			this.y= randomGenerator.nextInt(2)*(gameBoard.
	getHeight()+this.size)-this.size;
		}
		
		absVx = gameBoard.MAXBALLSPEED *randomGenerator.nextDouble();
	
		
		vx = absVx * (-1 + (randomGenerator.nextInt(2)*2));
		absVy = gameBoard.MAXBALLSPEED *randomGenerator.nextDouble();
		vy = absVy * (-1 + (randomGenerator.nextInt(2)*2));
	}
	@Override
	public void draw(Graphics2D g) {
		g.setColor(color);
		g.fill(this);
	}

	@Override
	public void tick() {
	
		this.x += vx;
		this.y += vy;
		
		if (x< 0){vx =absVx;}
		if (x> gameBoard.getWidth()-size){vx = -absVx;}
		if (y <0){vy = absVy;}
		if  (y> gameBoard.getHeight()-size){vy = -absVy;}
		
		
		
}
	}



	
