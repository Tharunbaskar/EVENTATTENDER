package com.example.eventhandler.event;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class EventService {

	private final EventRepository eventRepository;

	public EventService(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}

	public List<Event> getEvents() {
		return eventRepository.findAll();
	}

	public Optional<Event> getEvent(Long id) {
		return eventRepository.findById(id);
	}

	public Event createEvent(CreateEventRequest request) {
		Event event = new Event();
		event.setTitle(request.title());
		event.setDate(request.date());
		event.setCapacity(request.capacity());
		return eventRepository.save(event);
	}
}
