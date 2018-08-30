package ar.com.redbee.social.media.aggregator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import ar.com.redbee.social.media.aggregator.dao.TweetDao;
import ar.com.redbee.social.media.aggregator.exception.ServiceException;
import ar.com.redbee.social.media.aggregator.model.Board;
import ar.com.redbee.social.media.aggregator.model.Tweet;
import ar.com.redbee.social.media.aggregator.service.TweetService;

@Service
public class TweetServiceImpl implements TweetService {

  @Autowired
  private TweetDao tweetDao;

  @Override
  public List<Tweet> getPagedByBoard(final Board board, final int offset, final int limit) throws ServiceException {
  	Pageable pageable = PageRequest.of(offset, limit);
		return tweetDao.findAll(pageable).getContent();
  }

}
