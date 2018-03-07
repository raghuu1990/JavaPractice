package com.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;
import com.utils.StringUtils;

public class StaticContent {
	public static final String CSV_SEPARATOR = ",";
	public static final String CSV_QUOTE = "\"";

	public static final String PATH = "/home/raghvendra.krishan/workspace/JavaPractice/src/com/file/";

	public static void main(String[] args) {

		String gtaFileName = PATH + "galileocontent.csv";
		String domJsonFileName = PATH + "ESFeed.txt";

		String gtaDuplicate = PATH + "gtaDuplicate.csv";
		String gtaMatched = PATH + "gtaMatched.csv";
		String gtaUnmatched = PATH + "gtaUnmatched.csv";

		Map<String, DomesticData> domData = new HashMap<String, DomesticData>();
		Map<String, GTAData> gtaData = new HashMap<String, GTAData>();

		List<FinalData> matched = new ArrayList<FinalData>();
		List<FinalData> unmatched = new ArrayList<FinalData>();
		List<FinalData> duplicate = new ArrayList<FinalData>();

		gtaData = readDataFromCSV(gtaFileName);
		domData = readJsonDataFromTxtFile(domJsonFileName, duplicate);

		createFinalData(domData, gtaData, matched, unmatched);

		Collections.sort(duplicate, new FinalData());
		Collections.sort(matched, new FinalData());
		Collections.sort(unmatched, new FinalData());

		StringBuffer columnNames = new StringBuffer();
		columnNames.append(CSV_QUOTE + "Domestic City" + CSV_QUOTE);
		columnNames.append(CSV_SEPARATOR);
		columnNames.append(CSV_QUOTE + "GAL City" + CSV_QUOTE);
		columnNames.append(CSV_SEPARATOR);
		columnNames.append(CSV_QUOTE + "Country" + CSV_QUOTE);
		columnNames.append(CSV_SEPARATOR);
		columnNames.append(CSV_QUOTE + "Country Code" + CSV_QUOTE);
		columnNames.append(CSV_SEPARATOR);
		columnNames.append(CSV_QUOTE + "State" + CSV_QUOTE);
		columnNames.append(CSV_SEPARATOR);
		columnNames.append(CSV_QUOTE + "GAL City Code" + CSV_QUOTE);

		saveDataInCsvFile(duplicate, columnNames, gtaDuplicate);
		saveDataInCsvFile(matched, columnNames, gtaMatched);
		saveDataInCsvFile(unmatched, columnNames, gtaUnmatched);
		System.out.println("All CSVs Generated!!");
	}

	private static void createFinalData(Map<String, DomesticData> domData, Map<String, GTAData> gtaData,
			List<FinalData> matched, List<FinalData> unmatched) {

		Set<String> keysInDom = new HashSet<String>(domData.keySet());
		Set<String> keysInGta = new HashSet<String>(gtaData.keySet());

		Set<String> matchedkeys = new HashSet<String>(keysInDom);
		matchedkeys.retainAll(keysInGta);

		Set<String> unmatchedKeys = new HashSet<String>(keysInGta);
		unmatchedKeys.removeAll(keysInDom);

		matched = createFinalDataFromKeys(matchedkeys, matched, domData, gtaData);
		unmatched = createFinalDataFromKeys(unmatchedKeys, unmatched, null, gtaData);
	}

