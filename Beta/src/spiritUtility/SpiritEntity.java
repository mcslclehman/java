package spiritUtility;


import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import engine.GameUtility;



abstract class SpiritEntity implements KeyListener{
	
	BufferedImage spiritSheetFile;
	BufferedImage[][] spriteSheetAction;
	HashMap<SpiritActionType,SpiritAction> spiritSheet = new HashMap<SpiritActionType,SpiritAction>();
	
	private String spiritFileName;
	
	boolean wholeSpriteSheet  = false;
	boolean actionSpriteSheet = false;
	
	private int animationIndex =0;
	
	public SpiritEntity(String spiritFileName) {
		
		this.spiritFileName =spiritFileName;
		this.spiritSheetFile = GameUtility.loadImageFromDirectoryFile(spiritFileName);
	}
	
	public void addSpiritAction(SpiritAction action){		
		spiritSheet.put(action.getActionType(), action);
	}
	
	public boolean buildSpiritAction(SpiritActionType type, int frameAmount, int[] x_Pos, int[] y_Pos, int[] width, int[] height){
		
		if(frameAmount<0){
			Logger.getLogger(GameUtility.class.getName()).log(Level.WARNING, "Frame length neg: "+frameAmount);
			return false;
		}
		if(x_Pos.length == frameAmount && y_Pos.length == frameAmount && width.length == frameAmount && height.length == frameAmount){
			
			SpiritAction action = new SpiritAction(type,frameAmount);
			
			for(int i=0; i<frameAmount; i++){
				
				action.setSpiritFrame(i, GameUtility.spiritActionLoader(spiritSheetFile, x_Pos[i], y_Pos[i], width[i], height[i]));
			}
			addSpiritAction(action);
			
			return true;
		}
		Logger.getLogger(GameUtility.class.getName()).log(Level.WARNING, "Data array miss match: ");	
		return false;
		
	}
	
/*	public void buildCharacterSprite(String spriteFileName, int width, int height, int rows, int columns){
		
		spriteSheet = GameUtility.spriteSheetLoader(GameUtility.loadImageFromDirectoryFile(spriteFileName), width, height, rows, columns);
		actionSpriteSheet = !actionSpriteSheet;
	}*/
	
	public void buildCharacterSprite(String spriteFileName, int[] width, int[] height, int rows, int[] columns){
		
		spriteSheetAction = GameUtility.spriteActionSheetLoader(GameUtility.loadImageFromDirectoryFile(spriteFileName), width, height, rows, columns);
		actionSpriteSheet = !actionSpriteSheet;
	}
	
	public void animation(Graphics g, SpiritActionType type, int frameNumber, int x_Pos, int y_Pos){		
		
            g.drawImage(spiritSheet.get(type).getSpiritFrame(frameNumber), x_Pos, y_Pos, null);	
		
	}
	
	public void paint(Graphics g) {
		
/*		int rows = 17;
		int columns = 10;
		
		if(wholeSpriteSheet && !actionSpriteSheet){
		   for(int i = 0; i < rows; i++) {
			      for(int j = 0; j < columns; j++) {
	                  g.drawImage(spriteSheet[(i * columns) + j], 100+(j*64), 100+(i*100), null);
 
		          }
		   } 
		}
		else if(actionSpriteSheet && !wholeSpriteSheet){
			
		   for(int i = 0; i < rows; i++) {
				      for(int j = 0; j < spriteSheetAction[i].length; j++) {
		                  g.drawImage(spriteSheetAction[i][j], 100+(j*100), 100+(i*100),null);
		               	 
			          }
			   } 
			
		}*/
		
		
		
		
		
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

		
	}

	public int getAnimationLenght(SpiritActionType type) {
		return spiritSheet.get(type).getFrameLenght();
	}
	
	
	public boolean hasActionType(SpiritActionType type){
		return spiritSheet.containsKey(type);
	}

/*	public void setAnimationLenght(int frameLenght) {
		this.animationIndex = frameLenght;
	}
	public void increaseAnimationIndex() {
		animationIndex++;
	}*/
	
/*	public int getAnimationLength(int index) {
		if(wholeSpriteSheet && !actionSpriteSheet){
			 return spriteSheet.length;
	    }
		else if(actionSpriteSheet && !wholeSpriteSheet){
	         return spriteSheetAction[index].length;
		}
		return 0;
	}*/

}
