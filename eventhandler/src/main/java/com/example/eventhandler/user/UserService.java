package com.example.eventhandler.user;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> getUsers() {
		return userRepository.findAll();
	}

	public Optional<User> getUser(Long id) {
		return userRepository.findById(id);
	}

	public User createUser(CreateUserRequest request) {
		userRepository.findByEmail(request.email())
				.ifPresent(existingUser -> {
					throw new DuplicateEmailException(request.email());
				});

		User user = new User();
		user.setName(request.name());
		user.setEmail(request.email());
		return userRepository.save(user);
	}
}