	private static List<FinalData> createFinalDataFromKeys(Set<String> keys, List<FinalData> responseData,
			Map<String, DomesticData> domData, Map<String, GTAData> gtaData) {
		try {
			for (String commonKey : keys) {
				FinalData data = new FinalData();
				GTAData galileoData = gtaData.get(commonKey);

				if (null != domData) {
					DomesticData domesticData = domData.get(commonKey);
					setDataInFinalData(responseData, data, domesticData, galileoData);
				} else {
					// Unmatched case
					setDataInFinalData(responseData, data, null, galileoData);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return responseData;
	}

	private static void setDataInFinalData(List<FinalData> responseData, FinalData data, DomesticData domesticData,
			GTAData galileoData) {
		if (null != domesticData && domesticData.isDuplicate()) {
			// System.out.println("Fail case : "+ domesticData.getCity());
		}

		if (null != domesticData && null != galileoData) {
			data.setDomesticCity(domesticData.getCity());
			data.setGalCity(galileoData.getName());
			data.setCountry(domesticData.getCountry());
			data.setCountryCode(domesticData.getCountryCode());
			data.setState(domesticData.getState());
			data.setGalCityCode(galileoData.getCityCode());
			responseData.add(data);
		} else if (null != galileoData) {
			data.setGalCity(galileoData.getName());
			data.setGalCityCode(galileoData.getCityCode());
			responseData.add(data);
		}
	}

	private static void saveDataInCsvFile(List<FinalData> finalData, StringBuffer columnNames, String filePath) {
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8"));
			bw.write(columnNames.toString());
			bw.newLine();

			for (FinalData data : finalData) {
				StringBuffer line = new StringBuffer();
				line.append(StringUtils.isNotEmpty(data.getDomesticCity())
						? (CSV_QUOTE + data.getDomesticCity() + CSV_QUOTE) : "\"\"");
				line.append(CSV_SEPARATOR);
				line.append(StringUtils.isNotEmpty(data.getGalCity()) ? (CSV_QUOTE + data.getGalCity() + CSV_QUOTE)
						: "\"\"");
				line.append(CSV_SEPARATOR);
				line.append(StringUtils.isNotEmpty(data.getCountry()) ? (CSV_QUOTE + data.getCountry() + CSV_QUOTE)
						: "\"\"");
				line.append(CSV_SEPARATOR);
				line.append(StringUtils.isNotEmpty(data.getCountryCode())
						? (CSV_QUOTE + data.getCountryCode() + CSV_QUOTE) : "\"\"");
				line.append(CSV_SEPARATOR);
				line.append(
						StringUtils.isNotEmpty(data.getState()) ? (CSV_QUOTE + data.getState() + CSV_QUOTE) : "\"\"");
				line.append(CSV_SEPARATOR);
				line.append(StringUtils.isNotEmpty(data.getGalCityCode())
						? (CSV_QUOTE + data.getGalCityCode() + CSV_QUOTE) : "\"\"");
				bw.write(line.toString());
				bw.newLine();
			}
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Map<String, DomesticData> readJsonDataFromTxtFile(String fileName, List<FinalData> duplicate) {
		Map<String, DomesticData> domesticDataMap = new HashMap<String, DomesticData>();
		JSONParser parser = new JSONParser();
		try {
			String line = "";
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			while ((line = br.readLine()) != null) {
				if(StringUtils.isEmpty(line)){
					continue;
				}
				JSONObject domesticData = (JSONObject) parser.parse(line);

				if (domesticData.containsKey("index")) {
					continue;
				}
				DomesticData domData = new Gson().fromJson(domesticData.toString(), DomesticData.class);
				if (true == domData.isDomestic() && StringUtils.isNotEmpty(domData.getCity())) {
					if (!domesticDataMap.containsKey(domData.getCity())) {
						domesticDataMap.put(domData.getCity(), domData);
					} else {
						DomesticData dupData = domesticDataMap.get(domData.getCity());
						// Duplicate Data
						domData.setDuplicate(true);

						if (false == dupData.isDuplicate()) {
							dupData.setDuplicate(true);
							domesticDataMap.put(dupData.getCity(), dupData);
							duplicate.add(new FinalData(dupData.getCity(), "", dupData.getCountry(),
									dupData.getCountryCode(), dupData.getState(), ""));
						}

						duplicate.add(new FinalData(domData.getCity(), "", domData.getCountry(),
								domData.getCountryCode(), domData.getState(), ""));

						if (dupData.getStateCode().equalsIgnoreCase(domData.getStateCode())
								&& dupData.getCountryCode().equalsIgnoreCase(domData.getCountryCode())) {
							if (StringUtils.isEmpty(dupData.getDisplayName())) {
								dupData.setDisplayName(domData.getDisplayName());
							}
							if (StringUtils.isEmpty(dupData.getType())) {
								dupData.setType(domData.getType());
							}
							if (StringUtils.isEmpty(dupData.getSourceID())) {
								dupData.setSourceID(domData.getSourceID());
							}
							if (StringUtils.isEmpty(dupData.getState())) {
								dupData.setState(domData.getState());
							}
							if (StringUtils.isEmpty(dupData.getCountry())) {
								dupData.setCountry(domData.getCountry());
							}
							if (StringUtils.isEmpty(dupData.getCity())) {
								dupData.setCity(domData.getCity());
							}
							if (StringUtils.isEmpty(dupData.getSupplier())) {
								dupData.setSupplier(domData.getSupplier());
							}
							if (StringUtils.isEmpty(dupData.getCountryCode())) {
								dupData.setCountryCode(domData.getCountryCode());
							}
							domesticDataMap.put(dupData.getCity(), dupData);
							// System.out.println("Duplicate DOM data : " +
							// domData.toString());
						} else {
							/*
							 * if(false==dupData.isDuplicate()){
							 * dupData.setDuplicate(true);
							 * domesticDataMap.put(dupData.getCity(), dupData);
							 * }
							 */

							System.out.println("duplicate "+domData.toString());
							Integer i = 1;
							while (domesticDataMap.containsKey(domData.getCity() + "-" + i)) {
								i++;
							}
							domData.setCity(domData.getCity() + "-" + i);
							domesticDataMap.put(domData.getCity(), domData);
							System.out.println("Same City name in DOM data : " + domData.toString());
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		System.out.println("Reading of DOM data completed");
		return domesticDataMap;
	}

	public static Map<String, GTAData> readDataFromCSV(String fileName) {
		Map<String, GTAData> gtaDataMap = new HashMap<String, GTAData>();
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try {
			br = new BufferedReader(new FileReader(fileName));
			while ((line = br.readLine()) != null) {
				GTAData gtaData = new GTAData();
				String[] data = line.split(cvsSplitBy);
				gtaData = new GTAData(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8]);
				if ("IN".equalsIgnoreCase(gtaData.getCountryCode())) {
					if (!gtaDataMap.containsKey(gtaData.getName())) {
						gtaDataMap.put(gtaData.getName(), gtaData);
					} else {
						GTAData dupData = gtaDataMap.get(gtaData.getName());
						if (dupData.getStateCode().equalsIgnoreCase(gtaData.getStateCode())
								&& dupData.getCountryCode().equalsIgnoreCase(gtaData.getCountryCode())
								&& dupData.getCityCode().equalsIgnoreCase(gtaData.getCityCode())) {
							System.out.println("Duplicate GTA data : " + gtaData.toString());
						} else {
							Integer i = 1;
							while (gtaDataMap.containsKey(gtaData.getName() + "-" + i)) {
								i++;
							}
							gtaData.setName(gtaData.getName() + "-" + i);
							gtaDataMap.put(gtaData.getName(), gtaData);
							System.out.println("Same City name in GTA data : " + gtaData.toString());
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("Reading of data from GTA completed");
		return gtaDataMap;
	}
}
