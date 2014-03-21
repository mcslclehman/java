package engine;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;



public class GameUtility {
	
	

	
	public static BufferedImage loadImageFromDirectoryFile(String fileName){
		
		String path = System.getProperty("user.dir");
				
		
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File(path+fileName));
		    Logger.getLogger(GameUtility.class.getName()).log(Level.FINE, "Current working directory : " + path);
		    
		}
		catch (IOException e) {
			Logger.getLogger(GameUtility.class.getName()).log(Level.WARNING, "Current not working directory : " + path);
			
		}
		finally{
	        
	    }	
		
		return img;
	}
	
	public static BufferedImage[] spriteSheetLoader(BufferedImage spriteSheet, int width, int height, int rows, int columns){
					   
		   BufferedImage[] sprites = new BufferedImage[rows * columns];

		   for(int i = 0; i < rows; i++) {
		      for(int j = 0; j < columns; j++) {
		         sprites[(i * columns) + j] = spriteSheet.getSubimage(j * width, i * height, width, height);
		      }
		   }
		   
		   return sprites;
	}
	
	public static BufferedImage[][] spriteActionSheetLoader(BufferedImage spriteSheet, int[] width, int[] height, int rows, int columns[]){
		   
		BufferedImage[][] sprites = new BufferedImage[rows][10];
		
		for(int i = 0; i < rows; i++) {
		   for(int j = 0; j < columns[i]; j++) {
		       sprites[i][j] = spriteSheet.getSubimage(j * width[i], i * height[i], width[i], height[i]);
		   }
		}
		   
		   return sprites;
	}
	
	public static BufferedImage spiritActionLoader(BufferedImage spiritSheet, int x_Pos, int y_Pos, int width, int height){
		return spiritSheet.getSubimage(x_Pos, y_Pos, width, height);	 
	}
		
	

}
