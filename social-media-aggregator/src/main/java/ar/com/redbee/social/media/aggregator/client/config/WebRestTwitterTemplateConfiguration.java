package ar.com.redbee.social.media.aggregator.client.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.twitter.api.impl.TwitterTemplate;

@Configuration
public class WebRestTwitterTemplateConfiguration {

	@Autowired
	private TwitterApiConfig configApi;

	@ConditionalOnMissingBean
	@Bean
	public TwitterTemplate twitterTemplate(final RestTemplateBuilder builder) {
		final TwitterTemplate twitterTemplate = new TwitterTemplate(configApi.getCustomerKey(), configApi.getCustomerSecret());
		return twitterTemplate;
	}

}
