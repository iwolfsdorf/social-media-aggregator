package ar.com.redbee.social.media.aggregator.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ar.com.redbee.social.media.aggregator.client.TwitterApiClient;
import ar.com.redbee.social.media.aggregator.dao.TweetDao;
import ar.com.redbee.social.media.aggregator.exception.ServiceException;
import ar.com.redbee.social.media.aggregator.model.Board;
import ar.com.redbee.social.media.aggregator.model.Tweet;
import ar.com.redbee.social.media.aggregator.service.TweetService;

@Service
public class TweetServiceImpl implements TweetService {

  @Autowired
  private TwitterApiClient twitterApiClient;

  @Autowired
  private TweetDao tweetDao;

  @Override
  public List<Tweet> getPagedByBoard(final Board board, final Integer page, final Integer size) throws ServiceException {
    final Pageable pageable = PageRequest.of(page, size);
    return tweetDao.findAll(pageable).getContent();
  }

  @Override
  public void loadTweets(final Board board) throws ServiceException {
    final String query = board.getInterests().stream().map(i -> i.getDescription()).collect(Collectors.joining(" OR "));
    final List<Tweet> tweets = twitterApiClient.search(query);
    tweets.stream().forEach(t -> t.setBoard(board));
    tweetDao.saveAll(tweets);
  }

  @Override
  public void deleteAll() throws ServiceException {
    tweetDao.deleteAll();
  }

}
