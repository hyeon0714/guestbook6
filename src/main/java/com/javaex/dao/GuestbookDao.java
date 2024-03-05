package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVo;

@Repository
public class GuestbookDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//리스트
	public List<GuestbookVo> list() {
		
		return sqlSession.selectList("guestbook.list");
	}
	
	//등록
	public void write(GuestbookVo gv) {
		
		sqlSession.insert("guestbook.insert", gv);
	}
	
	//삭제
	public void delete(GuestbookVo gv) {
		
		sqlSession.delete("guestbook.delete", gv);
	}
	
}
