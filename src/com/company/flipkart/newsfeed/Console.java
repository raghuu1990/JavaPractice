package com.company.flipkart.newsfeed;

import java.util.Scanner;

public class Console {
	public static void main(String[] args) throws InterruptedException {
		Scanner in = new Scanner(System.in);
		UserBase users = new UserBase();
		NewsFeeds feeds = new NewsFeeds();
		User currUser = null;
		while(in.hasNextLine()) {
			Thread.sleep(1000);
			String commandString = in.nextLine();
			String[] input = commandString.split("~");
			String command = input[0];
			if(command.equalsIgnoreCase("signup")) {
				users.signup(input[1]);
			}else if(command.equalsIgnoreCase("login")) {
				User user = users.login(input[1]);
				if(user!=null) {
					currUser = user;
					feeds.printFeeds(user);
				}
			}else if(command.equalsIgnoreCase("upvote")) {
				feeds.upvote(Integer.parseInt(input[1]));
			}else if(command.equalsIgnoreCase("downvote")) {
				feeds.downvote(Integer.parseInt(input[1]));
			}else if(command.equalsIgnoreCase("follow")) {
				users.follow(currUser, input[1]);
			}else if(command.equalsIgnoreCase("reply")) {
				feeds.reply(Integer.parseInt(input[1]), input[2], currUser);
			}else if(command.equalsIgnoreCase("post")) {
				feeds.post(input[1], currUser);
			}else if(command.equalsIgnoreCase("shownewsfeed")) {
				feeds.printFeeds(currUser);
			}
			
			System.out.println("---------------------------------------");
		}
		in.close();
	}
}