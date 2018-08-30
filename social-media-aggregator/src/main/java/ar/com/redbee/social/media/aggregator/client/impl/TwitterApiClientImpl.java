package ar.com.redbee.social.media.aggregator.client.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.SearchParameters;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.stereotype.Service;

import ar.com.redbee.social.media.aggregator.client.TwitterApiClient;

@Service
public class TwitterApiClientImpl implements TwitterApiClient {

	private static final Logger log = LoggerFactory.getLogger(TwitterApiClientImpl.class);

	@Autowired
	private TwitterTemplate twitterTemplate;

	@Override
	public String search(final String query) {
		log.info("Se realiza consulta de twitters con la query {}.", query);
		SearchParameters searchP = new SearchParameters(query);
		final SearchResults search = twitterTemplate.searchOperations().search(searchP);
		return search.getTweets().toString();
	}

}
