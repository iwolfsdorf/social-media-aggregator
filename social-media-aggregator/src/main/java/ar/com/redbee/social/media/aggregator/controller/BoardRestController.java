package ar.com.redbee.social.media.aggregator.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.redbee.social.media.aggregator.model.Tweet;
import ar.com.redbee.social.media.aggregator.service.UserService;

@RestController
@RequestMapping("/boards")
public class BoardRestController {

	private static final Logger log = LoggerFactory.getLogger(BoardRestController.class);

	@Autowired
	private UserService userService;

	@ResponseBody
	@GetMapping(value = "{username}/interests", produces = "application/json")
	public List<Tweet> getInterests(@PathVariable final String username, final String board) {
		log.info("Request para obtener los intereses del usuario {}.", username);

		return null;
	}

	@ResponseBody
	@GetMapping(value = "test", produces = "application/json")
	public String test() {
		return userService.test();
	}

}
