package com.example.todobackendbutthistimeihopeitworks;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class WebSiteServiceTest {

    private final WebSiteRepository webSiteRepository = mock(WebSiteRepository.class);

    @Test
    public void testGetId() {
        WebSiteToDo expected = new WebSiteToDo("1", "very cool", "toDo");
        when(webSiteRepository.findById("1")).thenReturn(Optional.of(expected));

        WebSiteService webSiteService = new WebSiteService(webSiteRepository);

        WebSiteToDo actual = webSiteService.getToDoById("1");

        verify(webSiteRepository).findById("1");
        assertEquals(expected, actual);
    }


}
