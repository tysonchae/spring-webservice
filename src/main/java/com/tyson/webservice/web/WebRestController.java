package com.tyson.webservice.web;

import com.tyson.webservice.domain.posts.PostsRepository;
import com.tyson.webservice.dto.posts.PostsSaveRequestDto;
import com.tyson.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tyson on 2018-05-12.
 */
@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsService postsService;

    @Autowired
    private PostsRepository postsRepository;

    @GetMapping("/hello")
    public String hello(){
        return "HelloWorld";
    }

    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto){
        return postsService.save(dto);
    }
}
