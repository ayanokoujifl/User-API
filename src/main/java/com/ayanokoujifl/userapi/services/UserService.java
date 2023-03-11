package com.ayanokoujifl.userapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ayanokoujifl.userapi.domain.User;
import com.ayanokoujifl.userapi.repositories.UserRepository;
import com.ayanokoujifl.userapi.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	UserRepository repo;

	@Transactional(readOnly = true)
	public List<User> findAll() {
		return repo.findAll();
	}

	@Transactional(readOnly = true)
	public User findById(Integer id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Usuário não encontrado! Id: " + id + ", Tipo: " + User.class.getName()));
	}

	@Transactional(readOnly = true)
	public User findByEmail(String email) {
		return repo.findByEmail(email).orElseThrow(() -> new ObjectNotFoundException(
				"Email não encontrado! Email: " + email + ", Tipo: " + User.class.getName()));
	}

	@Transactional
	public User save(User user) {
		user.setId(null);
		return repo.saveAndFlush(user);
	}

	public User update(User user) {
		User newUser = findById(user.getId());
		updateData(newUser, user);
		return repo.saveAndFlush(newUser);
	}

	private void updateData(User newUser, User user) {
		newUser.setUsername(user.getUsername());
		newUser.setEmail(user.getEmail());
		newUser.setSenha(user.getSenha());
	}

	public void delete(Integer id) {
		findById(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possível deletar este usuário!");
		}
	}
}
