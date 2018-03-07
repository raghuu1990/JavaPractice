package com.company.soroco;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class Challenge {

	static void createInput(String output_file_path) {
		byte[] buffer = new byte[1024];
		Arrays.fill(buffer, (byte)1);
		File outputFileName = new File(output_file_path);
		try {
			if (!outputFileName.exists()) {
				outputFileName.createNewFile();
			}
			FileOutputStream fileOuputStream = new FileOutputStream(output_file_path);
			int i = 0;
			while (i++<10) {
				fileOuputStream.write(buffer);
			}
			fileOuputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void dedup(String input_file_path, String output_file_path) {
		byte[] buffer = new byte[1024];
		File outputFileName = new File(output_file_path);
		try {
			if (!outputFileName.exists()) {
				outputFileName.createNewFile();
			}
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			FileOutputStream fileOuputStream = new FileOutputStream(output_file_path);
			FileInputStream inputStream = new FileInputStream(input_file_path);
			
			for (int readNum; (readNum = inputStream.read(buffer)) != -1;) {
				bos.write(compress(buffer), 0, readNum);
			}
			byte[] aa = bos.toByteArray();
			fileOuputStream.write(aa);
			fileOuputStream.flush();
			inputStream.close();
			fileOuputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static boolean redup(String input_file_path, String output_file_path) {
		byte[] buffer = new byte[1024];
		File outputFileName = new File(output_file_path);
		try {
			if (!outputFileName.exists()) {
				outputFileName.createNewFile();
			}
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			FileOutputStream fileOuputStream = new FileOutputStream(output_file_path);
			FileInputStream inputStream = new FileInputStream(input_file_path);
			
			for (int readNum; (readNum = inputStream.read(buffer)) != -1;) {
				bos.write(decompress(buffer), 0, readNum); //no doubt here is 0
			}
			fileOuputStream.write(bos.toByteArray());
			fileOuputStream.flush();
			inputStream.close();
			fileOuputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// System.out.println("1234567890".getBytes());
		createInput("input.txt");
		dedup("input.txt", "middle.txt");
		redup("middle.txt", "output.txt");
	}

	public static byte[] compress(byte[] data) throws IOException {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		deflater.finish();
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer); // returns the generated code... index
			outputStream.write(buffer, 0, count);
		}

		outputStream.close();
		byte[] output = outputStream.toByteArray();
		return output;
	}

	public static byte[] decompress(byte[] data) throws IOException, DataFormatException {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!inflater.finished()) {
			int count = inflater.inflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		outputStream.close();
		byte[] output = outputStream.toByteArray();
		return output;
	}
}