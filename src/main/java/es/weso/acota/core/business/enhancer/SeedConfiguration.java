package es.weso.acota.core.business.enhancer;

import java.util.List;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;

import es.weso.acota.core.Configuration;
import es.weso.acota.core.exceptions.AcotaConfigurationException;

/**
 * 
 * @author César Luis Alvargonzález
 *
 */
public class SeedConfiguration implements Configuration{

	protected static final String INTERNAL_ACOTA_SEED_PROPERTIES_PATH = "inner.acota.seed.properties";
	
	protected static Logger LOGGER;
	protected static CompositeConfiguration CONFIG;
	
	protected String[] languageProfiles;
	protected String languageProfilesPath;
	
	/**
	 * 
	 * @throws AcotaConfigurationException
	 */
	public SeedConfiguration() throws AcotaConfigurationException {
		super();
		SeedConfiguration.LOGGER = Logger.getLogger(SeedConfiguration.class);
		SeedConfiguration.CONFIG = foo(CONFIG);
	}
	
	protected CompositeConfiguration foo(CompositeConfiguration config) throws AcotaConfigurationException {
		if (config == null) {
			config = new CompositeConfiguration();
			loadsConfiguration(config);
		}
		loadLanguageDetectorConfig(config);
		return config;
	}

	public String[] getLanguageProfiles() {
		return languageProfiles;
	}
	
	public void setLanguageProfiles(String[] languageProfiles) {
		this.languageProfiles = languageProfiles;
	}

	public String getLanguageProfilesPath() {
		return languageProfilesPath;
	}

	public void setLanguageProfilesPath(String languageProfilesPath) {
		this.languageProfilesPath = languageProfilesPath;
	}
	
	@Override
	public final void loadsConfiguration(CompositeConfiguration configuration) throws AcotaConfigurationException {
		if(CONFIG==null){
			try {
				configuration.addConfiguration(new PropertiesConfiguration(
						"acota.properties"));
			} catch (Exception e) {
				LOGGER.warn("acota.properties not found, Using default values.");
			}
			
			try {
				configuration.addConfiguration(new PropertiesConfiguration(this.getClass().getClassLoader()
						.getResource(INTERNAL_ACOTA_SEED_PROPERTIES_PATH)));
			} catch (ConfigurationException e) {
				throw new AcotaConfigurationException(e);
			}
		}else{
			configuration.append(CONFIG);
			if(!configuration.equals(CONFIG))
				loadCustomConfiguration(configuration);
		}
		/*
		System.out.println(CONFIG);
		System.out.println(configuration);
		
		if(CONFIG != null && !configuration.equals(CONFIG))
			loadCustomConfiguration(configuration);*/
		
	}

	/**
	 * 
	 * @throws AcotaConfigurationException
	 */
	protected void loadCustomConfiguration(CompositeConfiguration config)  throws AcotaConfigurationException{}

	/**
	 * Loads Language Detection Files Configuration
	 */
	private void loadLanguageDetectorConfig(CompositeConfiguration config) {
		this.setLanguageProfilesPath(config.getString("language.profiles.path"));
		List<?> profiles = config.getList("language.profiles");
		this.setLanguageProfiles(profiles.toArray(new String[profiles.size()]));
	}
	
	
}
