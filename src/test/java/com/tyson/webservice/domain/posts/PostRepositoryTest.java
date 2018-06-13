package com.tyson.webservice.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by oolong on 2018-05-12.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup(){
        /**
        이후 테스트 코드에 영향을 끼치지 않기 위해 테스트 메소드가 끝날때마다
         repository 전체 비우는 코드
         **/
        postsRepository.deleteAll();
    }

    @Test
    public void retrievePosts(){
        //given
        postsRepository.save(Posts.builder()
                .title("test posts")
                .content("test body")
                .author("tysonchae@gmail.com")
                .build());
        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle(), is("test posts"));
        assertThat(posts.getContent(), is("test body"));
    }

    @Test
    public void BaseTimeEntitySave(){
        //given
        LocalDateTime now = LocalDateTime.now();
        postsRepository.save(Posts.builder()
            .title("test post")
            .content("test body")
            .author("tysonchae@gmail.com")
            .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertTrue(posts.getCreatedDate().isAfter(now));
        assertTrue(posts.getModifiedDate().isAfter(now));
    }
}
