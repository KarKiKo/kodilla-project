package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TaskMapperTestSuite {

    private TaskMapper taskMapper = new TaskMapper();

    @Test
    public void shouldMapTaskDtoToTaskAndBack() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "Title of taskDto", "Content of TaskDto");
        Task task = new Task(1L, "Title of task", "Content of Task");
        //When
        Task taskDtoMappedToTask = taskMapper.mapToTask(taskDto);
        TaskDto taskMappedToTaskDto = taskMapper.mapToTaskDto(taskDtoMappedToTask);
        //Then
        Assert.assertEquals(taskMappedToTaskDto, taskDto);
    }

    @Test
    public void shouldMapListOfTasksToListOfTaskDtos() {
        //Given
        Task taskDto1 = new Task(1L, "Title of task1", "Content of task1");
        Task taskDto2 = new Task(2L, "Title of task2", "Content of task2");
        List<Task> listOfTasks = new ArrayList<>();
        listOfTasks.add(taskDto1);
        listOfTasks.add(taskDto2);
        //When
        List<TaskDto> mappedListOfTaskDtos = taskMapper.mapToTaskDtoList(listOfTasks);
        //Then
        Assert.assertEquals(2,mappedListOfTaskDtos.size());
        Assert.assertNotEquals(mappedListOfTaskDtos.get(1).getClass(),listOfTasks.get(1).getClass());
    }
}
