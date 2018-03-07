package com.company.cleartax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Main {

	public static void main(String[] args) throws IOException {
		// JsonObject input = createJson();
		for (int i = 1; i <= 6; i++) {
			JsonObject input = readJsonFromFile("input"+i+".json");
			if (input != null && !input.isJsonNull()) {
				Node node = Parser.parse1(input);
				node.print(true);
				System.out.println();
				node = node.reverse();
				node.print(true);
				System.out.println();
				node.solveRHS();
				System.out.println(node.rightSum);
				System.out.println();
			}
		}
	}

	public static JsonObject readJsonFromFile(String fileName) {
		String text = getTextFromFile(fileName);
		try {
			if (text != null && !text.isEmpty()) {
				return new JsonParser().parse(text).getAsJsonObject();
			}
		}catch (Exception ex) {
			System.out.println("Invalid json found");
		}
		return null;
	}

	public static String getTextFromFile(String fileName) {
		try {
			File file = new File(fileName);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			StringBuilder inputBuffer = new StringBuilder();
			String line = null;
			do {
				line = reader.readLine();
				if (null != line) {
					inputBuffer.append(line.trim());
				}
			} while (line != null);
			reader.close();
			return inputBuffer.toString().trim();
		} catch (IOException ex) {
			System.out.println("File not found");
		}
		return null;
	}
	
	public static JsonObject createJson() {
		JsonObject input = new JsonObject();
		input.addProperty(Constants.OPERATION, Constants.EQUAL);

		JsonObject lhs = new JsonObject();
		lhs.addProperty(Constants.OPERATION, Constants.ADD);
		lhs.addProperty(Constants.LHS, 1);

		JsonObject rhs1 = new JsonObject();
		rhs1.addProperty(Constants.OPERATION, Constants.MULTIPLY);
		rhs1.addProperty(Constants.LHS, "x");
		rhs1.addProperty(Constants.RHS, 10);

		lhs.add(Constants.RHS, rhs1);

		input.add(Constants.LHS, lhs);
		input.addProperty(Constants.RHS, 21);
		return input;
	}
}