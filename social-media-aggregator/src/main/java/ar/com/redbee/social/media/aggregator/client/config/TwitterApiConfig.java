package ar.com.redbee.social.media.aggregator.client.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("twitter.api")
public class TwitterApiConfig {

	private String url;
	private String customerKey;
	private String customerSecret;

	public String getUrl() {
		return url;
	}

	public void setUrl(final String url) {
		this.url = url;
	}

	public String getCustomerKey() {
		return customerKey;
	}

	public void setCustomerKey(final String customerKey) {
		this.customerKey = customerKey;
	}

	public String getCustomerSecret() {
		return customerSecret;
	}

	public void setCustomerSecret(final String customerSecret) {
		this.customerSecret = customerSecret;
	}

}
