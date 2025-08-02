package com.greedy.section01.fieldinjection.javaconfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository("bookDAO")
public class BookDAOImpl implements BookDAO {
	
	private final Map<Integer, BookDTO> bookList;
	
	public BookDAOImpl() {
		bookList = new HashMap<>();
		
		bookList.put(1, new BookDTO(1, 123456, "자바의 정석", "남궁성", "도우출판", new java.util.Date()));
		bookList.put(2, new BookDTO(2, 324312, "칭찬은 고래도 춤추게한다.", "고래", "클러버", new java.util.Date()));
	}

	@Override
	public List<BookDTO> selectBookList() {
		
		return new ArrayList<BookDTO>(bookList.values());
	}

	@Override
	public BookDTO selectOneBook(int sequence) {
		
		return bookList.get(sequence);
	}

}





