
public class Powerup {
	String s;
	int type;
	int x;
	int y;
	int width = 20;
	int height = 20;
	PongGame game;
	Ball b;
	
	public Powerup(PongGame g, int x1, int y1){
		this.x = x1;
		this.y = y1;
		type = 1;
		s = "P";
		if(Math.random()*10 > 5){
			type = 2;
			s = "B";
		}
		if(Math.random()*10 > 5){
			type = 3;
			s = "?";
		}
		this.game = g;
	}

	void run(){
		if(type == 1)
			game.paddle.width = game.paddle.width + ((int)(game.paddle.width*.10));
		if(type == 3)
		game.paddle.width = game.paddle.width - ((int)(game.paddle.width*.10));
		if(type == 2){
			b = new Ball(200, 200, 20, 20);
			b.in_play = true;
			game.ball_list.add(b);
		}
		
		
	}
	void move(){
	y = y +7;
	}
}
