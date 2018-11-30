package com.skcc.es.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.skcc.es.domain.Phone;
import com.skcc.es.repository.PhoneRepository;

@Service
public class PhoneService {
	
	@Autowired
    private PhoneRepository phoneRepository;
 
    public Phone save(Phone phone) {
        return phoneRepository.save(phone);
    }
 
    public void delete(Phone phone) {
        phoneRepository.delete(phone);
    }
 
    public Optional<Phone> findById(Integer id) {
        return phoneRepository.findById(id);
    }
 
    public Iterable<Phone> findAll() {
        return phoneRepository.findAll();
    }
 
    public Page<Phone> findByAuthor(String author, PageRequest pageRequest) {
        return phoneRepository.findByAuthor(author, pageRequest);
    }
 
    public List<Phone> findByNumber(String number) {
        return phoneRepository.findByNumber(number);
    }
    
}
