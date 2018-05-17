package com.crud.tasks.controller;

import com.crud.tasks.domain.CreatedTrelloCard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/trello")
public class TrelloController {

    @Autowired
    private TrelloClient trelloClient;

    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
    public List<TrelloBoardDto> getTrelloBoards() {

        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();

        trelloBoards.stream()
                .filter(t -> t.getId()!= null & t.getName()!= null)
                .filter(t -> t.getName().contains("Kodilla"))
                .forEach(trelloBoardDto -> {
                        System.out.println(trelloBoardDto.getId() + " " + trelloBoardDto.getName());
                        System.out.println("\nThis board contains lists: ");
                        trelloBoardDto.getLists().forEach(trelloList ->
                        System.out.println(trelloList.getName() + " - " + trelloList.getId() + " - " + trelloList.isClosed()));
                });

        return trelloBoards;
    }

    @RequestMapping(method = RequestMethod.POST, value = "createTrelloCard")
    public CreatedTrelloCard createdTrelloCard(@RequestBody TrelloCardDto trelloCardDto){
        return trelloClient.createNewCard(trelloCardDto);
    }
}