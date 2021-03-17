package fr.open.exercise.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HostUtils {

	
	/**
	 * Récupère les connexions à partir du fichier de log et les met dans le map
	 * 
	 * @param file
	 * @return
	 */
	public static Map<String, List<String>> getConnexionsMap(String filePath) {
		Map<String, List<String>> connexions = new HashMap<String, List<String>>();
		try {
			InputStream inputStream = new FileInputStream(new File(filePath));
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
			String[] fileLines = br.lines().toArray(String[]::new);
			String[] parts;
			
			for (int i = 0; i< fileLines.length; i++) {
				parts = fileLines[i].split(" ");
				if (connexions.containsKey(parts[1]))
					connexions.put(parts[1], Stream.of(connexions.get(parts[1]), Arrays.asList(parts[2]))
												   .flatMap(x -> x.stream()).collect(Collectors.toList()));
				else
					connexions.put(parts[1], Arrays.asList(parts[2]));
				
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) { 
			e.printStackTrace();
		}
		return connexions;
		
	}
	/**
	 * Trouve l'hôte qui a le plus de connexions et le nombre de connexions établies
	 * 
	 * @param connexions
	 * @return
	 */
	public static List<String> getHostWithMaxConnexions(Map<String, List<String>> connexions) {
		List<String> result = new ArrayList<String>();
		String host = null;
		int numberOfConnexions = Integer.MIN_VALUE;
		Iterator<Map.Entry<String, List<String>>> iter= connexions.entrySet().iterator();
		Map.Entry<String, List<String>> entree;
		
		while(iter.hasNext()) {
			entree = iter.next();
			if (numberOfConnexions < entree.getValue().size()) {
				host = entree.getKey();
				numberOfConnexions = entree.getValue().size();
			}
		}
		
		result.add(host);
		result.add(String.valueOf(numberOfConnexions));
		return result;
	}
}
