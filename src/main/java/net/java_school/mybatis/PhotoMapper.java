package net.java_school.mybatis;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import net.java_school.photo.Photo;

public interface PhotoMapper {

	public int selectCountOfPhotos();

	public List<Photo> selectPhotos(HashMap<String, String> hashmap);

	public void insert(@Param("content") String content);

	public void delete(@Param("no") Integer no);
}
