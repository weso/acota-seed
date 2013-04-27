package es.weso.acota.core.entity;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import es.weso.acota.core.entity.ResourceTO;
import es.weso.acota.core.entity.SuggestionTO;
import es.weso.acota.core.entity.TagTO;
import es.weso.acota.core.utils.lang.LanguageDetector;

/**
 * 
 * SuggestionTO Unit Tests
 * @author César Luis Alvargonzález
 * 
 */
public class SuggestionTOTest {

	protected SuggestionTO suggestionTO;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.suggestionTO = new SuggestionTO();
	}

	@Test
	public void emptyConstructorTags() {
		assertEquals(Collections.EMPTY_MAP, suggestionTO.tags);
	}

	@Test
	public void ConstructorLabelsResource() {
		assertEquals(new ResourceTO(), suggestionTO.resource);
	}

	@Test
	public void ConstructorTagsTest() {
		this.suggestionTO = new SuggestionTO(null, new ResourceTO());
		assertEquals(null, suggestionTO.tags);
	}

	@Test
	public void ConstructorLabelsResourceTest() {
		ResourceTO resourceTO = new ResourceTO();
		this.suggestionTO = new SuggestionTO(null, resourceTO);
		assertEquals(resourceTO, suggestionTO.resource);
	}

	@Test
	public void getLabelsEmpty() {
		assertEquals(Collections.EMPTY_MAP, suggestionTO.getTags());
	}

	@Test
	public void getLabelsTest() {
		ResourceTO resourceTO = new ResourceTO();
		this.suggestionTO = new SuggestionTO(null, resourceTO);
		assertEquals(null, suggestionTO.getTags());
	}

	@Test
	public void getTagsEmpty() {
		assertEquals(Collections.EMPTY_MAP, suggestionTO.getTags());
	}

	@Test
	public void getTagsTest() {
		ResourceTO resourceTO = new ResourceTO();
		this.suggestionTO = new SuggestionTO(null, resourceTO);
		assertEquals(null, suggestionTO.getTags());
	}

	@Test
	public void getResourceEmpty() {
		assertEquals(new ResourceTO(), suggestionTO.getResource());
	}

	@Test
	public void getResourceTest() {
		ResourceTO resourceTO = new ResourceTO();
		this.suggestionTO = new SuggestionTO(null, resourceTO);
		assertEquals(resourceTO, suggestionTO.getResource());
	}

	@Test
	public void setLabelsEmpty() {
		suggestionTO.setTags(Collections.<String, TagTO> emptyMap());
		assertEquals(Collections.<String, TagTO> emptyMap(), suggestionTO.tags);
	}

	@Test
	public void setTagsEmpty() {
		suggestionTO.setTags(Collections.<String, TagTO> emptyMap());
		assertTrue(Collections.<String, TagTO> emptyMap() == suggestionTO.tags);
	}

	@Test
	public void setTagsTest() {
		suggestionTO.setTags(null);
		assertEquals(null, suggestionTO.tags);
	}

	@Test
	public void setResourceEmpty() {
		suggestionTO.setTags(null);
		assertEquals(null, suggestionTO.tags);
	}

	@Test
	public void setReourceTest() {
		ResourceTO resourceTO = new ResourceTO();
		suggestionTO.setResource(resourceTO);
		assertEquals(resourceTO, suggestionTO.resource);
	}

	@Test
	public void hashCodeEmpty() {
		assertEquals(924482, suggestionTO.hashCode());
	}

	@Test
	public void hashCodeTest() {
		ResourceTO resourceTO = new ResourceTO();
		this.suggestionTO = new SuggestionTO(null, resourceTO);
		assertEquals(924482, suggestionTO.hashCode());
	}

	@Test
	public void equalsNull() {
		assertFalse(suggestionTO.equals(null));
	}

	@Test
	public void equalsSameInstance() {
		assertEquals(suggestionTO, suggestionTO);
	}

	@Test
	public void equalsDifferentObject() {
		String object = new String("aux");
		assertFalse(suggestionTO.equals(object));
	}

	@Test
	public void equalsResourcesEquals() {
		SuggestionTO suggestion1 = new SuggestionTO(
				Collections.<String, TagTO> emptyMap(), new ResourceTO());
		SuggestionTO suggestion2 = new SuggestionTO(
				Collections.<String, TagTO> emptyMap(), new ResourceTO());

		assertEquals(suggestion1, suggestion2);
	}

	@Test
	public void equalsResourcesNulls() {
		SuggestionTO suggestion1 = new SuggestionTO(null, null);
		SuggestionTO suggestion2 = new SuggestionTO(null, null);

		assertEquals(suggestion1, suggestion2);
	}

	@Test
	public void equalsLabels() {
		Map<String, TagTO> tags = new HashMap<String, TagTO>();

		TagTO tag = new TagTO("a", LanguageDetector.ISO_639_ENGLISH, null, null);
		tag.setValue(2.0);
		tags.put(tag.getLabel(), tag);

		SuggestionTO suggestion1 = new SuggestionTO(
				Collections.<String, TagTO> emptyMap(), null);
		SuggestionTO suggestion2 = new SuggestionTO(tags, null);
		assertFalse(suggestion1.equals(suggestion2));
	}

	@Test
	public void equalsLabels1() {
		SuggestionTO suggestion1 = new SuggestionTO(null, null);
		SuggestionTO suggestion2 = new SuggestionTO(
				Collections.<String, TagTO> emptyMap(), null);

		assertFalse(suggestion1.equals(suggestion2));
	}

	@Test
	public void equalsResources() {
		ResourceTO resource = new ResourceTO();
		resource.setLabel("Cat");

		SuggestionTO suggestion1 = new SuggestionTO(null, new ResourceTO());
		SuggestionTO suggestion2 = new SuggestionTO(null, resource);

		assertFalse(suggestion1.equals(suggestion2));
	}

	@Test
	public void equalsResources2() {
		SuggestionTO suggestion1 = new SuggestionTO(null, null);
		SuggestionTO suggestion2 = new SuggestionTO(null, new ResourceTO());

		assertFalse(suggestion1.equals(suggestion2));
	}

}