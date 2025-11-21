package com.codemx.todoapp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(

        name = "Response",
        description = "Schema to hold Response information"
)
public class ResponseDto {
    @Schema(
            description = "Status Code in the response", example = "200"
    )
    private String statusCode;

    @Schema(
            description = "Status Message in the response", example = "Request processed successfully"
    )
    private String statusMessage;
}
