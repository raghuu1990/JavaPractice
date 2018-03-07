package com.prem.test;

import java.io.File;

/**
 * Created by lovebharti on 7/9/16.
 */
public class FilePath {
	public static void main(String[] args) {
		try {
			System.out.println((new File("").getCanonicalPath()));
		} catch (Exception e) {
		}
	}
}