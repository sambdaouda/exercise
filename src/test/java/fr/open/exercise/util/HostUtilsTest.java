package fr.open.exercise.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HostUtilsTest {
	
	private Map<String, List<String>> connexions;
	private String filePath;
	
	@BeforeEach
	public void initData() {
		filePath = "c:/exerciseLog.txt";
		
		connexions = new HashMap<String, List<String>>();
		connexions.put("quark", Arrays.asList("garak", "brunt", "lilak", "proton", "xeon", "neutron"));
		connexions.put("photon", Arrays.asList("proton", "neon", "lilak", "neutron"));
		connexions.put("astre", Arrays.asList("proton", "neon", "lilak", "neutron", "phyto"));
	}
	
	
	@Test
	@DisplayName("Récupère la liste des connexions pour chaque hôte")
	public void testGetConnexionsMap() {
		HostUtils.getConnexionsMap(filePath);
	}
	
	@Test
	@DisplayName("Teste l'hôte qui a fait le maximum de connexions")
	public void testGetHostWithMaxConnexions() {
		List<String> result = HostUtils.getHostWithMaxConnexions(connexions);
		assertEquals("quark", result.get(0));
		assertEquals("6", result.get(1));
	}
	
}
