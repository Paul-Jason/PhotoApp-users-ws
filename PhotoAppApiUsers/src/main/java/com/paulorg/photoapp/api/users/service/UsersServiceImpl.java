package com.paulorg.photoapp.api.users.service;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.paulorg.photoapp.api.users.data.UserEntity;
import com.paulorg.photoapp.api.users.data.UsersRepository;
import com.paulorg.photoapp.api.users.shared.UserDTO;
import com.paulorg.photoapp.api.users.ui.model.CreateUserResponseModel;

@Service 
public class UsersServiceImpl implements UsersService{

	@Autowired
	UsersRepository userRepository;
	
	//To autowire this object should be existing in the application context
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public UserDTO createUser(UserDTO userDetails) {
		userDetails.setUserId(UUID.randomUUID().toString());
		userDetails.setEncryptedPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity userEntity = modelMapper.map(userDetails, UserEntity.class);
		userRepository.save(userEntity);
		UserDTO userDTO = modelMapper.map(userEntity, UserDTO.class);
		return userDTO;
	}

}
