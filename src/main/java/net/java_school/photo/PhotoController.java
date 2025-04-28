package net.java_school.photo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Controller
@RequestMapping("photo")
public class PhotoController {

	@Autowired
	private PhotoService photoService;

	private Map<String, Integer> getNumbersForPaging(int totalRecordCount, int page, int recordsPerPage,
			int pagesPerBlock) {

		Map<String, Integer> map = new HashMap<String, Integer>();

		int totalPageCount = totalRecordCount / recordsPerPage;
		if (totalRecordCount % recordsPerPage != 0)
			totalPageCount++;

		int totalBlockCount = totalPageCount / pagesPerBlock;
		if (totalPageCount % pagesPerBlock != 0)
			totalBlockCount++;

		int block = page / pagesPerBlock;
		if (page % pagesPerBlock != 0)
			block++;

		int firstPage = (block - 1) * pagesPerBlock + 1;
		int lastPage = block * pagesPerBlock;

		int prevBlock = 0;
		if (block > 1)
			prevBlock = firstPage - 1;

		int nextBlock = 0;
		if (block < totalBlockCount)
			nextBlock = lastPage + 1;
		if (block >= totalBlockCount)
			lastPage = totalPageCount;

		// int listItemNo = totalRecordCount - (page - 1) * recordsPerPage;
		int startRecord = (page - 1) * recordsPerPage + 1;
		int endRecord = page * recordsPerPage;

		map.put("finalPage", totalPageCount);
		map.put("firstPage", firstPage);
		map.put("lastPage", lastPage);
		map.put("prevBlock", prevBlock);
		map.put("nextBlock", nextBlock);
		map.put("startRecord", startRecord);
		map.put("endRecord", endRecord);

		return map;
	}

	@GetMapping
	public String index(Integer page, Model model) {
		if (page == null)
			return "redirect:/photo?page=1";

		int recordsPerPage = 4;
		int pagesPerBlock = 10;

		int totalRecordCount = photoService.getTotalRecordCount();

		Map<String, Integer> map = getNumbersForPaging(totalRecordCount, page, recordsPerPage, pagesPerBlock);
		Integer startRecord = map.get("startRecord");
		Integer endRecord = map.get("endRecord");

		List<Photo> photos = photoService.getPhotos(startRecord, endRecord);

		Integer prevBlock = map.get("prevBlock");
		Integer nextBlock = map.get("nextBlock");
		Integer firstPage = map.get("firstPage");
		Integer lastPage = map.get("lastPage");
		Integer finalPage = map.get("finalPage");

		model.addAttribute("photos", photos);
		model.addAttribute("prevBlock", prevBlock);
		model.addAttribute("nextBlock", nextBlock);
		model.addAttribute("firstPage", firstPage);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("finalPage", finalPage);

		return "photo/index";
	}

	@PostMapping
	@ResponseBody
	public void add(String content) {
		photoService.add(content);
	}

	@DeleteMapping("{no}")
	public String del(Integer page, @PathVariable Integer no) {
		photoService.del(no);
		return "redirect:/photo?page=" + page;
	}
}
