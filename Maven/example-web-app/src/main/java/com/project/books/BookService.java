package com.project.books;

import java.util.ArrayList;
import java.util.List;

public class BookService {
	
	private static List<ReadBooks> bookList = new ArrayList<ReadBooks>();
	
	static {
		bookList.add(new ReadBooks("You Forever"));
		bookList.add(new ReadBooks("Wings of Fire"));
		bookList.add(new ReadBooks("I too had a love story"));
		
	}
	
	public List<ReadBooks> returnBooks() {
		return bookList;
	}

}
