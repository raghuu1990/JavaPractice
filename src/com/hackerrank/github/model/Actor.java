package com.hackerrank.github.model;

public class Actor {//implements Comparable<Actor>{
    private Long id;
    private String login;
    private String avatar_url;
    /*public int i;
    public String created_at;
*/
    public Actor() {
    }

    public Actor(Long id, String login, String avatar_url) {
        this.id = id;
        this.login = login;
        this.avatar_url = avatar_url;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getLogin() {
        return login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    
    public String getAvatar_url() {
        return avatar_url;
    }
    
    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }
    
    @Override
    public boolean equals(Object obj) {
    	if(this.id == ((Actor) obj).id) {
    		return true;
    	}
		return false;
    }
    
   /* @Override
	public int compareTo(Actor o) {
		if(o.i!=this.i) {
			return ((Integer)o.i).compareTo(this.i);
		}
		if(o.created_at.equalsIgnoreCase(this.created_at)) {
			return (o.created_at).compareTo(this.created_at);
		}
		return this.login.compareToIgnoreCase(o.login);
	}*/
}
