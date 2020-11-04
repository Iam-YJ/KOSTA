package model.dao;

import java.util.List;

import model.dto.Melon;

public class MelonDAOImpl implements MelonDAO{

	/**
	 * 조회수 정렬
	 */
	@Override
	public List<Melon> selectByHits(int hits) {

		return null;
	}
	
	
	/**
	 * 평점 정렬
	 */
	@Override
	public List<Melon> selectByGrade(double grade) {

		return null;
	}

	/**
	 * 식당종류(음식테마) 정렬
	 */
	@Override
	public List<Melon> selectByType(String type) {

		return null;
	}

	/**
	 * 조회수 업데이트
	 */
	@Override
	public int updateHits(int resNo) {

		return 0;
	}

	/**
	 * 지역별 정렬
	 */
	@Override
	public List<Melon> selectByArea(String area) {

		return null;
	}

}
