package com.skcc.es.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import com.skcc.es.domain.Phone;

public interface PhoneRepository extends ElasticsearchCrudRepository<Phone, Integer> {
	Page<Phone> findByAuthor(String author, Pageable pageable);
    List<Phone> findByNumber(String number);
}
