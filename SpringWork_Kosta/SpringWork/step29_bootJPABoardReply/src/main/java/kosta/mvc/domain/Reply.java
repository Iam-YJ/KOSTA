package kosta.mvc.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reply {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "reply_seq_id")
	@SequenceGenerator(sequenceName = "reply_seq_id",allocationSize = 1, name = "reply_seq_id" )
	private Long id;
	
	private String content;

	@CreationTimestamp
	private LocalDateTime regDate;
	
	//Board의 bno 들어와야 한다 -> join
	@ManyToOne //즉시로딩 기본값 
	@JoinColumn(name = "free_bno")
	private FreeBoard freeBoard;
}
