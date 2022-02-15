package kosta.exam.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Entity //DDL 옵션이 있따면 자동 생성
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Customer {

	@Id //pk
	@GeneratedValue(strategy = GenerationType.AUTO) //시퀀스 만들기
	private Long id;
	
	@Column(nullable = false, length = 50, name="name")
	private String userName;
	
	//@Transient //컬럼으로 만들지 않는다
	private int age;
	
	
	private String addr;
	
	@CreationTimestamp
	private LocalDateTime regDate; // timestamp (시,분,초가 정밀하게 들어감)
	
	@UpdateTimestamp
	private LocalDateTime updateDate; // date (원래 있던 것)
	
	@Temporal(TemporalType.TIME)
	private Date birthDay;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date etc;
}
