package com.example.feignrestclient.service;

import com.example.feignrestclient.dto.Post;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://jsonplaceholder.typicode.com/", name = "proxyClient")
public interface ConsumerService {

  @GetMapping("/posts")
  public List<Post> getPosts();

  @GetMapping("/posts/{id}")
  public Post getPost(@PathVariable Integer id);

  @GetMapping("/comments")
  public String getComments();

  @GetMapping("posts/{postId}/comments")
  public String getCommentsPostId(@PathVariable Integer postId);
}
