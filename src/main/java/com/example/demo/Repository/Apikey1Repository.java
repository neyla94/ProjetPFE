package com.example.demo.Repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.ApiKey;
@Repository

public interface Apikey1Repository extends JpaRepository<ApiKey, Long>{
	ApiKey findByApikeyValue(String jwtToken);
	@Query("select d from ApiKey d where d.apikeyValue like :x ")
	public ApiKey getApiKey(@Param("x") String apikey);

}
