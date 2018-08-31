package ar.com.redbee.social.media.aggregator.client;

import java.util.List;

import ar.com.redbee.social.media.aggregator.model.Tweet;

public interface TwitterApiClient {

  public List<Tweet> search(String query);

}
