package com.company.mvc.reply;

import java.sql.Date;

import lombok.Data;

@Data
public class ReplyVO {
	private long rno;
	private long bno;
	private String reply;
	private String replyer;
	private Date replyDate;
	private Date updateDate;
	
}
