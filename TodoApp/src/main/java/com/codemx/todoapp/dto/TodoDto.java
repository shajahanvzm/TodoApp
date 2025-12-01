package com.codemx.todoapp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(

        name = "Todos",
        description = "Schema to hold Todo information"
)
@Data
public class TodoDto {

    @Schema(
            description = "ID of the todo"
    )
   // @NotEmpty(message = "ID  can not be a nulll or empty")
    private Long id;

    @Schema(
            description = "Task name"
    )
    @NotEmpty(message = "Task name can not be a nulll or empty")
    @Size(min = 5, max = 50, message = "Task name should be between 5 and 50 characters in length.")
    private String task;

    @Schema(
            description = "Task description"
    )
    @NotEmpty(message = "Task description can not be a nulll or empty")
    @Size(min = 15, max = 255, message = "Task description should be between 15 and 255 characters in length.")
    private String description;

    private boolean done;
}
