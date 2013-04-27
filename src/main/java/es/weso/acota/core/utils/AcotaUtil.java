package es.weso.acota.core.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import es.weso.acota.core.business.enhancer.EnhancerAdapter;
import es.weso.acota.core.entity.TagTO;

/**
 * AcotaUtils provides a set of extra methods to manage enhancers and related data.
 * @author César Luis Alvargonzález
 * @since 0.3.8
 */
public class AcotaUtil {
	
	/**
	 * Sets the following enhancer as successor to the current enhancer, and so forth.
	 * @param enhancers Array of enhancers to enchain
	 * @return Supplied enhancers enchained
	 */
	public static EnhancerAdapter enchain(EnhancerAdapter[] enhancers){
		EnhancerAdapter initial = enhancers[0];
		EnhancerAdapter current = initial;
		for(int i=1;i < enhancers.length; i++){
			current.setSuccessor(enhancers[i]);
			current = enhancers[i];
		}
		return initial;
	}
	
	/**
	 * Sorts the tags within the Map, by value, and returns it as a sorted list
	 * @param labels Map with String as key and TagTO as value
	 * @return List composed by the sorted tags in descending order
	 */
	public static List<Entry<String, TagTO>> sortTags(Map<String, TagTO> labels) {
		ArrayList<Entry<String, TagTO>> tags = new ArrayList<Entry<String, TagTO>>(
				labels.entrySet());
		
		Collections.sort(tags, new Comparator<Entry<String, TagTO>>() {
			public int compare(Entry<String, TagTO> e1, Entry<String, TagTO> e2) {
				Double first = e1.getValue().getValue();
				Double second = e2.getValue().getValue();
				return second.compareTo(first);
			}
		});
		return tags;
	}
	
	/**
	 * Backups a Map with String as key and TagTO as value
	 * @param tags Map to clone
	 * @return Tags Map cloned
	 */
	public static Map<String, TagTO> backupTags(Map<String, TagTO> tags) {
		Map<String, TagTO> backupMap = new HashMap<String, TagTO>();
		
		for (Entry<String, TagTO> label : tags.entrySet()) {
			backupMap.put(label.getKey(), label.getValue());
		}
		
		return backupMap;
	}
}
