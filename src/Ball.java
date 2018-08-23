import java.awt.Color;


public class Ball {
	Boolean in_play = false;
	int x;
	int y;
	int width;
	int height;
	int speedX = 10;
	int speedY = -10;

	
	Color color;

	 public Ball(int x1, int y1, int w, int h){
		this.x = x1;
		this.y = y1;
		this.width = w;
		this.height = h;
//		this.x = x - (width/2);
//		this.y = y - (width/2);

	}
	 
	 void start_ball(){
		 in_play = true;
		 
	 }
	 

	 
	 void advance_ball(){
		 if(in_play == true){
			 

        	x += speedX;
        	y += speedY;
        	
        	if(speedX==0){
        		speedX = 1;
        	}
        	if(speedY==0){
        		speedY = 1;
        	}
        	
        	if(x +20 >= 500){
        		//if the ball hits the right side
        		//of the screen, then bounce off
        		x = x-5;
        		speedX *= -1;
        	}
        	if(x <= 0){
        		//if the ball hits the left side
        		//of the screen, then bounce off
        		x = x +5;
        		speedX *= -1;
        	}
//        	if(y + 20 >= 500){
//        		//if the ball hits the bottom
//        		//then bounce up
//        		y = y-5;
//        		speedY *= -1;
//        	}
        	if(y  <= 0){
        		//if the ball hits the top
        		//then bounce down
        		y = y+5;
        		speedY *= -1;
        	}
			
		}
	 }
	 
	 
	 
	 
	 
	
}
