package kosta.exam.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "member")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "team") //toString 할 때 이것은 가져오지 마라 
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO ,generator = "member_id_seq")
	@SequenceGenerator(sequenceName = "member_id_seq", allocationSize = 1, name = "member_id_seq")
	private Long id;
	private String name;
	private int age;
	
	//@ManyToOne // 다(member) 대 일(team)인 경우는 즉시 로딩 
	@ManyToOne(fetch = FetchType.LAZY) //지연로딩
	@JoinColumn(name = "teamid")
	private Team team;
	

}
