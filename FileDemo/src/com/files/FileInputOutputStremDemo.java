package com.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputStremDemo {

	public static void main(String[] args) throws IOException {
		
		FileOutputStream fileOutputStream = new FileOutputStream("data.txt", true);
		byte b[] = "Apples are red and roses as well".getBytes();
// 		fileOutputStream.write(b);
		fileOutputStream.write(b, 8, 10);
		fileOutputStream.close();

		File image = new File("/Users/Shalini/Downloads/meme1.png");
		FileInputStream fileInputStream = new FileInputStream(image);
		System.out.println("image length " +image.length());
		
		// creating hte array with the size of the file
		byte bytes[] = new byte[(int) image.length()];
		
		// reading the contents of meme and storing in  bytes[]
		int numofbytes = fileInputStream.read(bytes);
		System.out.println("num of bytes "+numofbytes);
		
		FileOutputStream stream1 = new FileOutputStream("first.png");
		stream1.write(bytes);
		stream1.close();
		fileInputStream.close();
		
	}

}
