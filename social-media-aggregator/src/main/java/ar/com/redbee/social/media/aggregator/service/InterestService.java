package ar.com.redbee.social.media.aggregator.service;

import ar.com.redbee.social.media.aggregator.exception.ServiceException;
import ar.com.redbee.social.media.aggregator.model.Interest;

public interface InterestService {

  void save(Interest interest) throws ServiceException;

  void delete(Interest interest) throws ServiceException;

  Interest getById(Long id) throws ServiceException;

}
