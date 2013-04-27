package es.weso.acota.core.entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.weso.acota.core.entity.ProviderTO;

/**
 * ProviderTO Unit Tests
 * @author César Luis Alvargonzález
 *
 */
public class ProviderTOTest {

	protected ProviderTO providerTO;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.providerTO = new ProviderTO();
	}

	@Test
	public void emptyConstructorProvider() {
		assertTrue(null == providerTO.provider);
	}

	@Test
	public void emptyConstructorUri() {
		assertTrue(null == providerTO.uri);
	}

	@Test
	public void ConstructorProviderProvider() {
		this.providerTO = new ProviderTO("provider");
		assertEquals("provider", providerTO.provider);
	}

	@Test
	public void ConstructorProviderUri() {
		this.providerTO = new ProviderTO("provider");
		assertEquals(null, providerTO.uri);
	}

	@Test
	public void ConstructorProvider() {
		this.providerTO = new ProviderTO("provider", "uri");
		assertTrue("provider" == providerTO.provider);
	}

	@Test
	public void ConstructorUri() {
		this.providerTO = new ProviderTO("provider", "uri");
		assertTrue("uri" == providerTO.uri);
	}

	@Test
	public void getProviderEmpty() {
		assertTrue(null == providerTO.getProvider());
	}

	@Test
	public void getProviderTest() {
		this.providerTO = new ProviderTO("provider", "uri");
		assertEquals("provider", providerTO.getProvider());
	}

	@Test
	public void getUriEmpty() {
		assertTrue(null == providerTO.getUri());
	}

	@Test
	public void getUriTest() {
		this.providerTO = new ProviderTO("provider", "uri");
		assertEquals("uri", providerTO.getUri());
	}

	@Test
	public void setProviderEmpty() {
		providerTO.setProvider(null);
		assertTrue(null == providerTO.provider);
	}

	@Test
	public void setProviderTest() {
		providerTO.setProvider("provider");
		assertEquals("provider", providerTO.provider);
	}

	@Test
	public void setUriEmpty() {
		providerTO.setUri(null);
		assertTrue(null == providerTO.uri);
	}

	@Test
	public void setUriTest() {
		providerTO.setUri("uri");
		assertEquals("uri", providerTO.uri);
	}

	@Test
	public void hashCodeEmpty() {
		assertTrue(961 == providerTO.hashCode());
	}

	@Test
	public void hashCodeTest() {
		this.providerTO = new ProviderTO("provider", "uri");
		assertTrue(-547454628 == providerTO.hashCode());
	}

	@Test
	public void equalsNull(){
		assertFalse(providerTO.equals(null));
	}

	@Test
	public void equalsSameObject(){
		assertTrue(providerTO.equals(providerTO));
	}

	@Test
	public void equalsDifferentClasses(){
		String different = new String("f");
		assertFalse(providerTO.equals(different));
	}

	@Test
	public void equalsProviderNull(){
		ProviderTO provider1 = new ProviderTO(null, null);
		ProviderTO provider2 = new ProviderTO("provider", "uri");
		assertFalse(provider1.equals(provider2));
	}

	@Test
	public void equalsUriNull(){
		ProviderTO provider1 = new ProviderTO(null, null);
		ProviderTO provider2 = new ProviderTO(null, "uri");
		assertFalse(provider1.equals(provider2));
	}

	@Test
	public void equalsNullsObjects(){
		ProviderTO provider1 = new ProviderTO(null, null);
		ProviderTO provider2 = new ProviderTO(null, null);
		assertTrue(provider2.equals(provider1));
	}

	@Test
	public void equalsDifferentProviders(){
		ProviderTO provider1 = new ProviderTO("provider0", "uri");
		ProviderTO provider2 = new ProviderTO("provider1", "uri");
		assertFalse(provider1.equals(provider2));
	}

	@Test
	public void equalsDifferentUri(){
		ProviderTO provider1 = new ProviderTO("provider", "uri0");
		ProviderTO provider2 = new ProviderTO("provider", "uri1");
		assertFalse(provider1.equals(provider2));
	}

	@Test
	public void equalsTest(){
		ProviderTO provider1 = new ProviderTO("provider", "uri");
		ProviderTO provider2 = new ProviderTO("provider", "uri");
		assertTrue(provider1.equals(provider2));
	}

	@Test
	public void toStringTest(){
		ProviderTO provider1 = new ProviderTO("provider", "uri");
		assertEquals("ProviderTO [provider=provider, uri=uri]",provider1.toString());
	}

}