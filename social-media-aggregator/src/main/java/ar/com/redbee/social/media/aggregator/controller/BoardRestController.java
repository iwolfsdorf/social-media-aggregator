package ar.com.redbee.social.media.aggregator.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.redbee.social.media.aggregator.exception.ServiceException;
import ar.com.redbee.social.media.aggregator.exception.ws.InternalServerErrorException;
import ar.com.redbee.social.media.aggregator.model.Board;
import ar.com.redbee.social.media.aggregator.model.Interest;
import ar.com.redbee.social.media.aggregator.model.Tweet;
import ar.com.redbee.social.media.aggregator.service.BoardService;
import ar.com.redbee.social.media.aggregator.service.InterestService;
import ar.com.redbee.social.media.aggregator.service.TweetService;

@RestController
@RequestMapping("/boards")
public class BoardRestController {

  private static final Logger log = LoggerFactory.getLogger(BoardRestController.class);

  @Autowired
  private BoardService boardService;

  @Autowired
  private TweetService tweetService;

  @Autowired
  private InterestService interestService;

  @ResponseBody
  @GetMapping(value = "{username}/interests", produces = "application/json")
  public List<Tweet> getInterests(@PathVariable final String username, @RequestParam(required = true) final Long boardId, @RequestParam(required = true) final Integer page,
      @RequestParam(required = true) final Integer size) {
    log.info("Request para obtener los intereses del usuario {}.", username);
    try {
      final Board board = boardService.get(boardId);
      return tweetService.getPagedByBoard(board, page, size);
    } catch (final ServiceException e) {
      throw new InternalServerErrorException(e.getMessage());
    }
  }

  @ResponseBody
  @PostMapping(value = "{username}/interest", produces = "application/json")
  public Boolean addInterest(@RequestParam(required = true) final Long boardId, @RequestParam(required = true) final String interestDesc) {
    try {
      final Board board = boardService.get(boardId);
      final Interest interest = new Interest(interestDesc, board);
      interestService.save(interest);
      return Boolean.TRUE;
    } catch (final ServiceException e) {
      throw new InternalServerErrorException(e.getMessage());
    }
  }

  @ResponseBody
  @DeleteMapping(value = "{username}/interest", produces = "application/json")
  public Boolean deleteInterest(@RequestParam(required = true) final Long interestId) {
    try {
      Interest interest = interestService.getById(interestId);
      interestService.delete(interest);
      return Boolean.TRUE;
    } catch (final ServiceException e) {
      throw new InternalServerErrorException(e.getMessage());
    }
  }

}
