package ar.com.redbee.social.media.aggregator.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import ar.com.redbee.social.media.aggregator.exception.ServiceException;
import ar.com.redbee.social.media.aggregator.exception.ws.InternalServerErrorException;
import ar.com.redbee.social.media.aggregator.model.Board;
import ar.com.redbee.social.media.aggregator.model.Interest;
import ar.com.redbee.social.media.aggregator.model.Tweet;
import ar.com.redbee.social.media.aggregator.service.BoardService;
import ar.com.redbee.social.media.aggregator.service.TweetService;

@RestController
@RequestMapping("/boards")
public class BoardRestController {

  private static final Logger log = LoggerFactory.getLogger(BoardRestController.class);

  @Autowired
  private BoardService boardService;

  @Autowired
  private TweetService tweetService;

  @ResponseBody
  @GetMapping(value = "{username}/interests", produces = "application/json")
  public List<Tweet> getInterests(@PathVariable final String username, final Long boardId, final Integer offset, final Integer limit) {
    log.info("Request para obtener los intereses del usuario {}.", username);
    try {
      final Board board = boardService.get(boardId);
      return tweetService.getPagedByBoard(board, offset, limit);
    } catch (final ServiceException e) {
      throw new InternalServerErrorException(e.getMessage());
    }
  }

  @ResponseBody
  @PostMapping(value = "{username}/interest", produces = "application/json")
  public Boolean addInterest(final Long boardId, final String interest) {
    try {
      final Board board = boardService.get(boardId);
      board.getInterests().add(new Interest(interest));
      boardService.save(board);
      return Boolean.TRUE;
    } catch (final ServiceException e) {
      throw new InternalServerErrorException(e.getMessage());
    }
  }

  @ResponseBody
  @DeleteMapping(value = "{username}/interest", produces = "application/json")
  public Boolean deleteInterest(final Long boardId, final Long interestId) {
    try {
      final Board board = boardService.get(boardId);
      final List<Interest> interests = board.getInterests().stream().filter(i -> i.getId() != interestId).collect(Collectors.toList());
      board.setInterests(interests);
      boardService.save(board);
      return Boolean.TRUE;
    } catch (final ServiceException e) {
      throw new InternalServerErrorException(e.getMessage());
    }
  }

}
