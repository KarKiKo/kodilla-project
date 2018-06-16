package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TrelloMapperTestSuite {

    private TrelloMapper trelloMapper = new TrelloMapper();
    private List<TrelloBoardDto> trelloBoardDtos = new ArrayList<>();
    private List<TrelloListDto> board1lists = new ArrayList<>();
    private List<TrelloListDto> board2lists = new ArrayList<>();
    private TrelloCardDto trelloCardDto1;
    private TrelloCardDto trelloCardDto2;
    private TrelloCardDto trelloCardDto3;
    private TrelloCardDto trelloCardDto4;


    @Before
    public void createTestStructure() {
        Random random = new Random();
        trelloCardDto1 = new TrelloCardDto("Card1", "tested card", "pos1", "1");
        trelloCardDto2 = new TrelloCardDto("Card2", "tested card", "pos2", "1");
        trelloCardDto3 = new TrelloCardDto("Card3", "tested card", "pos3", "2");
        trelloCardDto4 = new TrelloCardDto("Card1", "tested card", "pos1", "3");
        for(int i = 1; i <= 3; i++ ) {
            TrelloListDto list = new TrelloListDto("" + i + "", "List" + i, random.nextBoolean());
            if (i == 1 || i==2) {board1lists.add(list);} else {board2lists.add(list);}
        }
        TrelloBoardDto trelloBoardDto1 = new TrelloBoardDto("Board1", "1", board1lists);
        TrelloBoardDto trelloBoardDto2 = new TrelloBoardDto("Board2", "2", board2lists);
        trelloBoardDtos.add(trelloBoardDto1);
        trelloBoardDtos.add(trelloBoardDto2);
    }
    @Test
    public void testBoardMapping() {
        //Given
        //When
        List<TrelloBoardDto> trelloBoardDtos2 = trelloMapper.mapToBoardsDto(trelloMapper.mapToBoards(trelloBoardDtos));
        //Then
        Assert.assertEquals(trelloBoardDtos, trelloBoardDtos2);
    }

    @Test
    public void testListMapping(){
        //Given
        //When
        List<TrelloListDto> board1listsTested = trelloMapper.mapToListDto(trelloMapper.mapToList(board1lists));
        //Then
        Assert.assertEquals(board1lists,board1listsTested);
    }

    @Test
    public void testCardMapping(){
        //Given
        //When
        TrelloCardDto trelloCardDtoTested = trelloMapper.mapToCardDto(trelloMapper.mapToCard(trelloCardDto1));
        //Then
        Assert.assertEquals(trelloCardDto1,trelloCardDtoTested);
    }
}
