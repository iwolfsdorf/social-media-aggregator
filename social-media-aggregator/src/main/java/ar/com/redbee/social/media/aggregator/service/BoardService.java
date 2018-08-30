package ar.com.redbee.social.media.aggregator.service;

import ar.com.redbee.social.media.aggregator.exception.ServiceException;
import ar.com.redbee.social.media.aggregator.model.Board;
import ar.com.redbee.social.media.aggregator.model.User;

public interface BoardService {

	public void save(Board board) throws ServiceException;

	public Board get(Long id) throws ServiceException;

	public Board getByUserAndDescription(User user, String description) throws ServiceException;

}
