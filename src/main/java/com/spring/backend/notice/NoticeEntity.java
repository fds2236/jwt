package com.spring.backend.notice;


import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Schema(description = "공지사항")
@Table(name = "notice")
@Data
public class NoticeEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "snum")
	@Schema(description = "번호")
	private Long noticeSnum;
	
	@Column(name = "title")
	@Schema(description = "제목")
	private String noticeTitle;
	
	@Column(name = "contents")
	@Schema(description = "내용")
	private String noticeContents;
	
	@Column(name = "regDate", insertable = false) // insertable 안하면 insert할 때 포함됨
	@Schema(description = "작성일")
	private Date noticeRegDate;
	
	@Column(name = "writer")
	@Schema(description = "작성자")
	private String noticeWriter;
	

}
