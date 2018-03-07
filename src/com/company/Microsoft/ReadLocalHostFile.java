package com.company.Microsoft;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReadLocalHostFile {

	public static void main(String args[]) throws Exception {
		Scanner in = new Scanner(System.in);
		String filename = in.nextLine();
		// readTextFile(filename);
		readTextFile("msinputfile.txt");
		in.close();
	}

	public static void readTextFile(String fileName) {
		long count = 0;
		long sum = 0;
		try {
			File file = new File(fileName);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			StringBuilder inputBuffer = new StringBuilder();
			String line = null;
			do {
				line = reader.readLine();
				if (null != line) {
					String[] arr = line.split(" ");
					if (Integer.parseInt(arr[arr.length-1]) > 5000) {
						count++;
						sum += Integer.parseInt(arr[arr.length-1]);
					}
					inputBuffer.append(line.trim());
				}
			} while (line != null);
			reader.close();
		} catch (IOException ex) {
			System.out.println("File not found");
		}
		// System.out.println(count);
		// System.out.println(sum);
		writeToTextFile("msoutputfile.txt", count, sum);
	}

	public static void writeToTextFile(String fileName, long count, long sum) {
		File file = new File(fileName);
		if (!file.exists()) {
			try {
				file.createNewFile();
				FileWriter fileWrite = new FileWriter(file);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWrite);
				bufferedWriter.write(count+"");
				bufferedWriter.newLine();
				bufferedWriter.write(sum+"");
				bufferedWriter.close();
			} catch (IOException e) {
				System.out.println("Error while creating file");
			}
		}
	}
}