package com.exception;

import java.io.FileWriter;
import java.io.IOException;

public class FinallyConcepts {


	public static void m1() throws IOException {
		FileWriter writer = null;
		try {
			writer = new FileWriter("D://file.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(1);
			throw new IOException(e.getMessage());
		}finally {
			System.out.println("closing file...");
			System.out.println(writer);
			try {
				writer.close();
			} catch (IOException | NullPointerException e) {
				// TODO Auto-generated catch block
				System.out.println(2);
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			m1();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(3);
	}

}
