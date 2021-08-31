package com.challenge.challenge;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@SpringBootApplication
@ServletComponentScan
public class ChallengeApplication {

	@Autowired
	ProvinceRepository provinceRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ChallengeApplication.class, args);
	}
	@GetMapping("/provinces/")
	public ResponseEntity<List<Province>> getProvinceList() {
		try {
			List<Province> provinces = provinceRepository.findAll();
			return new ResponseEntity<>(provinces,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/provinces/")
	public ResponseEntity<Province> saveProvince(@RequestBody Province province) {
		try {
			province = provinceRepository.save(province);
			return new ResponseEntity<>(province,HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		 
	}
	@DeleteMapping("/provinces/")
	public ResponseEntity<String> deleteProvince(@PathVariable("id") Long id ) {
		try {
			provinceRepository.deleteById(id);
			return new ResponseEntity<>("Success",HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>("Failed",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
