package com.helloworld.quickstart.controller;

import com.helloworld.quickstart.dto.ItemDto;
import com.helloworld.quickstart.dto.ResponseDto;
import com.helloworld.quickstart.service.QuickService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class QuickController {

	@Autowired
	private QuickService quickService;

	@GetMapping("/dummy")
	public String dummy() {
		log.info("dummy");
		return "{}";
	}

	@GetMapping("/dummy2")
	public String dummy2() {
		log.info("dummy2");
		return "{}";
	}

	@GetMapping("/member")
	public String getMember(@RequestParam("empNo") String empNo) {
		log.info("empNo : {}", empNo);
		return "ok";
	}

	@GetMapping("/company/{id}")
	public String getCompany(@PathVariable("id") String id) {
		log.info("empNo : {}", id);
		return "ok";
	}

	@PostMapping("/item")
	public ResponseDto registerItem(@RequestBody ItemDto item) {
		boolean result = quickService.registerItem(item);
		ResponseDto responseDto = new ResponseDto();
		if (result) {
			responseDto.setMessage("OK");
		} else {
			responseDto.setMessage("Fail");
		}
		return responseDto;
	}

	@GetMapping("/item")
	public ItemDto getItem(@RequestParam("id") String id) {
		return quickService.getItemById(id);
	}
}
