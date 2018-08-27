package ar.com.redbee.social.media.aggregator.client.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ar.com.redbee.social.media.aggregator.client.TwitterApiClient;
import ar.com.redbee.social.media.aggregator.client.config.TwitterApiConfig;

@Service
public class TwitterApiClientImpl implements TwitterApiClient {

	private static final Logger log = LoggerFactory.getLogger(TwitterApiClientImpl.class);

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private TwitterApiConfig configApi;

	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	public void setRestTemplate(final RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public TwitterApiConfig getConfigApi() {
		return configApi;
	}

	public void setConfigApi(final TwitterApiConfig configApi) {
		this.configApi = configApi;
	}

}
