package com.string;

public class CompareVersion {

	public static int compareVersion(String ver1, String ver2) {
		String version1[] = ver1.split("\\.");
		String version2[] = ver2.split("\\.");

		for (int index = 0; index < version1.length || index < version2.length; index++) {
			int v1 = 0;
			int v2 = 0;
			if (version1.length > index) {
				if ("" == version1[index]) {
					version1[index] = "0";
				}
				v1 = Integer.parseInt(version1[index]);
			}
			if (version2.length > index) {
				if ("".equalsIgnoreCase(version2[index])) {
					version2[index] = "0";
				}
				v2 = Integer.parseInt(version2[index]);
			}
			if (v1 > v2) {
				return 1;
			} else if (v2 > v1) {
				return -1;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		String v1 = "0.1";
		String v2 = ".1";
		int result = compareVersion(v1, v2);
		System.out.println(result);
	}
}