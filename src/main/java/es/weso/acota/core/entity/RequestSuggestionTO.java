package es.weso.acota.core.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains the related data to a single Enhancement request, as {@link ResourceTO},
 * the {@link SuggestionTO} and the List of the different {@link ProviderTO} for a
 * recommendation (Set of Enhancements).
 * 
 * @author Jose María Álvarez
 */
public class RequestSuggestionTO {

	private ResourceTO resource;
	private SuggestionTO suggestions;
	private List<ProviderTO> targetProviders;

	/**
	 * Zero-argument default constructor.
	 */
	public RequestSuggestionTO() {
		super();
		this.resource = new ResourceTO();
		this.suggestions = new SuggestionTO();
		this.targetProviders = new ArrayList<ProviderTO>();
	}

	/**
	 * One-argument default constructor.
	 * @param resource Enhancement {@link ResourceTO}
	 */
	public RequestSuggestionTO(ResourceTO resource) {
		super();
		this.resource = resource;
		this.suggestions = new SuggestionTO();
		this.targetProviders = new ArrayList<ProviderTO>();
	}
	
	/**
	 * Three-argument default constructor.
	 * @param resource Enhancement {@link ResourceTO}
	 * @param suggestions {@link SuggestionTO}'s Result
	 * @param targetProviders List of the different {@link ProviderTO}
	 */
	public RequestSuggestionTO(ResourceTO resource, SuggestionTO suggestions,
			List<ProviderTO> targetProviders) {
		super();
		this.resource = resource;
		this.suggestions = suggestions;
		this.targetProviders = targetProviders;
	}
	
	public ResourceTO getResource() {
		return resource;
	}

	public void setResource(ResourceTO resource) {
		this.resource = resource;
	}

	public List<ProviderTO> getTargetProviders() {
		return targetProviders;
	}

	public void setTargetProviders(List<ProviderTO> targetProviders) {
		this.targetProviders = targetProviders;
	}

	public void setSuggestions(SuggestionTO suggestions) {
		this.suggestions = suggestions;
	}

	public SuggestionTO getSuggestions() {
		return suggestions;
	}
	
	public void clearSuggestions(){
		this.suggestions.getTags().clear();
	}
}
