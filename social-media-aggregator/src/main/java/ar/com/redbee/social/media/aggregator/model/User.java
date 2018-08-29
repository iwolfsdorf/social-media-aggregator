package ar.com.redbee.social.media.aggregator.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "USER", uniqueConstraints = { @UniqueConstraint(columnNames = { "username" }) })
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 15)
	private String username;

	@NotBlank
	@Size(max = 100)
	private String password;

	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "USER_ID")
	private List<Board> boards;

	public User(final String username, final String password) {
		this.username = username;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public List<Board> getBoards() {
		return boards;
	}

	public void setBoards(final List<Board> boards) {
		this.boards = boards;
	}

}
