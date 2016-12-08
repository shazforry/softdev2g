import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import javax.xml.soap.Text;

public class Exit implements Actor {
	GameBoard gameBoard;
	int x =100;
	int y = 200;
	int size;
	
	Font font = new Font ("Verdana", 40,70);
	
	public Exit(GameBoard gameBoard){
		this.gameBoard = gameBoard;
	}
	@Override
	public void tick() {
		y+=1;
		
		
		
	}

	@Override
	public void draw(Graphics2D g2) {
		
		g2.setFont(font);
		g2.setColor(Color.RED);
		g2.drawString("GAMEOVER",x,y);
		
	}

}

