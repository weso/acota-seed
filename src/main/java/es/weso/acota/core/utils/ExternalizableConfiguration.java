package es.weso.acota.core.utils;

import org.apache.commons.configuration.PropertiesConfiguration;

/**
 * @author César Luis Alvargonzález
 *
 */
public interface ExternalizableConfiguration {
	
	/**
	 * Retrieves the external Object Configuration
	 * @return External properties configuration
	 */
	PropertiesConfiguration getConfiguration();
}
