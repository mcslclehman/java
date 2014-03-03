package tool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import elements.FunctionObject;

public class ParsingEngine {

	private HashMap<String, FunctionObject> obj = new HashMap<String, FunctionObject>();
	
	public ParsingEngine(){
		
		// constructor
		
		
	}
	
	public void findandInsertFunction(File file, String str) throws IOException{
		BufferedReader bufferConvertedFile = new BufferedReader(new FileReader(file));
		String[] tempLine = new String[0];
		String line = null;
		while(true){
			line = bufferConvertedFile.readLine();
			if(line == null || line.isEmpty()){ break;}
			tempLine = line.split(" ");
				
			for(int index=0; index<tempLine.length; index++){
				
				if(tempLine[index].toLowerCase().contains(str.toLowerCase())){
					
					obj.put(tempLine[index+1], new FunctionObject());  
				}
				
			}
			
		}
		
		
	}
	
	public HashMap<String,FunctionObject> getFunctionList(){
		
		return obj;
	}
	
	
	
	
	
	
}
