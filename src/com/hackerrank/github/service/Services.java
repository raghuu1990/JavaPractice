package com.hackerrank.github.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;

import com.hackerrank.github.model.Actor;
import com.hackerrank.github.model.Event;
import com.hackerrank.github.model.Repo;

@Service
public class Services {
    List<Actor> listActor = new ArrayList<Actor>();
	List<Event> listEvent = new ArrayList<Event>();
	List<Repo> listRepo = new ArrayList<Repo>();
	
	HashMap<Long, Actor> mapActor = new HashMap<Long, Actor>();
	TreeMap<Long, Event> mapEvent = new TreeMap<Long, Event>();
	HashMap<Long, Repo> mapRepo = new HashMap<Long, Repo>();

	public HttpStatus updateActor(Actor actor) {
		if(mapActor.containsKey(actor.getId())) {
			Actor act = mapActor.get(actor.getId());
			if(act.getLogin().equals(actor.getLogin())) {
				act.setAvatar_url(actor.getAvatar_url());
				return HttpStatus.OK;
			}else {
				return HttpStatus.BAD_REQUEST;
			}
		}else {
			return HttpStatus.NOT_FOUND;
		}
	}
	
    public boolean addEvent(Event event) {
		if(!mapEvent.containsKey(event.getId())) {
			if(mapActor.containsKey(event.getActor().getId())) {
				event.setActor(mapActor.get(event.getActor().getId()));
			}else {
				mapActor.put(event.getActor().getId(), event.getActor());
				listActor.add(event.getActor());
			}
			//event.getActor().i++;
			//event.getActor().created_at=event.getCreated_at();
			mapEvent.put(event.getId(), event);
			return true;
		}
		return false;
	}

	public List<Event> getEvents() {
	   return new ArrayList<Event>(mapEvent.values());
	}

	public List<Event> getEventsByActor(Long id) {
		if(!mapActor.containsKey(id)) {
			return null;
		}
		List<Event> events = new ArrayList<Event>();
		for(Event event : new ArrayList<Event>(mapEvent.values())) {
			if(event.getActor().getId().equals(id)) {
				events.add(event);
			}
		}
		return events;
	}

	public List<Actor> getActors() {
		//Collections.sort(listActor);
		return listActor;
	}

	public List<Actor> getActorsStreak() {
		return new ArrayList<Actor>(mapActor.values());
	}

	public void erase() {
    	listActor = new ArrayList<Actor>();
    	listEvent = new ArrayList<Event>();
    	listRepo = new ArrayList<Repo>();
    	
        mapActor = new HashMap<Long, Actor>();
    	mapEvent = new TreeMap<Long, Event>();
    	mapRepo = new HashMap<Long, Repo>();
	}
}