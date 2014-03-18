package engine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

abstract class GameCharacterEntity{
	
	BufferedImage[] spriteSheet;
	BufferedImage[][] spriteSheetAction;
	
	boolean wholeSpriteSheet  = false;
	boolean actionSpriteSheet = false;
	
	public GameCharacterEntity() {
		
		
	}
	
	public void buildCharacterSprite(String spriteFileName, int width, int height, int rows, int columns){
		
		spriteSheet = GameUtility.spriteSheetLoader(GameUtility.loadImageFromDirectoryFile(spriteFileName), width, height, rows, columns);
		actionSpriteSheet = !actionSpriteSheet;
	}
	
	public void buildCharacterSprite(String spriteFileName, int[] width, int[] height, int rows, int[] columns){
		
		spriteSheetAction = GameUtility.spriteActionSheetLoader(GameUtility.loadImageFromDirectoryFile(spriteFileName), width, height, rows, columns);
		actionSpriteSheet = !actionSpriteSheet;
	}
	
	public void animation(Graphics g, int i){
		
		if(actionSpriteSheet && !wholeSpriteSheet){
			
            g.drawImage(spriteSheetAction[0][i], 100, 100, null);
			
		}
		
	}
	
	public void paint(Graphics g) {
		
		int rows = 17;
		int columns = 10;
		
		if(wholeSpriteSheet && !actionSpriteSheet){
		   for(int i = 0; i < rows; i++) {
			      for(int j = 0; j < columns; j++) {
	                  g.drawImage(spriteSheet[(i * columns) + j], 100+(j*64), 100+(i*100), null);
 
		          }
		   } 
		}
		else if(actionSpriteSheet && !wholeSpriteSheet){
			
/*			   for(int i = 0; i < rows; i++) {
				      for(int j = 0; j < spriteSheetAction[i].length; j++) {
		                  g.drawImage(spriteSheetAction[i][j], 100+(j*100), 100+(i*100),null);
		               	 
			          }
			   } */
			
		}
		
		
		
		
		
	}

}
