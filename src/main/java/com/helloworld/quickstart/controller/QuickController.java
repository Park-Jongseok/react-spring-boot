package com.helloworld.quickstart.controller;

import com.helloworld.quickstart.dto.ItemDto;
import com.helloworld.quickstart.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class QuickController {
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
		log.info("item : {}", item);
		ResponseDto responseDto = new ResponseDto();
		responseDto.setMessage("ok");
		return responseDto;
	}
}
