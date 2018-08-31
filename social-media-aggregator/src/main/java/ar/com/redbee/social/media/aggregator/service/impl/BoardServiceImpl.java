package ar.com.redbee.social.media.aggregator.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.redbee.social.media.aggregator.dao.BoardDao;
import ar.com.redbee.social.media.aggregator.exception.ServiceException;
import ar.com.redbee.social.media.aggregator.model.Board;
import ar.com.redbee.social.media.aggregator.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {

  @Autowired
  private BoardDao boardDao;

  @Override
  public void save(final Board board) throws ServiceException {
    boardDao.save(board);
  }

  @Override
  public Board get(final Long id) throws ServiceException {
    final Optional<Board> optionalBoard = boardDao.findById(id);
    if (optionalBoard.isPresent()) {
      return optionalBoard.get();
    } else {
      throw new ServiceException("No existe el board con id " + id);
    }
  }

  @Override
  public List<Board> getAll() throws ServiceException {
    final List<Board> boards = new ArrayList<>();
    for (final Board board : boardDao.findAll()) {
      boards.add(board);
    }
    return boards;
  }

}
