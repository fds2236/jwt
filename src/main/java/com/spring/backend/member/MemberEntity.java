package com.spring.backend.member;


import java.util.Date;

import com.spring.backend.util.Role;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Schema(description = "회원")
@Table(name = "member")
@Data
public class MemberEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "snum")
	@Schema(description = "번호") // hidden 스웨거에서 숨김
	private Long memberSnum;
	
	@Column(name = "id")
	@Schema(description = "아이디")
	private String memberId;
	
	@Column(name = "name")
	@Schema(description = "이름")
	private String memberName;
	
	@Column(name = "pwd")
	@Schema(description = "비밀번호")
	private String memberPwd;
	
	@Column(name = "addr")
	@Schema(description = "주소")
	private String memberAddr;
	
	@Column(name = "mail")
	@Schema(description = "메일", example = "test@naver.com")
	private String memberMail;
	
	@Column(name = "regDate", insertable = false) // insertable 안하면 insert할 때 포함됨
	@Schema(description = "가입일", hidden = true)
	private Date memberRegDate;
	
    @Enumerated(EnumType.STRING)
	private Role role;

}
