package com.devsuperior.bds02.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.services.EventService;
import com.devsuperior.bds02.services.ResourceNotFoundException;



@RestController
@RequestMapping(value = "/events")
public class EventController {

	@Autowired
	private EventService service;

	@PutMapping(value = "/{id}")
	public ResponseEntity<EventDTO> update(@Validated @PathVariable Long id, @RequestBody EventDTO dto) throws ResourceNotFoundException {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);

}
	}
		