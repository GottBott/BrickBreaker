import java.awt.*; 
import java.awt.event.*;

import javax.swing.JFrame;
 
public class KeyPressListener  implements KeyListener, MouseMotionListener, MouseListener{  
  
	
	PongGame game;
	JFrame frame;

	
	
  
  public KeyPressListener(PongGame g) { 
	  this.game = g;
	  
	  JFrame frame = game.frame;
  	frame.setBackground(Color.gray);
  	frame.setExtendedState(Frame.MAXIMIZED_BOTH);  
  	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  	frame.setVisible(true);
  
	 frame = game.frame; 
	 
  	frame.getContentPane().add(new Drawgame(game));
  	
  	frame.setBackground(Color.GRAY);
  	frame.setSize(517, 540);
  	
  	
  	
  	frame.setLocationRelativeTo(null);
  	frame.setVisible(true);
  	frame.addKeyListener ( this); 
  	frame.addMouseMotionListener(this);
  	frame.addMouseListener(this);
  	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  	
  	

  }  
  
  
  
  public void keyTyped ( KeyEvent e ){  
  
 }  
  
  public void keyPressed ( KeyEvent e){  
	  int keyCode = e.getKeyCode();
	  
	    switch( keyCode ) { 
	        case KeyEvent.VK_SPACE:
	        	
	        	if(game.Over==true){
	        		Start.windowOpen = false;
	        		frame.dispose();
	        			
	        	}
	        	game.instructions = false;
	            game.ball_list.getFirst().start_ball();
	            break;
	        case KeyEvent.VK_ESCAPE:
	           frame.dispose();
	           System.exit(0);
	            break;
	        case KeyEvent.VK_LEFT:
        		
	        	if(!game.left_key)
	        		game.time5 = System.currentTimeMillis();
        		game.left_key = true;
        		
        		
        		
	        		
	            break;
	        case KeyEvent.VK_RIGHT :
	        	if(!game.right_key)
	        		game.time5 = System.currentTimeMillis();
	        	game.right_key = true;
	        		
	        		
	        	
	            break;
	     }
  }  
  public void keyReleased ( KeyEvent e ){ 
	  int keyCode = e.getKeyCode();
	  
	    switch( keyCode ) { 
	        case KeyEvent.VK_RIGHT:
	        	game.time5 = 0;
	        	game.right_key=false;
	        	
	        	break;
	        case KeyEvent.VK_LEFT:
	        	game.time5 = 0;
	        	game.left_key=false;
	        	
	        	break;
	    }
	 
  }





@Override
public void mouseDragged(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}



@Override
public void mouseMoved(MouseEvent arg0) {
	// TODO Auto-generated method stub
	int z = arg0.getX();
	//System.out.println(z);
	//x_mouse = z;
	if(z <430){
	game.paddle.x =z;
	}
	
}



@Override
public void mouseClicked(MouseEvent e) {
	if(game.Over==true){
		Start.windowOpen = false;
		frame.dispose();
			
	}
	game.instructions = false;
    game.ball_list.getFirst().start_ball();
}



@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}



@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}



@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}



@Override
public void mouseReleased(MouseEvent e) {
	
	
}
  
  
}

