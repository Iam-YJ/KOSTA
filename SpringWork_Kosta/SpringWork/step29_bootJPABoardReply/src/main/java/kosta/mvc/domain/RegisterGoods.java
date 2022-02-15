package kosta.mvc.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RegisterGoods {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "REG_NO_SEQ")
	@SequenceGenerator(sequenceName = "REG_NO_SEQ", name = "REG_NO_SEQ", allocationSize = 1)
	private Long regNo;

	@Column(nullable = false, length = 512)
	private String title;
	
	@Column(nullable = true, length = 3000)
	private String detail;
	
	@Column(nullable = false, length = 3000)
	private String thumbnailImg;
	
	@Column(nullable = true, length = 3000)
	private String adImg;
	
	@Column(nullable = false, length = 100)
	private String name;
	
	@Column(nullable = false, length = 512)
	private String options; //option이 아마 예약어일듯..
	
	@Column(nullable = false, length = 512)
	private String area;
	
	@Column(nullable = false, length = 512)
	private String method;
	
	@Column(nullable = false)
	private int stock;
	
	@Column(nullable = false)
	private int price;
	
	@Column(nullable = false, columnDefinition = "int default 0")
	private int sellcount;
	
	@Column(nullable = false, length = 1)
	private int ad;
	
	@ManyToOne
	@JoinColumn(name = "mainCategoryNo")
	private MainCategories mainCategories;

	@ManyToOne
	@JoinColumn(name = "subCategoryNo")
	private SubCategories subCategories;
	
	
	@OneToMany(mappedBy = "review")
	private List<Review> reviewList = new ArrayList<Review>();


}
