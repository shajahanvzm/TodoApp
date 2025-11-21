package com.codemx.todoapp.service;

import com.codemx.todoapp.dto.TodoDto;
import com.codemx.todoapp.entity.Todo;

import java.util.List;

public interface TodoService {
    public Todo findById(long id);

    public List<Todo> findAll();

    public Todo save(TodoDto todoDto);

    public Todo update(TodoDto todoDto);

    public String deleteById(long id);

    public boolean isDone(long id, boolean isDone);
}
