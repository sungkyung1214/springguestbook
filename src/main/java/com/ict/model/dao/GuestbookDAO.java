package com.ict.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.model.vo.GuestbookVO;

@Repository
public class GuestbookDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	// 서비스에서 db처리하는 메서드를 모두 받아줘야 한다.
	
	//
	public List<GuestbookVO> guestbookList() {
		return sqlSessionTemplate.selectList("guestbook.list");			
	}
	
	public int guestbookAdd(GuestbookVO gvo) {
		return sqlSessionTemplate.insert("guestbook.insert", gvo);
		
	}
	
}
