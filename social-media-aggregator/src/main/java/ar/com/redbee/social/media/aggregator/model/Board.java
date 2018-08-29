package ar.com.redbee.social.media.aggregator.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BOARD")
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String interest;
	
	@ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "USER_ID")
	private User user;

	public String getInterest() {
		return interest;
	}

	public void setInterest(final String interest) {
		this.interest = interest;
	}

}
