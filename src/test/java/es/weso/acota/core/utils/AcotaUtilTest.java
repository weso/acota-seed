package es.weso.acota.core.utils;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import es.weso.acota.core.entity.TagTO;
import es.weso.acota.core.utils.lang.LanguageDetector;

public class AcotaUtilTest {
	
	@Test
	public void sortTags(){
		Map<String, TagTO> tags = generateTags();
		List<Entry<String, TagTO>> list = AcotaUtil.sortTags(tags);
		assertEquals(list.get(2).getKey(), "Quetzal");
	}
	
	@Test (expected = NullPointerException.class)
	public void sortNullTags(){
		Map<String, TagTO> tags = null;
		List<Entry<String, TagTO>> list = AcotaUtil.sortTags(tags);
		assertEquals(list.get(2).getKey(), "Quetzal");
	}
	
	@Test
	public void backupsTags(){
		Map<String, TagTO> tags = generateTags();
		Map<String, TagTO> backupTags = AcotaUtil.backupTags(tags);
		
		assertEquals(backupTags, tags);
	}
	
	@Test (expected = NullPointerException.class)
	public void backupsNullTags(){
		Map<String, TagTO> tags = null;
		Map<String, TagTO> backupTags = AcotaUtil.backupTags(tags);
		
		assertEquals(backupTags, tags);
	}
	
	private Map<String, TagTO> generateTags(){
		Map<String, TagTO> tags = new HashMap<String,TagTO>();
		
		TagTO tag = new TagTO("Quetzal", LanguageDetector.ISO_639_ENGLISH, null, null);
		tag.setValue(5);
		tags.put("Quetzal",tag);
		
		tag = new TagTO("Ringtail", LanguageDetector.ISO_639_ENGLISH, null, null);
		tag.setValue(10);
		tags.put("Ringtail",tag);
		
		tag = new TagTO("Salamander", LanguageDetector.ISO_639_ENGLISH, null, null);
		tag.setValue(8);
		tags.put("Salamander",tag);
		return tags;
	}

}
