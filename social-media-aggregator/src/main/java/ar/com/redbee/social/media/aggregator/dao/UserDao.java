package ar.com.redbee.social.media.aggregator.dao;

import org.springframework.data.repository.CrudRepository;

import ar.com.redbee.social.media.aggregator.model.User;

public interface UserDao extends CrudRepository<User, Long> {

  User findByUsername(String username);

}
