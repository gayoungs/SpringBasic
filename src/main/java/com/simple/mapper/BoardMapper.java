package com.simple.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.simple.command.BoardVO;
@Mapper //mybatis-scan
public interface BoardMapper {

	public void boardRegist(BoardVO vo); //등록
	public ArrayList<BoardVO> getList(); //조회
	public void boardDelete(int num); //삭제
}