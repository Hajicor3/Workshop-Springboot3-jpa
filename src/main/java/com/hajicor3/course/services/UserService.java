package com.hajicor3.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.hajicor3.course.entities.User;
import com.hajicor3.course.repositories.UserRepository;
import com.hajicor3.course.services.exceptions.DataBaseException;
import com.hajicor3.course.services.exceptions.ResourceNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
		
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			
			User user = findById(id);//solução
	        repository.delete(user);
			//repository.deleteById(id); -> não funciona com a primeira exception.
		}catch(EmptyResultDataAccessException e){
			
			throw new ResourceNotFoundException(id);
		}catch(DataIntegrityViolationException e) {
			
			throw new DataBaseException(e.getMessage());
		}
	}
	
	@Transactional //Faz o hibernate manter a sessão aberta durante o método UpdateData();
	public User update(Long id, User obj) {
		User entity	= repository.getReferenceById(id);
		UpdateData(entity,obj);
		return repository.save(entity);
	}

	private void UpdateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
		
	}
}
