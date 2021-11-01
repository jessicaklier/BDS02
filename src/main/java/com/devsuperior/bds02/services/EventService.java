package com.devsuperior.bds02.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.entities.Event;
import com.devsuperior.bds02.repositories.EventRepository;



@Service
public class EventService {
	
	@Autowired
	private EventRepository repository;
	
	@Transactional
	public EventDTO update(Long id, EventDTO dto) throws ResourceNotFoundException {
		try {
			Event entity = repository.getOne(id);
			CopyDTOToEntity(dto, entity);
			entity = repository.save(entity);
			return new EventDTO(entity);
		}

		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);


		}
	}

	private void CopyDTOToEntity(EventDTO dto, Event entity) {
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setDate(dto.getDate());
		entity.setCity(null);	
}
	}


	