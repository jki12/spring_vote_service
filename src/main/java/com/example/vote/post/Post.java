package com.example.vote.post;

import com.example.vote.dto.PostDto;
import com.example.vote.user.User;
import lombok.Getter;
import org.springframework.lang.Nullable;

import java.time.OffsetDateTime;
import java.util.HashSet;

public class Post {
    private static final int MAX_LENGTH = 256;

    @Getter private final User user;
    @Getter private final OffsetDateTime createdTime;
    @Getter private @Nullable OffsetDateTime modifiedTime;
    @Getter private String title;
    @Getter private String description;
    private final HashSet<User> upVotes = new HashSet<>();
    private final HashSet<User> downVotes = new HashSet<>();

    // constructor, modifyPost front에서 검증한 올바른 title, description 값이 들어온다고 가정;

    public Post(PostDto postDto) {
        assert (postDto.getTitle().length() <= MAX_LENGTH && postDto.getDescription().length() <= MAX_LENGTH);

        this.createdTime = OffsetDateTime.now();

        this.user = postDto.getUser();
        this.title = postDto.getTitle();
        this.description = postDto.getDescription();
    }

    private void modifyPost(String title, String description) {
        assert (title.length() <= MAX_LENGTH && description.length() <= MAX_LENGTH);

        modifiedTime = OffsetDateTime.now();

        this.title = title;
        this.description = description;
    }

    public boolean upVote(User user) {
        if (downVotes.contains(user)) return false;

        return upVotes.add(user);
    }

    public boolean downVote(User user) {
        if (upVotes.contains(user)) return false;

        return downVotes.add(user);
    }

    public int[] getVoteResult() {
        int[] res = { upVotes.size(), downVotes.size() };

        res[0] = upVotes.size();
        res[1] = downVotes.size();

        return res;
    }
}
