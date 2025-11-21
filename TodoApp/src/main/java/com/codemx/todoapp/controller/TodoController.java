package com.codemx.todoapp.controller;

import com.codemx.todoapp.dto.ResponseDto;
import com.codemx.todoapp.dto.TodoDto;
import com.codemx.todoapp.entity.Todo;
import com.codemx.todoapp.service.TodoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
@Data
@Validated
@Tag(
        name = "CRUD Rest API for Todos  application",
        description = "CRUD Rest API forT odos application"
)
public class TodoController {

    private  TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }
    @ApiResponse(
            responseCode = "200",
            description = "Get All Todos in TodosAPP"
    )
    @GetMapping
    public ResponseEntity<List<Todo>> findAll(){
        return new ResponseEntity<>(todoService.findAll(), HttpStatus.OK);
    }

    @ApiResponse(
            responseCode = "200",
            description = "Get All Todo by id  in TodosAPP"
    )
    @GetMapping("/{id}")
    public ResponseEntity<Todo> findById(@PathVariable("id") Long id){
        return new ResponseEntity<>(todoService.findById(id), HttpStatus.OK);
    }

    @Operation(
            summary = "Create Todo rest api",
            description = "REST API to create new Todo and Account inside TodosApp"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status CREATED"
    )
    @PostMapping
    public ResponseEntity<ResponseDto> save(@Valid @RequestBody TodoDto todoDto){
        todoService.save(todoDto);
        return  ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(HttpStatus.CREATED.toString(), "The task has been deleted successfully!"));
    }

    @Operation(
            summary = "Create account rest api",
            description = "REST API to create new Customer and Account inside SBank"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status SUCCESS"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status INTERNAL SERVER ERROR",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponse.class)
                    )
            )}
    )

    @PutMapping()
    public ResponseEntity<ResponseDto> update(@Valid @RequestBody TodoDto todoDto){
        todoService
                .update(todoDto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDto(HttpStatus.OK.toString(), "The task has been deleted successfully!"));
    }

    @Operation(
            summary = "Delete todo in TodosAPP",
            description = "REST API to delete todo inside Todos App"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status SUCCESS"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteById(@PathVariable("id") Long id){
        todoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDto(HttpStatus.OK.toString(), "The task has been deleted successfully!"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> isDone(@PathVariable("id") Long id, @RequestParam boolean isDone)
    {
        todoService.isDone(id, isDone);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDto(HttpStatus.OK.toString(), "The task has been updated!"));
    }

}
