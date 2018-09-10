package com.example.hv.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.hv.models.User;
import com.example.hv.repository.UserRepository;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserResource {
	
	@Autowired
	private UserRepository ur;
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<User> listaUser() {
		Iterable<User> ListaUser = ur.findAll();
		return ListaUser;
	}
	
	@PostMapping()
	public @Valid User cadastraUser(@RequestBody @Valid User user) {
		return ur.save(user);
	}
			
	@DeleteMapping()
	public User deletaUser(@RequestBody User user) {
		ur.delete(user);
		return user;				
	}
}
