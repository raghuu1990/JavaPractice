package com.prem.array;

import java.util.*;
import java.util.concurrent.*;

interface TaskScheduler {
	void executeAllByPriority();

	void executeAllByPriorityWithUninterruptableFirst();

	void executeAllByPriorityWithThreading();
}

interface Interruptible {
}

public class X {
	public static void main(String[] args) {
		List<Task> tasks = new ArrayList<>();
		// feeding tasks
		Task task1 = new InterruptibleTask(1);
		Task task2 = new InterruptibleTask(5);
		Task task3 = new TaskImpl(10);// uninterruptible task
		tasks.add(task1);
		tasks.add(task2);
		tasks.add(task3);

		int threadCount = 2;
		TaskScheduler scheduler = new TaskSchedulerImpl(tasks, threadCount);
		scheduler.executeAllByPriority();

		System.out.println("Executing Uninterruptible first");
		scheduler.executeAllByPriorityWithUninterruptableFirst();

		System.out.println("Threading task started--");
		scheduler.executeAllByPriorityWithThreading();

	}
}

class TaskPriorityComparator implements Comparator<Task> {

	@Override
	public int compare(Task t1, Task t2) {
		return t2.getPriority() - t1.getPriority();
	}

}

class InterruptibleTaskPriorityComparator implements Comparator<Task> {

	@Override
	public int compare(Task t1, Task t2) {
		if (t1 instanceof InterruptibleTask) {
			return 1;
		} else {
			return -1;
		}

	}

}

class TaskSchedulerImpl implements TaskScheduler {
	List<Task> tasks;
	int threadCount;

	ExecutorService taskService;

	public TaskSchedulerImpl(List<Task> tasks) {
		this(tasks, 1);
	}

	public TaskSchedulerImpl(List<Task> tasks, int threadCount) {
		this.tasks = tasks;
		this.threadCount = threadCount;
		this.taskService = Executors.newFixedThreadPool(threadCount);

	}

	public void executeAllByPriority() {
		Collections.sort(tasks, new TaskPriorityComparator());
		for (Task task : tasks) {
			task.execute();
		}
	}

	public void executeAllByPriorityWithThreading() {
		Collections.sort(tasks, new TaskPriorityComparator());
		for (Task task : tasks) {
			taskService.execute(new TaskWorker(task, new Semaphore(threadCount)));
		}
		taskService.shutdown();
	}

	public void executeAllByPriorityWithUninterruptableFirst() {
		Collections.sort(tasks, new TaskPriorityComparator());
		Collections.sort(tasks, new InterruptibleTaskPriorityComparator());

		for (Task task : tasks) {
			task.execute();
		}
	}
}

interface Task {
	int getPriority();

	void execute();
}

class TaskImpl implements Task, Callable<Integer> {

	private int priority;

	public TaskImpl(int priority) {
		this.priority = priority;
	}

	public int getPriority() {
		return priority;
	}

	public void execute() {
		System.out.println("Executing Task with Priority " + priority);
	}

	public void run() {
		execute();
	}

	@Override
	public Integer call() throws Exception {
		try {
			execute();
		} catch (Exception e) {
			return 0;
		}
		return 1;
	}
}

class InterruptibleTask extends TaskImpl implements Interruptible {
	public InterruptibleTask(int priority) {
		super(priority);
	}

}

class TaskWorker implements Runnable {
	private Task task;
	private Semaphore sem;

	public TaskWorker(Task task, Semaphore sem) {
		this.task = task;
		this.sem = sem;
	}

	@Override
	public void run() {
		try {
			sem.acquire();
			System.out.println("-->Task started with priority:" + task.getPriority());
			Thread.sleep(task.getPriority() * 1000);
			task.execute();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sem.release();
		System.out.println("-X-X-Task ended with priority:" + task.getPriority());

	}
}