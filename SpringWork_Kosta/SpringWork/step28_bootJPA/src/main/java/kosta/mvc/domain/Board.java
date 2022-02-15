package kosta.mvc.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "bno_seq")
	@SequenceGenerator(sequenceName = "bno_seq", allocationSize = 1, name="bno_seq")
	private Long bno; //글번호
	private String title; //제목
	private String writer; //작성자
	private String content; //내용
	
	@CreationTimestamp
	private LocalDateTime regDate; //등록일
	
	

}
