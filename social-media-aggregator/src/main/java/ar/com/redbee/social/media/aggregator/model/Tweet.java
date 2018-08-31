package ar.com.redbee.social.media.aggregator.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Entity
@Table(name = "TWEET")
public class Tweet {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String fromUser;

  private String text;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "BOARD_ID")
  private Board board;

  public Tweet() {
  }

  public Tweet(final String fromUser, final String text) {
    this.fromUser = fromUser;
    this.text = text;
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }

  public void setText(final String text) {
    this.text = text;
  }

  public String getFromUser() {
    return fromUser;
  }

  public void setFromUser(final String fromUser) {
    this.fromUser = fromUser;
  }

  public Board getBoard() {
    return board;
  }

  public void setBoard(final Board board) {
    this.board = board;
  }

  public static Tweet toTweet(final org.springframework.social.twitter.api.Tweet tweet) {
    return new Tweet(tweet.getFromUser(), tweet.getText());
  }

  @Override
  public String toString() {
    final ObjectMapper mapper = new ObjectMapper();
    try {
      return mapper.writeValueAsString(this);
    } catch (final JsonProcessingException e) {
      return "";
    }
  }

}
