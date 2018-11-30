package com.skcc.es.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skcc.es.domain.Phone;
import com.skcc.es.service.PhoneService;

@RestController
public class PhoneController {
	
	private static final Logger log = LoggerFactory.getLogger(PhoneController.class);

	@Autowired
    private PhoneService phoneService;
	
	@PostMapping("/phone")
	public Phone create(@RequestBody Phone phone) {
		log.info(phone.toString());
        return phoneService.save(phone);
    }
	
	@PutMapping("/phone")
	public Phone update(@RequestBody Phone phone) {
		log.info(phone.toString());
        return phoneService.save(phone);
    }
	
	@DeleteMapping("/phone")
    public void delete(@RequestBody Phone phone) {
		log.info(phone.toString());
        phoneService.delete(phone);
    }
	
	@GetMapping("/phone/{id}")
    public Optional<Phone> findById(@PathVariable Integer id) {
        return phoneService.findById(id);
    }
 
	@GetMapping("/phone")
    public Iterable<Phone> findAll() {
        return phoneService.findAll();
    }
 
//	@GetMapping("/phone/author")
//    public Page<Phone> findByAuthor(@RequestParam String author, PageRequest pageRequest) {
//        return phoneService.findByAuthor(author, pageRequest);
//    }
// 
//	@GetMapping("/phone/number")
//    public List<Phone> findByNumber(@RequestParam String number) {
//        return phoneService.findByNumber(number);
//    }
    
}
