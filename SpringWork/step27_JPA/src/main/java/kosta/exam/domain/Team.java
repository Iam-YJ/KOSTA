package kosta.exam.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude="list")
public class Team {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="team_id_seq")
	@SequenceGenerator(sequenceName = "team_id_seq", name = "team_id_seq", allocationSize = 1)
	private Long id;
	private String teamName;

	
	  //@OneToMany(mappedBy = "team") // 1:다 private -> 지연로딩
	  //mappedBy에 다른 클래스에서 선언한 이름 그대로 써야함 
	
	  @OneToMany(mappedBy = "team", fetch=FetchType.EAGER) //즉시해라
	  List<Member> list = new ArrayList<Member>();
	 
}
