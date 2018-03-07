package com.exception;


/*
There is one difference to note between try-catch-finally and try-with-resources in case of exceptions.

If an exception is thrown in both try block and finally block, 
the method returns the exception thrown in finally block.

For try-with-resources, if exception is thrown in try block and 
in try-with-resources statement, then method returns the exception thrown in try block.
*/
public class TryWithResource {

	public static void main(String[] args) throws Exception{
		try {
			tryWithResourceException();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			normalTryException();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void normalTryException() throws Exception {
		MyResource mr = null;
		try {
			mr = new MyResource();
			System.out.println("MyResource created in try block");
			if (true)
				throw new Exception("Exception in try");
		} finally {
			if (mr != null)
				mr.close();
		}
	}

	private static void tryWithResourceException() throws Exception {
		try (MyResource mr = new MyResource()) {
			System.out.println("MyResource created in try-with-resources");
			if (true)
				throw new Exception("Exception in try");
		}
	}

	static class MyResource implements AutoCloseable {
		@Override
		public void close() throws Exception {
			System.out.println("Closing MyResource");
			throw new Exception("Exception in Closing");
		}
	}
}