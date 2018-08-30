package ar.com.redbee.social.media.aggregator.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import ar.com.redbee.social.media.aggregator.model.Board;
import ar.com.redbee.social.media.aggregator.model.Tweet;

public interface TweetDao extends PagingAndSortingRepository<Tweet, Long> {

	Page<Tweet> findByBoard(Board board, Pageable pageable);

}
