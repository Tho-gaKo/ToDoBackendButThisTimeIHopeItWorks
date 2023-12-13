package com.example.todobackendbutthistimeihopeitworks;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@Service
public class WebSiteService {

    private final WebSiteRepository webSiteRepository;

    public WebSiteService(WebSiteRepository webSiteRepository) {
        this.webSiteRepository = webSiteRepository;
    }

    public List<WebSiteToDo> getAllToDo() {
        return webSiteRepository.findAll();
    }
    public WebSiteToDo getToDoById(String id) {
        return webSiteRepository.findById(id).orElse(null);
    }

    public WebSiteToDo updateToDo(String id, WebSiteToDo updateToDo) {
        WebSiteToDo toDoUpdate = getToDoById(id);

        if (toDoUpdate == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if (!Objects.equals(id, updateToDo.id())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return  webSiteRepository.save(updateToDo);
    }

    public WebSiteToDo saveToDo(WebSiteToDo webSiteToDo) {
        webSiteRepository.save(webSiteToDo);
        return webSiteToDo;
    }

    public void deleteToDo(String id) {
        webSiteRepository.deleteById(id);
    }
}
