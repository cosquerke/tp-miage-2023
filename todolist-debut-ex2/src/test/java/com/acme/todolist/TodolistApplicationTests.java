package com.acme.todolist;

import org.junit.jupiter.api.Test;

import com.acme.todolist.domain.TodoItem;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

class TodolistApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void isNotLate() {
		Instant currentTime = Instant.now();
		TodoItem todoItem = new TodoItem("1",currentTime,"test");
		String content = todoItem.finalContent();
		assert(!content.contains("[LATE!]"));
	}

	@Test
	void isLate() {
		Instant t = Instant.now().minus(1, ChronoUnit.DAYS);
		TodoItem todoItem = new TodoItem("1",t,"test");
		String content = todoItem.finalContent();
		assert(content.contains("[LATE!]"));
	}

}
