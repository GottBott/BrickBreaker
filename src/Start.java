import java.util.LinkedList;



public class Start {
	public static Boolean windowOpen = false;

	public static double time;

	
	
	
	
	public static void main(String[] args) {
		
    	
		while (true){
		
			time = System.currentTimeMillis();
			Ball b = new Ball(230,450,20,20);
			LinkedList<Ball> blist= new LinkedList<Ball>();
			blist.add(b);
	    	Paddle p = new Paddle(200,470,75,12);
	    	
			
	    	PongGame game = new PongGame(p, blist);
			
			if (windowOpen == false)
				new KeyPressListener(game);
			windowOpen = true;
		        
			  	while(game.Over != true){
			  		double t = (System.currentTimeMillis()-time);
			  		if(t > 30){
				        time = System.currentTimeMillis();
				        game.update_game();
				        
			  	}
			}
			  	
			  	game = null;
			  	 
			  	 while (windowOpen == true){
			  		 
			  		 try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			  	 }
	  	
	  }	
	}

}
