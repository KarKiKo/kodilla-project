package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TrelloMapperTestSuite {

    public TrelloMapper trelloMapper = new TrelloMapper();

    @Test
    public void testBoardMapping() {
        //Given
        TrelloCardDto trelloCardDto1 = new TrelloCardDto("Card1", "tested card", "pos1", "1");
        TrelloCardDto trelloCardDto2 = new TrelloCardDto("Card2", "tested card", "pos2", "1");
        TrelloCardDto trelloCardDto3 = new TrelloCardDto("Card3", "tested card", "pos3", "2");
        TrelloCardDto trelloCardDto4 = new TrelloCardDto("Card1", "tested card", "pos1", "3");
        TrelloListDto trelloListDto1 = new TrelloListDto("1", "List1", false);
        TrelloListDto trelloListDto2 = new TrelloListDto("2", "List2", true);
        TrelloListDto trelloListDto3 = new TrelloListDto("3", "List3", false);
        List<TrelloListDto> board1lists = new ArrayList<>();
        List<TrelloListDto> board2lists = new ArrayList<>();
        TrelloBoardDto trelloBoardDto1 = new TrelloBoardDto("Board1", "1", board1lists);
        TrelloBoardDto trelloBoardDto2 = new TrelloBoardDto("Board2", "2", board2lists);
        board1lists.add(trelloListDto1);
        board1lists.add(trelloListDto2);
        board2lists.add(trelloListDto3);
        List<TrelloBoardDto> trelloBoardDtos = new ArrayList<>();
        trelloBoardDtos.add(trelloBoardDto1);
        trelloBoardDtos.add(trelloBoardDto2);
        //When
        List<TrelloBoardDto> trelloBoardDtos2 = trelloMapper.mapToBoardsDto(trelloMapper.mapToBoards(trelloBoardDtos));
        //Then
        Assert.assertEquals(trelloBoardDtos, trelloBoardDtos2);
    }

    @Test
    public void testListMapping(){
        //Given
        TrelloCardDto trelloCardDto1 = new TrelloCardDto("Card1", "tested card", "pos1", "1");
        TrelloCardDto trelloCardDto2 = new TrelloCardDto("Card2", "tested card", "pos2", "1");
        TrelloCardDto trelloCardDto3 = new TrelloCardDto("Card3", "tested card", "pos3", "2");
        TrelloCardDto trelloCardDto4 = new TrelloCardDto("Card1", "tested card", "pos1", "3");
        TrelloListDto trelloListDto1 = new TrelloListDto("1", "List1", false);
        TrelloListDto trelloListDto2 = new TrelloListDto("2", "List2", true);
        TrelloListDto trelloListDto3 = new TrelloListDto("3", "List3", false);
        List<TrelloListDto> board1lists = new ArrayList<>();
        List<TrelloListDto> board2lists = new ArrayList<>();
        TrelloBoardDto trelloBoardDto1 = new TrelloBoardDto("Board1", "1", board1lists);
        TrelloBoardDto trelloBoardDto2 = new TrelloBoardDto("Board2","2", board2lists);
        board1lists.add(trelloListDto1);
        board1lists.add(trelloListDto2);
        board2lists.add(trelloListDto3);
        List<TrelloBoardDto> trelloBoardDtos = new ArrayList<>();
        trelloBoardDtos.add(trelloBoardDto1);
        trelloBoardDtos.add(trelloBoardDto2);
        //When
        List<TrelloListDto> board1listsTested = trelloMapper.mapToListDto(trelloMapper.mapToList(board1lists));
        //Then
        Assert.assertEquals(board1lists,board1listsTested);
    }

    @Test
    public void testCardMapping(){
        //Given
        TrelloCardDto trelloCardDto1 = new TrelloCardDto("Card1", "tested card", "pos1", "1");
        TrelloCardDto trelloCardDto2 = new TrelloCardDto("Card2", "tested card", "pos2", "1");
        TrelloCardDto trelloCardDto3 = new TrelloCardDto("Card3", "tested card", "pos3", "2");
        TrelloCardDto trelloCardDto4 = new TrelloCardDto("Card1", "tested card", "pos1", "3");
        TrelloListDto trelloListDto1 = new TrelloListDto("1", "List1", false);
        TrelloListDto trelloListDto2 = new TrelloListDto("2", "List2", true);
        TrelloListDto trelloListDto3 = new TrelloListDto("3", "List3", false);
        List<TrelloListDto> board1lists = new ArrayList<>();
        List<TrelloListDto> board2lists = new ArrayList<>();
        TrelloBoardDto trelloBoardDto1 = new TrelloBoardDto("Board1", "1", board1lists);
        TrelloBoardDto trelloBoardDto2 = new TrelloBoardDto("Board2","2", board2lists);
        board1lists.add(trelloListDto1);
        board1lists.add(trelloListDto2);
        board2lists.add(trelloListDto3);
        List<TrelloBoardDto> trelloBoardDtos = new ArrayList<>();
        trelloBoardDtos.add(trelloBoardDto1);
        trelloBoardDtos.add(trelloBoardDto2);
        //When
        TrelloCardDto trelloCardDtoTested = trelloMapper.mapToCardDto(trelloMapper.mapToCard(trelloCardDto1));
        //Then
        Assert.assertEquals(trelloCardDto1,trelloCardDtoTested);
    }
}
