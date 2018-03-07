package com.hackerrank.github.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.github.model.Actor;
import com.hackerrank.github.model.Event;
import com.hackerrank.github.service.Services;

@RestController
public class GithubApiRestController {
	@Autowired Services service;
/*
	@RequestMapping(value = "/events", method = RequestMethod.POST)
	public ResponseEntity<Void> addEvent(@RequestBody Event event) {
		boolean status = service.addEvent(event);
		if (status) {
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/events", method = RequestMethod.GET)
	public ResponseEntity<List<Event>> getEvents() {
		List<Event> events = service.getEvents();
		if (events == null) {
			events = new ArrayList<Event>();
		}
		return new ResponseEntity<List<Event>>(events, HttpStatus.OK);
	}

	@RequestMapping(value = "/events/actors/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Event>> getEventsByActor(@PathVariable Long id) {
		List<Event> events = service.getEventsByActor(id);
		if (events == null) {
			events = new ArrayList<Event>();
			return new ResponseEntity<List<Event>>(events, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Event>>(events, HttpStatus.OK);
	}

	@RequestMapping(value = "/actors", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateActor(@RequestBody Actor actor) {
		return new ResponseEntity<Void>(service.updateActor(actor));
	}

	@RequestMapping(value = "/actors", method = RequestMethod.GET)
	public ResponseEntity<List<Actor>> getActors() {
		return new ResponseEntity(service.getActors(), HttpStatus.OK);
	}

	@RequestMapping(value = "/actors/streak", method = RequestMethod.GET)
	public ResponseEntity<List<Actor>> getActorsStreak() {
		return new ResponseEntity(service.getActorsStreak(), HttpStatus.OK);
	}

	@RequestMapping(value = "/erase", method = RequestMethod.DELETE)
	public ResponseEntity<Void> erase() {
		service.erase();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}*/
}