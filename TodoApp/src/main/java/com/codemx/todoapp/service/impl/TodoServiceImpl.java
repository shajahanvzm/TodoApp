package com.codemx.todoapp.service.impl;

import com.codemx.todoapp.dto.TodoDto;
import com.codemx.todoapp.entity.Todo;
import com.codemx.todoapp.mapper.TodosMapper;
import com.codemx.todoapp.repository.TodoRepository;
import com.codemx.todoapp.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service


@Slf4j
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public Todo findById(long id) {
        return todoRepository.findById(id).orElseThrow(() -> new RuntimeException(id + "is not found!"));
    }

    @Override
    public List<Todo> findAll() {

        return todoRepository.findAll();
    }

    @Override
    public Todo save(TodoDto todoDto) {
        Todo todo = TodosMapper.mapToTodo(todoDto, new Todo());
        return todoRepository.save(todo);
    }

    @Override
    public Todo update(TodoDto todoDto) {
        if (todoDto.getId() == null)
            throw new RuntimeException("Todo ID is required for this request!");
        todoRepository.findById(todoDto.getId()).orElseThrow(() -> new RuntimeException(todoDto.getId() + " is not found!"));
        Todo todo = TodosMapper.mapToTodo(todoDto, new Todo());
        return todoRepository.save(todo);
    }

    @Override
    public String deleteById(long id) {
        todoRepository.findById(id).orElseThrow(() -> new RuntimeException(id + " is not found!"));
        todoRepository.deleteById(id);
        return id + "is deleted!!";
    }

    public boolean isDone(long id, boolean isDone) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new RuntimeException(id + "is not found!"));
        todo.setDone(isDone);
        todoRepository.save(todo);
        return todoRepository.findById(id).isPresent();
    }
}
