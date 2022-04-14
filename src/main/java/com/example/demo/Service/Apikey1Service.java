package com.example.demo.Service;

import com.example.demo.dto.ApiKeyDto;

public interface Apikey1Service {
	void addapi(ApiKeyDto ap, Long idUser);
	String validateApi (ApiKeyDto apiDto);

}
