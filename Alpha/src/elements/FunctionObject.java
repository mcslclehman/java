package elements;

import java.util.HashMap;

public class FunctionObject {
	
	private HashMap<String, Object> theMap = new HashMap<String, Object>();
	
	
	
	public FunctionObject(){
		
		// constructor		
	}
	
	public void insertNewObject(String name, Object obj){
		
		theMap.put(name, obj);		
	}
	
	public Object extractObjectData(String name){
		
		return theMap.get(name); 
	}
	
	public boolean hasElementObject(String name){
		
		return theMap.containsKey(name);
	}

}
