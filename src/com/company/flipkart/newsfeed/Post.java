package com.company.flipkart.newsfeed;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {
	int parentPostId;
	int id;
	String userName;
	int upVote;
	int downVote;
	String text;
	Date cerationDate;
	Date lastUpdateDate;
	List<Post> comment;

	public Post(int id, String text, String userName) {
		this.parentPostId = -1;
		this.id = id;
		this.text = text;
		this.userName = userName;
		this.cerationDate = new Date();
		this.lastUpdateDate = new Date();
		this.comment = new ArrayList<Post>();
	}

	public Post(int id, int parentPostId, String text, String userName) {
		this.parentPostId = parentPostId;
		this.id = id;
		this.text = text;
		this.userName = userName;
		this.cerationDate = new Date();
		this.lastUpdateDate = new Date();
		this.comment = new ArrayList<Post>();
	}

	public void print() {
		System.out.println();
		System.out.print("id : " + this.id);
		System.out.println(" , " + (new Date().getSeconds() - this.cerationDate.getSeconds()) + " sec ago");
		System.out.print(this.userName);
		System.out.println(" (" + this.upVote + " upvote, " + this.downVote + " downvotes)");
		System.out.println(this.text);
		System.out.println(this.cerationDate);
		System.out.println();
		if (this.comment.size() > 0) {
			for (Post p : this.comment) {
				p.printComment();
			}
		}
	}

	public void printComment() {
		System.out.println();
		System.out.print("    id : " + this.id);
		System.out.println(" , " + (new Date().getSeconds() - this.cerationDate.getSeconds()) + " sec ago");
		System.out.print("    " + this.userName);
		System.out.println(" (" + this.upVote + " upvote, " + this.downVote + " downvotes)");
		System.out.println("    " + this.text);
		System.out.println("    " + this.cerationDate);
		System.out.println();
		if (this.comment.size() > 0) {
			for (Post p : this.comment) {
				p.printComment();
			}
		}
	}
}