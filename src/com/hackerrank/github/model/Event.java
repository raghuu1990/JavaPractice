package com.hackerrank.github.model;


public class Event {
    private Long id;
    private String type;
    private Actor actor;
    private Repo repo;
    private String created_at;

    public Event() {
    }

    public Event(Long id, String type, Actor actor, Repo repo, String created_at) {
        this.id = id;
        this.type = type;
        this.actor = actor;
        this.repo = repo;
        this.created_at = created_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Repo getRepo() {
        return repo;
    }

    public void setRepo(Repo repo) {
        this.repo = repo;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
    
    @Override
    public boolean equals(Object obj) {
    	if(this.id == ((Event) obj).id) {
    		return true;
    	}
		return false;
    }
}
