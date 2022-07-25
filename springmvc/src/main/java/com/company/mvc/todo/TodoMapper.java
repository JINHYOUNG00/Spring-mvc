package com.company.mvc.todo;

import java.util.List;

public interface TodoMapper {
	public List<TodoVO> findAll(TodoVO vo);
	public void persist(TodoVO vo);
	public void merge(TodoVO vo);
	public void remove(Integer no);
	public TodoVO findById(Integer no);
} 
