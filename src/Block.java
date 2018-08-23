import java.awt.Color;
import java.util.HashMap;
import java.util.Map;


public class Block {

	int x;
	int y;
	int width = 80;
	int height = 20;
	Color color;
	Color[] c = {Color.BLUE, Color.GREEN, Color.RED, Color.YELLOW, Color.CYAN, Color.MAGENTA, Color.ORANGE,Color.PINK};
	int position;
	Boolean powerup = false;
	
	private static final Map<Integer, Integer> X_map = new HashMap<Integer, Integer>();
    static {
        X_map.put(1, 10);  X_map.put(2, 91);  X_map.put(3, 172);  X_map.put(4, 253);  X_map.put(5, 334);  X_map.put(6, 415);
        X_map.put(7, 10);  X_map.put(8, 91);  X_map.put(9, 172);  X_map.put(10, 253); X_map.put(11, 334);  X_map.put(12, 415);
        X_map.put(13 ,10); X_map.put(14, 91); X_map.put(15, 172); X_map.put(16, 253); X_map.put(17, 334); X_map.put(18, 415);
        X_map.put(19, 10); X_map.put(20, 91); X_map.put(21, 172); X_map.put(22, 253); X_map.put(23, 334); X_map.put(24, 415);
        X_map.put(25, 10); X_map.put(26, 91); X_map.put(27, 172); X_map.put(28, 253); X_map.put(29, 334); X_map.put(30, 415);
    }
    
    private static final Map<Integer, Integer> Y_map = new HashMap<Integer, Integer>();
    static {
        Y_map.put(1, 10);  Y_map.put(2, 10);  Y_map.put(3, 10);  Y_map.put(4, 10);  Y_map.put(5, 10);  Y_map.put(6, 10);
        Y_map.put(7, 31);  Y_map.put(8, 31);  Y_map.put(9, 31);  Y_map.put(10, 31); Y_map.put(11, 31);  Y_map.put(12, 31);
        Y_map.put(13, 52); Y_map.put(14, 52); Y_map.put(15, 52); Y_map.put(16, 52); Y_map.put(17, 52); Y_map.put(18, 52);
        Y_map.put(19, 73); Y_map.put(20, 73); Y_map.put(21, 73); Y_map.put(22, 73); Y_map.put(23, 73); Y_map.put(24, 73);
        Y_map.put(25, 94); Y_map.put(26, 94); Y_map.put(27, 94); Y_map.put(28, 94); Y_map.put(29, 94); Y_map.put(30, 94);
    }
	
    

	 public Block(int p){
		 this.position = p;
		 this.x = X_map.get(p);
		 this.y = Y_map.get(p);
		
		 color = c[(int)(Math.random()*7)];
		 if(Math.random()*100 > 85  ){ 
			 powerup = true;
		 }
	}
	
	
	
	
	
	
}

