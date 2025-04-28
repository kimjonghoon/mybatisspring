package net.java_school.photo;

import java.util.List;

public interface PhotoService {

	public int getTotalRecordCount();

	public List<Photo> getPhotos(Integer startRecord, Integer endRecord);

	public void add(String content);
	
	public void del(Integer no);
}
