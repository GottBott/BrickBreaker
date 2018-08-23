import java.util.LinkedList;

import javax.swing.JFrame;

public class PongGame {

	int Score =0;
	int paddle_width;
	int num_level;
	long time5; 
	double update_time = System.currentTimeMillis();
	double starttime;
	double seconds;
	double minutes;
	JFrame frame = new JFrame();
	Paddle paddle;
	Level level;
	Boolean right_key;
	Boolean left_key;
	Boolean Over = false;
	LinkedList<Block> blocks;
	LinkedList<Powerup> power_list;
	LinkedList<Ball> ball_list;
	boolean instructions = true;
	
	

	PongGame(Paddle p, LinkedList<Ball> b){
		this.ball_list = b;
		this.paddle = p;
		this.starttime = System.currentTimeMillis();
		this.level = new Level(this, Level_data.L1);	
		level.makeblocks();
		this.num_level = 1;
		this.right_key = false;
		this.time5 = System.currentTimeMillis();
		this.left_key = false;
		power_list = new LinkedList<Powerup>();
		paddle_width = p.width;
		
		
		
	}
	
	void update_game(){
		
		for(int i = 0; i< ball_list.size(); i++){
			ball_list.get(i).advance_ball();
		}
		update_time();
		//a_i();
		check_on_paddle();
		check_on_blocks();
		is_over();
		level_up();
		update_bar();
		on_powerup();
		
		
	}
	
	void on_powerup(){
		for(int i = 0; i< power_list.size(); i++){
			Powerup p = power_list.get(i);
			p.move();
		
			if(p.y +20 >= paddle.y && p.y < paddle.y + paddle.height){
				if(p.x +20  >= paddle.x && p.x  <= paddle.x + paddle.width){
					p.run();
					power_list.remove(i);
				}
			}
		}
		
	}
	
	public void update_bar(){
		  
		  String sec = Integer.toString((int)seconds);
		  String min = Integer.toString((int)minutes);
		  String lev = ("Level: "+ Integer.toString(num_level)+ "   " );
		  String score =("Score: " + Integer.toString(Score));
		  if (Over == true){
		  		frame.setTitle("GAME OVER!");
		  	}
		  else{
			  
			  frame.setTitle(lev + "Time: " + min + ":" + sec  +"    " + score +"      Brick Breaker!   " );
		  }
		}
	
	void update_time(){
		double elapsed = System.currentTimeMillis()- starttime;
	  	
		seconds = ((elapsed/1000)%60);
		minutes = (int) (elapsed / 60000);
	  	 
	}
	
	void check_on_paddle(){
		for(int i = 0; i< ball_list.size(); i++){
			if(ball_list.get(i).y +20 >= paddle.y && ball_list.get(i).y < paddle.y + paddle.height){
				if(ball_list.get(i).x +20  >= paddle.x && ball_list.get(i).x  <= paddle.x + paddle.width){
					calcBallAngle(i);
				}
			}
		}
	}
	
	void calcBallAngle(int b){
		
			//ballPosition is the position of the ball is on the paddle 
			int ball_position = ball_list.get(b).x - paddle.x;
			double hit = ((paddle.width/2) - ball_position );
			ball_list.get(b).speedX = (int) (hit * -.3);
			//Making the ball bounce back up
			ball_list.get(b).speedY *= -1;
			ball_list.get(b).y = ball_list.get(b).y-5;
		}
	
	
	void check_on_blocks(){
		for(int i = 0; i < ball_list.size(); i++){
			for(int j = 0; j< blocks.size(); j++){
				if(ball_list.get(i).y  <= blocks.get(j).y + blocks.get(j).height && ball_list.get(i).y + 20 >= blocks.get(j).y){
					if(ball_list.get(i).x + 20 >= blocks.get(j).x && ball_list.get(i).x <= blocks.get(j).x + blocks.get(j).width){
						
						Block b = blocks.get(j);
						if(b.powerup ==true){
							//System.out.println("powerup detected");
							power_list.add(new Powerup(this,(b.x + (b.width/2))-10,b.y));
							
						}
						level.removeblocks(j);
						ball_list.get(i).speedY *= -1;
						Score++;
						
					}
				}
			}
		}
	}
	
	
	void is_over(){
		
		for(int i = 0; i< ball_list.size(); i ++){
			if(ball_list.get(i).y + 10 >= 490){
				ball_list.remove(ball_list.get(i));
				if(ball_list.size() == 0)
					Over = true;
					
		
			}
		}

	}
		
	void level_up(){
		
		
		if(blocks.size() == 0){
			num_level++;
			paddle.width = paddle_width; 
			
			if(num_level == 1){
				level = new Level(this,Level_data.L2);
				level.makeblocks();
			}
		
			if(num_level == 2){
				level = new Level(this,Level_data.L2);
				level.makeblocks();
			}
			if(num_level == 3){
				level = new Level(this,Level_data.L3);
				level.makeblocks();
			}
			if(num_level == 4){
				level = new Level(this,Level_data.L4);
				level.makeblocks();
			}
			if(num_level == 5){
				num_level = 0;
			}
			
		}
	}

	
	
	void a_i(){
		
		paddle.x = ball_list.get(0).x -((int)(Math.random()*paddle.width));
	}
	
	
	
	
}
