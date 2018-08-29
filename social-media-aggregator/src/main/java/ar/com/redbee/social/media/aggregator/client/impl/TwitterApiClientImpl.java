package ar.com.redbee.social.media.aggregator.client.impl;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import ar.com.redbee.social.media.aggregator.client.TwitterApiClient;
import ar.com.redbee.social.media.aggregator.client.config.TwitterApiConfig;

@Service
public class TwitterApiClientImpl implements TwitterApiClient {

	private static final Logger log = LoggerFactory.getLogger(TwitterApiClientImpl.class);

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private TwitterApiConfig configApi;

	@Override
	public String test() {
		final HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization: ", "OAuth");
		headers.set("oauth_version", "1.0");
		headers.set("oauth_consumer_key", configApi.getCustomerKey());
		headers.set("oauth_nonce", configApi.getCustomerSecret());
		headers.set("oauth_token", configApi.getTokenKey());
		headers.set("oauth_signature", configApi.getTokenSecret());
		headers.set("oauth_signature_method", "HMAC-SHA1");
		final LocalDateTime timestamp = LocalDateTime.now();
		final ZoneId zoneId = ZoneId.systemDefault();
		final long epoch = timestamp.atZone(zoneId).toEpochSecond();
		headers.set("oauth_timestamp", String.valueOf(epoch));
		headers.add("Content-Type", "application/x-www-form-urlencoded");
		final HttpEntity<String> entity = new HttpEntity<>(headers);
		final URI targetUrl = UriComponentsBuilder.fromHttpUrl(configApi.getUrl()).queryParam("q", "@soolcajal").build().encode().toUri();
		final ResponseEntity<String> response = restTemplate.exchange(targetUrl, HttpMethod.GET, entity, new ParameterizedTypeReference<String>() {
		});
		log.trace("Respuesta de obtenerCiudades: {}", response);
		return response.getBody();
	}

	public void setRestTemplate(final RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public void setConfigApi(final TwitterApiConfig configApi) {
		this.configApi = configApi;
	}

}
