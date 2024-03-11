package com.helloworld.quickstart.service;

import com.helloworld.quickstart.dto.ItemDto;
import com.helloworld.quickstart.mapper.QuickMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@Slf4j
public class QuickService {

	@Autowired
	private QuickMapper quickMapper;

	public boolean registerItem(ItemDto itemDto) {
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", itemDto.getId());
		paramMap.put("name", itemDto.getName());
		quickMapper.registerItem(paramMap);
		return true;
	}

	public ItemDto getItemById(String id) {
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", id);
		HashMap<String, Object> response = quickMapper.findById(paramMap);
		log.info(response.toString());
		ItemDto itemDto = new ItemDto();
		itemDto.setId((String) response.get("ID"));
		itemDto.setName((String) response.get("NAME"));
		return itemDto;
	}
}
