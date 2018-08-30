package ar.com.redbee.social.media.aggregator.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ar.com.redbee.social.media.aggregator.model.Board;
import ar.com.redbee.social.media.aggregator.model.User;

public interface BoardDao extends CrudRepository<Board, Long> {

	public Optional<Board> findByUserAndDescription(User user, String description);

}
