package com.example.eventhandler.event;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public record CreateEventRequest(
		@NotBlank String title,
		@Future LocalDateTime date,
		@Min(1) Integer capacity
) {
}
