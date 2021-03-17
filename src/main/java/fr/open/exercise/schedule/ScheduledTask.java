package fr.open.exercise.schedule;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;

import fr.open.exercise.util.HostUtils;

public class ScheduledTask extends TimerTask {

	/**
	 * Pour des raisons de commodités, nous considérons que le fichier log se trouve dans le disque
	 * et son chemin d'accès est : c:/exerciseLog.txt
	 * Cette permet permet de lire le log, trouver l'ensemble des connexions pour chaque hôte
	 * et l'hôte qui a établi le plus de connexions et le nombre correspondant
	 */
	@Override
	public void run() {
		String filePath = "c:/exerciseLog.txt";
		Map<String, List<String>> connexions = HostUtils.getConnexionsMap(filePath);
		List<String> hostWithMaxConnexions = HostUtils.getHostWithMaxConnexions(connexions);
		Iterator<Map.Entry<String, List<String>>> iter = connexions.entrySet().iterator();
		Map.Entry<String, List<String>> entree;
		
		while(iter.hasNext()) {
			entree = iter.next();
			System.out.println("******* L'hôte " + entree.getKey() + " a établi les connexions aux hôtes suivants *******");
			for (String host: entree.getValue()) {
				System.out.println(host);
			}
		}
		
		System.out.println("*** L'hôte qui a établi le plus de connexions est " + hostWithMaxConnexions.get(0) 
		+ " et son nombre de connexions est " + hostWithMaxConnexions.get(1));
		
	}

}
