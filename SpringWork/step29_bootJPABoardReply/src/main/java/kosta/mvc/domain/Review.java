package kosta.mvc.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "REVIEW_NO_SEQ")
	@SequenceGenerator(sequenceName = "REVIEW_NO_SEQ", name = "REVIEW_NO_SEQ", allocationSize = 1)
	private Long subCategoryNo;
	
	@Column(nullable = false)
	private Long regNo;
	
	@Column(nullable = false, length = 3000)
	private String content;
	
	@Column(nullable = false)
	private String regDate;

	@ManyToOne
	@JoinColumn(name = "regNo")
	private Long reviewNo;

	@ManyToOne
	@JoinColumn(name = "userNo")
	private Long userNo;
	
	

}
