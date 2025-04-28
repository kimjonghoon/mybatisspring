package net.java_school.photo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.HashMap;

import net.java_school.mybatis.PhotoMapper;

@Service
public class PhotoServiceImpl implements PhotoService {

	@Autowired
	private PhotoMapper photoMapper;

	@Override
	public int getTotalRecordCount() {
		return photoMapper.selectCountOfPhotos();
	}

	@Override
	public List<Photo> getPhotos(Integer startRecord, Integer endRecord) {
		HashMap<String, String> hashmap = new HashMap<String, String>();
		hashmap.put("start", startRecord.toString());
		hashmap.put("end", endRecord.toString());

		return photoMapper.selectPhotos(hashmap);
	}

	@Override
	public void add(String content) {
		photoMapper.insert(content);
	}

	@Override
	public void del(Integer no) {
		photoMapper.delete(no);
	}
}
