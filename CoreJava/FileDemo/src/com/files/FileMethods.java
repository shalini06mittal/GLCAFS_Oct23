package com.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

/**
 * 2 types of streams
 * 1. character oriented => Reader , Writer
 * 2. byte => images / audio/ video, InputStream, OutputStream
 * @author Shalini
 *
 */
public class FileMethods {

	public static void main(String[] args) throws IOException {
		// create a file sample.txt in the folder "dir1"
		
		File dir1 = new File("dir1");
		System.out.println(dir1.mkdir());
		
		File file1 = new File("dir1", "sample1.txt");
		System.out.println(file1.createNewFile());
		
		File file2 = new File("dir1", "sample2.txt");
		System.out.println(file2.createNewFile());
		
		File file3 = new File("dir1", "sample3.txt");
		System.out.println(file3.createNewFile());
		
		File file4 = new File("dir1", "dir2");
		System.out.println(file4.mkdir());
		
		for(String file : dir1.list())
			System.out.println(file);
		
		file2.renameTo(new File("dir1","sam2.txt"));
//		for(File file :dir1.listFiles()) {
//			System.out.println(file.getName()+" "+file.getAbsolutePath());
//			System.out.println(file.isFile()+" "+file.isDirectory());
//			if(file.isFile())
//				file.delete();
//		}
//		System.out.println(file.delete());
//		System.out.println(dir1.delete());
	}

}
