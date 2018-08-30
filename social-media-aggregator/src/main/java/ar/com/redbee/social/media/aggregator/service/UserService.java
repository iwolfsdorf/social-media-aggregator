package ar.com.redbee.social.media.aggregator.service;

import ar.com.redbee.social.media.aggregator.exception.ServiceException;
import ar.com.redbee.social.media.aggregator.model.User;

public interface UserService {

	User getUser(Long id) throws ServiceException;

	String search(String query);

	User getUserByUsername(String username) throws ServiceException;

}
