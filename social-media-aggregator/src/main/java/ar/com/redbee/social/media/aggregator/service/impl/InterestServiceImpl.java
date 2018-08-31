package ar.com.redbee.social.media.aggregator.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.redbee.social.media.aggregator.dao.InterestDao;
import ar.com.redbee.social.media.aggregator.exception.ServiceException;
import ar.com.redbee.social.media.aggregator.model.Interest;
import ar.com.redbee.social.media.aggregator.service.InterestService;

@Service
public class InterestServiceImpl implements InterestService {

  @Autowired
  private InterestDao interestDao;

  @Override
  public void save(final Interest interest) throws ServiceException {
    interestDao.save(interest);
  }

  @Override
  public void delete(final Interest interest) throws ServiceException {
    interestDao.delete(interest);

  }

  @Override
  public Interest getById(final Long id) throws ServiceException {
    final Optional<Interest> optionalInterest = interestDao.findById(id);
    if (optionalInterest.isPresent()) {
      return optionalInterest.get();
    } else {
      throw new ServiceException("El interes con id " + id + " no existe.");
    }
  }

}
