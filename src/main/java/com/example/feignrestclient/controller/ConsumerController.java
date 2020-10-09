package com.example.feignrestclient.controller;

import com.example.feignrestclient.dto.Post;
import com.example.feignrestclient.service.ConsumerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

  @Autowired
  private ConsumerService consumerService;

  //http://localhost:9111/getAllPost
  @GetMapping("/getAllPost")
  public ResponseEntity<List<Post>> getPosts(){
    final List<Post> posts = consumerService.getPosts();
    return ResponseEntity.status(HttpStatus.OK).body(posts);
  }

  //http://localhost:9111/getAllPost/15
  @GetMapping("/getAllPost/{id}")
  public ResponseEntity<Post> getPost(@PathVariable Integer id){
    final Post post = consumerService.getPost(id);
    return ResponseEntity.status(HttpStatus.OK).body(post);
  }

  //http://localhost:9111/getAllComments
  @GetMapping("/getAllComments")
  public ResponseEntity<String> getComments(){
    final String comments = consumerService.getComments();
    return ResponseEntity.status(HttpStatus.OK).body(comments);
  }

  //http://localhost:9111/get/3/comments
  @GetMapping("get/{postId}/comments")
  public ResponseEntity<String> getCommentsPostId(@PathVariable Integer postId){
    final String commentsPostId = consumerService.getCommentsPostId(postId);
    return ResponseEntity.status(HttpStatus.OK).body(commentsPostId);
  }

}
