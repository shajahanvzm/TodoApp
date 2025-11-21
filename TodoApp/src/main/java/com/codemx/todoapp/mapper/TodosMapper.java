package com.codemx.todoapp.mapper;

import com.codemx.todoapp.dto.TodoDto;
import com.codemx.todoapp.entity.Todo;

public class TodosMapper {

    public static Todo mapToTodo(TodoDto todoDto, Todo todo) {
        if (todoDto != null) {
            todo.setId(todoDto.getId());
        }
        todo.setTask(todoDto.getTask());
        todo.setDescription(todoDto.getDescription());
        todo.setDone(todoDto.isDone());
        return todo;
    }

    public static TodoDto mapToTodoDto(Todo todo, TodoDto todoDto) {
        if (todo != null) {
            todoDto.setId(todo.getId());
        }
        todoDto.setTask(todo.getTask());
        todoDto.setDescription(todo.getDescription());
        todoDto.setDone(todo.isDone());
        return todoDto;
    }
}
