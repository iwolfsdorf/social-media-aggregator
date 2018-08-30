package ar.com.redbee.social.media.aggregator.service;

import java.util.List;

import ar.com.redbee.social.media.aggregator.exception.ServiceException;
import ar.com.redbee.social.media.aggregator.model.Board;
import ar.com.redbee.social.media.aggregator.model.Tweet;

public interface TweetService {

  public List<Tweet> getPagedByBoard(Board board, int offset, int limit) throws ServiceException;

}
