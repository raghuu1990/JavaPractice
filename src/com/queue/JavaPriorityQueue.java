package com.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class JavaPriorityQueue {
	private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}


class Student implements Comparable<Student>{
	Integer id;
	String name;
	Double cgpa;
	Student(int id, String name, double cgpa){
		this.id = id;
		this.name= name;
		this.cgpa = cgpa;
	}
	public String getName() {
		return name;
	}

	@Override
	public int compareTo(Student s) {
		if(!s.cgpa.equals(this.cgpa)) {
			return s.cgpa.compareTo(this.cgpa);
		}else if (!s.name.equals(this.name)) {
			return this.name.compareTo(s.name);
		}
		return s.id.compareTo(this.id);
	}
}

class Priorities{
	PriorityQueue<Student> q;
	
	Priorities(){
		q = new PriorityQueue<Student>();
	}
	public List<Student> getStudents(List<String> events) {
		for(String event : events) {
			String[] arr = event.split(" ");
			if(arr[0].equalsIgnoreCase("ENTER")) {
				q.add(new Student(Integer.parseInt(arr[3]), arr[1], Double.parseDouble(arr[2])));
			}else {
				q.poll();
			}
		}
		List<Student> list = new ArrayList<Student>();
		while(!q.isEmpty()) {
			list.add(q.poll());
		}
		return list;
	}
}