package ar.com.redbee.social.media.aggregator.service;

import java.util.List;

import ar.com.redbee.social.media.aggregator.exception.ServiceException;
import ar.com.redbee.social.media.aggregator.model.Board;
import ar.com.redbee.social.media.aggregator.model.Tweet;

public interface TweetService {

  List<Tweet> getPagedByBoard(Board board, Integer page, Integer size) throws ServiceException;

  void loadTweets(Board board) throws ServiceException;

  void deleteAll() throws ServiceException;

}
