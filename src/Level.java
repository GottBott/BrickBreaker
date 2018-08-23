import java.util.LinkedList;



public  class Level {
	
	int num_blocks = 18;
	//LinkedList<Block> blocks_list;
	PongGame game;
	char[][] b;
	
	Level(PongGame g ,char[][] b){
		this.b = b;
		this.game = g;
	}
		
		void makeblocks(){
			
			//blocks_list = new LinkedList<Block>();
			game.blocks = new LinkedList<Block>();
			
			 for (int i = 0; i < 5; i++) {
		            for (int j = 0; j < 6; j++) {
		                if (b[i][j] == '=') {
		                	game.blocks.add(new Block(j+((i*6))+1));
		                }
		            }
			 }
			//return blocks_list;
			
		
		}
			
			
		
		void removeblocks(int i){
			// blocks_list.remove(i);
			game.blocks.remove(i);
			 //return blocks_list;
		}
		
		void test(){
			
		}
		

	}



