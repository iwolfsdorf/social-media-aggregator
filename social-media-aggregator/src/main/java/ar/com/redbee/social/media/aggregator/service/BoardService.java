package ar.com.redbee.social.media.aggregator.service;

import java.util.List;

import ar.com.redbee.social.media.aggregator.exception.ServiceException;
import ar.com.redbee.social.media.aggregator.model.Board;

public interface BoardService {

  public void save(Board board) throws ServiceException;

  public Board get(Long id) throws ServiceException;

  public List<Board> getAll() throws ServiceException;

}
