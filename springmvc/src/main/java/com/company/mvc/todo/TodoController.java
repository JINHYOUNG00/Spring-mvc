package com.company.mvc.todo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
@CrossOrigin(origins = "*")
public class TodoController {
	
	@Autowired TodoMapper mapper;
	
	
	@GetMapping(value="/getText",produces = MediaType.TEXT_PLAIN_VALUE)
	public String getText(){
		return "안녕하세요";
	}
	
	@GetMapping(".check")
	public List<TodoVO> check(TodoVO vo) {
		int a = 5/0;
		return mapper.findAll(vo);
	}
	
	// 조회면 get
	@GetMapping(value = "/todo",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<TodoVO>> todoList(TodoVO vo){
//		int a = 5/0;
		List<TodoVO> list = mapper.findAll(vo);
		return new ResponseEntity<List<TodoVO>>(list, HttpStatus.OK);
	}
	
	// 추가 post
	@PostMapping("/todo")
	public TodoVO todoInsert(TodoVO vo) {
		mapper.persist(vo);
		return vo;
	}
	
	// 수정 put
	@PutMapping("/todo") //파라미터가 json string만 가능 -> @RequestBody 필수
	public TodoVO todoUpdate(@RequestBody TodoVO vo) {
		mapper.merge(vo);
		return vo;
	}
	
	// 삭제 delete
	@DeleteMapping("/todo/{no}")
	public Integer todoDelete(@PathVariable Integer no) {
		mapper.remove(no);
		return no;
	}
	
	// 단건조회 
		@GetMapping("/todo/{no}")
		public TodoVO todoSelect(@PathVariable Integer no) {
			return mapper.findById(no);
		}
}
