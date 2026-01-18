package com.example.L_20_RestTemplate_Feign_demo.client;

import com.example.L_20_RestTemplate_Feign_demo.dto.BlogDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "blogs", url = "https://jsonplaceholder.typicode.com")
public interface BlogClient {

    @GetMapping("/posts/{id}")
    BlogDTO getBlogsById(@PathVariable Long id);

}
