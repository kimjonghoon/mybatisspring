package net.java_school.english;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.java_school.mybatis.WordMapper;

@Service
public class WordCardServiceImpl implements WordCardService {

	@Autowired
	private WordMapper wordMapper;
	
	@Override
	public void add(String word, String definitions) {
		wordMapper.insert(word, definitions);
	}

	@Override
	public WordCard getWordCard() {
		return wordMapper.selectOne();
	}
}