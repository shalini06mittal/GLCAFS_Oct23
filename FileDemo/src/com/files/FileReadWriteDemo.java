package com.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReadWriteDemo {

	// character stream => read and write textual content
	/**
	 * 1. File Writer has overloaded constructors that take either File object or String filename
	 * 2. It creates a file if it does not exist ot will overwrite in the same fils if it exists
	 * 3. To append in the same file pass 2nd parameter to the constructor as true
	 * @param filename
	 */
	public static void writeToFile(String filename) {
		//1.
		File file = new File(filename);
		FileWriter writer = null;
		try {
			// writer creates the file if it doesnt exist
			writer = new FileWriter(file, true);
			writer.write("Apples!!\n");
			writer.write("Oranges!!\n");
			writer.write("Grapes\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				writer.close();// flushes and saves the content
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void writeToFileWithoutFile(String filename) {
		//1.
		//File file = new File(filename);
		FileWriter writer = null;
		try {
			// writer creates the file if it doesnt exist
			writer = new FileWriter(filename);
			writer.write("Hey!!");
			writer.write("Welcome!!");
			writer.write("Bye!!");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				writer.close();// flushes and saves the content
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void readFromFile(String filename) throws IOException {
		FileReader reader = new FileReader(filename);
		//System.out.println((char)reader.read());
		
		BufferedReader bufferedReader = new BufferedReader(reader);
//		System.out.println(bufferedReader.readLine());
		String str= null;
		while( (str = bufferedReader.readLine()) != null)
		{
			System.out.println(str);
		}
		
		System.out.println("reading...");
		reader.close();
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		writeToFile("contents.txt");
//		writeToFileWithoutFile("dummy.txt");
		
		readFromFile("contents.txt");
	}

}
