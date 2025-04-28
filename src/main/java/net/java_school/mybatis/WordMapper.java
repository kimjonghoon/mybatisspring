package net.java_school.mybatis;

import net.java_school.english.WordCard;

import org.apache.ibatis.annotations.Param;

public interface WordMapper {
	public void insert(@Param("word") String word, @Param("definitions") String definitions);
	public WordCard selectOne();
}