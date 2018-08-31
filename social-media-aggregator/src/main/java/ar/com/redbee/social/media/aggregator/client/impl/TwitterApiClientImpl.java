package ar.com.redbee.social.media.aggregator.client.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.SearchParameters;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.stereotype.Service;

import ar.com.redbee.social.media.aggregator.client.TwitterApiClient;
import ar.com.redbee.social.media.aggregator.model.Tweet;

@Service
public class TwitterApiClientImpl implements TwitterApiClient {

  private static final Logger log = LoggerFactory.getLogger(TwitterApiClientImpl.class);

  @Autowired
  private TwitterTemplate twitterTemplate;

  @Override
  public List<Tweet> search(final String query) {
    log.info("Se realiza consulta de twitters con la query {}.", query);
    final SearchParameters searchP = new SearchParameters(query);
    final SearchResults search = twitterTemplate.searchOperations().search(searchP);
    return search.getTweets().stream().map(t -> Tweet.toTweet(t)).collect(Collectors.toList());
  }

}
