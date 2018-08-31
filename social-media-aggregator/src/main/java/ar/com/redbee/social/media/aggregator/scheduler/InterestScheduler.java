package ar.com.redbee.social.media.aggregator.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import ar.com.redbee.social.media.aggregator.exception.ServiceException;
import ar.com.redbee.social.media.aggregator.model.Board;
import ar.com.redbee.social.media.aggregator.service.BoardService;
import ar.com.redbee.social.media.aggregator.service.TweetService;

@Component
public class InterestScheduler {

  private static final Logger log = LoggerFactory.getLogger(InterestScheduler.class);

  @Autowired
  private TweetService tweetService;

  @Autowired
  private BoardService boardService;

  @Scheduled(cron = "0 0 * ? * *")

  public void loadTweets() {
    log.info("Se cargan los tweets en la BD.");
    try {
      tweetService.deleteAll();
      for (final Board board : boardService.getAll()) {
        tweetService.loadTweets(board);
      }
    } catch (final ServiceException e) {
      log.error("Se produjo un error al intentar cargar los nuevos tweets.");
    }
  }
}
