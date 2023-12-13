package com.example.todobackendbutthistimeihopeitworks;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class WebSiteController {

    private final WebSiteService webSiteService;

    @GetMapping("/todo")
    public List<WebSiteToDo> getAllToDo() {
        return webSiteService.getAllToDo();
    }

    @GetMapping("/todo/{id}")
    public WebSiteToDo getToDoById(String id) {
        return webSiteService.getToDoById(id);
    }

    @PutMapping("/todo/{id}")
    public WebSiteToDo updateToDo(@PathVariable String id, @RequestBody WebSiteToDo updateToDo) {
        return webSiteService.updateToDo(id, updateToDo);
    }

    @PostMapping("/todo")
    public WebSiteToDo createToDo(@RequestBody WebSiteToDo webSiteToDo) {
        return webSiteService.saveToDo(webSiteToDo);
    }

    @DeleteMapping("/todo/{id}")
    public void deleteToDo(@PathVariable String id) {
        webSiteService.deleteToDo(id);
    }
}
