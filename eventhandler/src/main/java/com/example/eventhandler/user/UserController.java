package com.example.eventhandler.user;

import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public List<User> getUsers() {
		return userService.getUsers();
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable Long id) {
		return userService.getUser(id)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<User> createUser(@Valid @RequestBody CreateUserRequest request) {
		User createdUser = userService.createUser(request);
		return ResponseEntity
				.created(URI.create("/api/users/" + createdUser.getId()))
				.body(createdUser);
	}

	@ExceptionHandler(DuplicateEmailException.class)
	public ResponseEntity<String> handleDuplicateEmail(DuplicateEmailException exception) {
		return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
	}
}
