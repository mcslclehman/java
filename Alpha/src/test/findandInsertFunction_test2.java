package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;

import elements.FunctionObject;
import elements.ParseType;

import tool.ParsingEngine;


public class findandInsertFunction_test2 {

	@Test
	public void test() {
		
		String testString = "public void function init (){ // do something} /n public void function myClass (){ // do something}";
		

		   String path = System.getProperty("user.dir");
		   Logger.getLogger(findandInsertFunction_test2.class.getName()).log(Level.FINE, "Current working directory : " + path);
		

		
		   FileWriter fileWriter = null;
	        try {
	            String content = testString;
	            File newTextFile = new File(path+"/test.txt");
	            fileWriter = new FileWriter(newTextFile);
	            fileWriter.write(content);
	            fileWriter.close();
	        } catch (IOException ex) {
	            Logger.getLogger(findandInsertFunction_test2.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            try {
	                fileWriter.close();
	            } catch (IOException ex) {
	                Logger.getLogger(findandInsertFunction_test2.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }
		
		ParsingEngine testBuilder = new ParsingEngine();
		
		try {
			testBuilder.findandInsertFunction(new File(path+"/test.txt"), ParseType.FUNCTION);
		} catch (IOException e) {
			Logger.getLogger(findandInsertFunction_test2.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
		}
		
		HashMap<String, FunctionObject> map = testBuilder.getFunctionList();
		Object[] list = map.keySet().toArray();
		
		for(int i=0; i< list.length; i++){
			String key = list[i].toString();
			System.out.println(key +" : "+map.get(key).toString());	
		}
		System.out.println("Done");	
		
		
	}

}
