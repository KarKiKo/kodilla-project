package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TrelloValidatorTest {

//    @Mock
//    private TrelloValidator trelloValidator;
//    jesli bedzie Mockiem Validator nie zadziala poprawnie

    @Test
    public void shouldValidateTrelloBoards(){
        //Given
        TrelloValidator trelloValidator = new TrelloValidator();
        List<TrelloList> listOfTrelloLists = new ArrayList<>();
        TrelloList trelloList = new TrelloList("1", "TrelloList", false);
        listOfTrelloLists.add(trelloList);
        List<TrelloBoard> listOfTrelloBoards = new ArrayList<>();
        TrelloBoard trelloBoard = new TrelloBoard("TrelloBoards", "1", listOfTrelloLists);
        TrelloBoard trelloBoard1 = new TrelloBoard("test", "2", listOfTrelloLists);
        listOfTrelloBoards.add(trelloBoard);
        listOfTrelloBoards.add(trelloBoard1);
        //When
        List<TrelloBoard> validatedBoardLists = trelloValidator.validateTrelloBoards(listOfTrelloBoards);
        //Then
        Assert.assertNotNull(validatedBoardLists);
        Assert.assertEquals(1, validatedBoardLists.size());
    }
}
