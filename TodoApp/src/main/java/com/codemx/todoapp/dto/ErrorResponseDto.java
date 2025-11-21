package com.codemx.todoapp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Schema(

        name = "Error Response",
        description = "Schema to hold Error Response information"
)
public class ErrorResponseDto {

    @Schema(
            description = "Api path  invoked bby client "
    )
    private String apiPath;

    @Schema(
            description = "Error Code in the response"
    )
    private HttpStatus errorCode;
    @Schema(
            description = "Error Message in the response"
    )
    private String errorMessage;
    @Schema(
            description = "Error Time in the response"
    )
    private LocalDateTime errorTime;
}
