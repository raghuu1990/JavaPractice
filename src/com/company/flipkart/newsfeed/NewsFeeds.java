package com.company.flipkart.newsfeed;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

public class NewsFeeds {
	private static int id = 1;
	List<Post> list;
	TreeMap<Integer, Post> map;
	
	public NewsFeeds() {
		this.list = new ArrayList<Post>();
		this.map = new TreeMap<Integer, Post>();
	}

	public void printAllFeeds() {
		Collections.sort(this.list, new MyComp());
		for (Post post : this.list) {
			post.print();
		}
	}

	public void printFeeds(User user) {
		List<Post> list = getPostsForUser(user);
		Collections.sort(list, new MyComp());
		for (Post post : list) {
			post.print();
		}
	}

	private List<Post> getPostsForUser(User user) {
		List<String> followers = user.followers;
		List<Post> list1 = new ArrayList<Post>();
		List<Post> list2 = new ArrayList<Post>();
		for (String follwer : followers) {
			for(Post post : this.list) {
				if(post.userName.equalsIgnoreCase(follwer)) {
					list1.add(post);
				}
			}
		}
		for(Post post : this.list) {
			if(!list1.contains(post)) {
				list2.add(post);
			}
		}
		Collections.sort(list1, new MyComp());
		Collections.sort(list2, new MyComp());
		list1.addAll(list2);
		return list1;
	}

	public void post(String text, User user) {
		Post post = new Post(id++, text, user.name);
		list.add(post);
		map.put(post.id, post);
	}

	public void reply(Integer parentPostId, String text, User user) {
		if (map.containsKey(parentPostId)) {
			Post post = map.get(parentPostId);
			updateAllParentPost(parentPostId);
			Post comment = new Post(id++, parentPostId, text, user.name);
			map.put(comment.id, comment);
			post.comment.add(comment);
		} else {
			System.out.println("Invalid post id");
		}
	}

	private void updateAllParentPost(Integer parentPostId) {
		Post post = map.get(parentPostId);
		while(post!=null) {
			post.lastUpdateDate = new Date();
			if(post.parentPostId!=-1) {
				post = map.get(post.parentPostId);
			}else {
				post = null;
			}
		}
	}

	public void upvote(Integer id) {
		if (map.containsKey(id)) {
			map.get(id).upVote++;
		} else {
			System.out.println("Invalid post id");
		}
	}

	public void downvote(Integer id) {
		if (map.containsKey(id)) {
			map.get(id).downVote++;
		} else {
			System.out.println("Invalid post id");
		}
	}
}

class MyComp implements Comparator<Post>{
	@Override
	public int compare(Post o1, Post o2) {
		return  o2.lastUpdateDate.compareTo(o1.lastUpdateDate);
	}
}