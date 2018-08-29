package ar.com.redbee.social.media.aggregator.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.redbee.social.media.aggregator.client.TwitterApiClient;
import ar.com.redbee.social.media.aggregator.dao.UserDao;
import ar.com.redbee.social.media.aggregator.exception.ServiceException;
import ar.com.redbee.social.media.aggregator.model.User;
import ar.com.redbee.social.media.aggregator.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private TwitterApiClient twitterApiClient;

	@Override
	public User getUser(final Long id) throws ServiceException {
		final Optional<User> userOptional = userDao.findById(id);
		if (userOptional.isPresent()) {
			return userOptional.get();
		} else {
			throw new ServiceException("No se encontro el usuario con id " + id);
		}
	}

	@Override
	public String test() {
		return twitterApiClient.test();
	}

}
