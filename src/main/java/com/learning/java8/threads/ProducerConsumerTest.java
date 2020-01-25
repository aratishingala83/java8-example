package com.learning.java8.threads;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class ProducerConsumerTest {

	public static void main(String[] args) throws InterruptedException {
		Queue<Integer> integers = new ArrayBlockingQueue<Integer>(5);
		int q_size = 5;
		Object key = new Object();

		Thread producerTh = new Thread(new Producer(integers, q_size, key));
		producerTh.start();

		Thread consumerTh = new Thread(new Consumer(integers, q_size, key));
		consumerTh.start();

	}

}

class Producer implements Runnable {

	Queue<Integer> queue;
	int Q_SIZE;
	private Object key;

	public Producer(Queue<Integer> queue, int q_size, Object key) {
		this.queue = queue;
		this.Q_SIZE = q_size;
		this.key = key;
	}

	public void run() {
		while (true) {
			try {
				synchronized (key) {
					if (isFull()) {
						System.out.println("Producer Queue is Full...." + queue.size());
						key.wait();

					} else {
						System.out.println("Produce : " + queue.size());
						queue.add(queue.isEmpty() ? 0 : queue.size());
						key.notify();
					}

				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	private boolean isFull() {
		return queue.size() == Q_SIZE ? true : false;
	}

}

class Consumer implements Runnable {
	Queue<Integer> queue;
	int Q_SIZE;
	private Object key;

	public Consumer(Queue<Integer> queue, int q_size, Object key) {
		this.queue = queue;
		this.Q_SIZE = q_size;
		this.key = key;
	}

	public void run() {
		while (true) {
			try {
				synchronized (key) {
					if (isEmpty()) {
						System.out.println("COnsumer Queue is Empty...." + queue.size());
						key.wait();
					} else {
						System.out.println("Consume : " + queue.poll());
						Thread.sleep(5000L);
						key.notify();
					}

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	private boolean isEmpty() {
		return queue.isEmpty() ? true : false;
	}

}
