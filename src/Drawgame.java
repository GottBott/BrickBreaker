import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
 
public class Drawgame extends JPanel {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PongGame game;
	
	Drawgame(PongGame g){
		this.game = g;
	}
    
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    
    for(int i = 0; i<game.blocks.size(); i++){
    	
    	g.setColor(game.blocks.get(i).color);
        g.fillRoundRect(game.blocks.get(i).x, game.blocks.get(i).y, game.blocks.get(i).width, game.blocks.get(i).height, 0,0);
    	//g.fill3DRect(game.blocks.get(i).x, game.blocks.get(i).y, game.blocks.get(i).width, game.blocks.get(i).height, true);
    }
    
    g.setColor(Color.BLACK);
    
    for(int i = 0; i<game.power_list.size(); i++){
    	Font f = new Font("serif", Font.BOLD, 15);
    	g.setFont(f);
        g.drawRect(game.power_list.get(i).x , game.power_list.get(i).y, game.power_list.get(i).width, game.power_list.get(i).height);
        g.drawString(game.power_list.get(i).s, game.power_list.get(i).x +6, game.power_list.get(i).y + 15);
    }
    
    
    g.setColor(Color.RED);
    for(int i = 0; i< game.ball_list.size(); i ++){
    	g.fillArc(game.ball_list.get(i).x, game.ball_list.get(i).y, game.ball_list.get(i).width, game.ball_list.get(i).height, 0, 360);
    }
	g.setColor(Color.BLACK);
    g.fillRoundRect(game.paddle.x,game.paddle.y,game.paddle.width,game.paddle.height,10,50);
    
    

    g.drawRect(0, 0, 500,500);
    //g.drawRect(game.paddle.x, 0, game.paddle.width, 500);
   // g.drawRect(game.ball.x, game.ball.y, 20, 20);
    
    if(game.Over == true){
    	g.setColor(Color.BLACK);
    	Font f = new Font("serif", Font.BOLD, 30);
    	g.setFont(f);
    	g.drawString("GAME OVER!", 150, 250);
    	
    	g.drawString( Integer.toString((int)game.minutes)+ " Minutes & " + Integer.toString((int)game.seconds)+ " Seconds", 100, 350);
    	g.drawString("Score: " + game.Score, 200, 400);
    }
    
    if(game.instructions == true){
    	g.setColor(Color.BLACK);
    	Font f = new Font("serif", Font.BOLD, 25);
    	g.setFont(f);
    	g.drawString("-Instructions-", 170, 150);
    	Font a = new Font("serif", Font.BOLD, 15);
    	g.setFont(a);
    	g.drawString("Press spacebar or click to start", 140, 180);
    	g.drawString("Use mouse to move paddle", 155, 205);
    	g.drawString("Game ends when ball hits the floor", 130, 230);
    	g.drawString("Press spacebar or click to Reset", 140, 255);
    }
    repaint();
    
    	
  }
  

  
}