package com.example.vote;

import com.example.vote.dto.UserDto;
import com.example.vote.model.Post;
import com.example.vote.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VoteApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void voteTest() {
		User u1 = new User(new UserDto("hello", "pw", "james"));
		User u2 = new User(new UserDto("hey", "pw", "peter"));

		Post a = new Post(u1, "a", "none");

		a.upVote(u1);
		a.upVote(u1);

		var res = a.getVoteResult();

		assertEquals(res[0], 1);
		assertEquals(res[1], 0);

		a.upVote(u2);
		a.downVote(u2);

		res = a.getVoteResult();

		assertEquals(res[0], 2);
		assertEquals(res[1], 0);
	}

}
