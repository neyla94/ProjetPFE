package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.ApiKey;
@Repository

public interface Apikey1Repository extends JpaRepository<ApiKey, Long>{
	ApiKey findByApikeyValue(String jwtToken);

}
