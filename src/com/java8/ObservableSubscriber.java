package com.java8;
/*
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;*/

public class ObservableSubscriber  {
/*
	public static Observable<String> myObservable = Observable.create(
		new Observable.OnSubscribe<String>() {
			@Override
			public void call(Subscriber<? super String> sub) {
				System.out.println("in obserable call ");
				sub.onNext("Hello, world!");
				//sub.onError(null);
				//sub.onCompleted();
			}
		}			
	);*/
	/*
	public static Observable<String> myObservable =
		    Observable.just("Hello, world!");

	public static Subscriber<String> mySubscriber = new Subscriber<String>() {
		
		public void call(String s) {
			System.out.println("onNextAction : "+s);
			
			onNext("Hello, world!");
			onError(null);
			onCompleted();
			
		}
		
		@Override
		public void onNext(String s) { 
			System.out.println("on Next  : "+s); 
		}

		@Override
		public void onCompleted() { 
			System.out.println("on Completed");
		}

		@Override
		public void onError(Throwable e) { 
			System.out.println("on Error");
		}
	};

	public static void main(String[] args) {
		//myObservable.subscribe(mySubscriber);
		myObservable.subscribe(onNextAction);
		myObservable.subscribe(onErrorAction);
		myObservable.subscribe(onCompleteAction);
		
		Observable.just("Hello, world!")
	    .subscribe(s -> System.out.println(s + " -Dan"));

		Observable.just("Hello, world!")
	    .map(s -> s.hashCode())
	    .subscribe(i -> System.out.println(Integer.toString(i)));

		Observable.from("url1", "url2", "url3")
	    .subscribe(url -> System.out.println(url));

		
		//myObservable.subscribe(onNextAction, onErrorAction, onCompleteAction);
	}

	static Action1<String> onNextAction = new Action1<String>() {
		@Override
		public void call(String s) {
			System.out.println("onNextAction : "+s);
			
			onNext("Hello, world!");
			onError(null);
			onCompleted();
			
		}

		public void onNext(String s) { 
			System.out.println("on Next  : "+s); 
		}

		public void onCompleted() { 
			System.out.println("on Completed");
		}

		public void onError(Throwable e) { 
			System.out.println("on Error");
		}
	};
	
	static Action1<String> onErrorAction = new Action1<String>() {
		@Override
		public void call(String s) {
			System.out.println("onErrorAction : "+s);
		}
	};
	
	static Action1<String> onCompleteAction = new Action1<String>() {
		@Override
		public void call(String s) {
			System.out.println("onCompleteAction : "+s);
		}
	};
*/
}
