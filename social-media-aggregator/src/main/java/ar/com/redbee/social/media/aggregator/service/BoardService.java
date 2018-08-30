package ar.com.redbee.social.media.aggregator.service;

import ar.com.redbee.social.media.aggregator.exception.ServiceException;
import ar.com.redbee.social.media.aggregator.model.Board;

public interface BoardService {

  public void save(Board board) throws ServiceException;

  public Board get(Long id) throws ServiceException;

}
