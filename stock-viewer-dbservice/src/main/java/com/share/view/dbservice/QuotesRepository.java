package com.share.view.dbservice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuotesRepository extends JpaRepository<Quote, Integer>{
	
	List<Quote> findByUserName(String username);

}
