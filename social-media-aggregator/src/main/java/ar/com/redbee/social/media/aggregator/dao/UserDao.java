package ar.com.redbee.social.media.aggregator.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ar.com.redbee.social.media.aggregator.model.User;

public interface UserDao extends CrudRepository<User, Long> {

	Optional<User> findByUsername(String username);

}
