package com.example.L_20_RestTemplate_Feign_demo;

import com.example.L_20_RestTemplate_Feign_demo.client.BlogClient;
import com.example.L_20_RestTemplate_Feign_demo.dto.BlogDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private BlogClient blogClient;

//    @GetMapping("/{id}")
//    public ResponseEntity<JsonNode> getBlog(@PathVariable Long id){
//        String url = "https://jsonplaceholder.typicode.com/posts/"+id;
//        JsonNode jsonNode = restTemplate.getForObject(url, JsonNode.class);
//        return ResponseEntity.ok(jsonNode);
//    }

//    @GetMapping("/{id}")
//    public ResponseEntity<BlogDTO> getBlog(@PathVariable Long id){
//        String url = "https://jsonplaceholder.typicode.com/posts/"+id;
//        // check cache
//        // return from cache.
//        BlogDTO blogDto = restTemplate.getForObject(url,BlogDTO.class);
//        blogDto.setServerDateTime(new Date());
//        // set this in cache.
//        return ResponseEntity.ok(blogDto);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogDTO> getBlog(@PathVariable Long id){
        BlogDTO blogDto = blogClient.getBlogsById(id);
        blogDto.setServerDateTime(new Date());
        return ResponseEntity.ok(blogDto);
    }
}
