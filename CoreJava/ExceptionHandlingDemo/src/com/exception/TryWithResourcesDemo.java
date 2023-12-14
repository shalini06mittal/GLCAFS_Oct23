package com.exception;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class TryWithResourcesDemo {

	public static void main(String[] args) {
		
		// try with resources => it automatically closes the resource
		try(FileWriter writer = new FileWriter("some.txt")){
			writer.write("hey");
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
