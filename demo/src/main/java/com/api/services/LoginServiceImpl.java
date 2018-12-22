package com.api.services;

import org.springframework.stereotype.Service;

import com.api.models.Login;
import com.api.models.User;

@Service
public class LoginServiceImpl implements LoginService {

	public LoginServiceImpl()
	{
		
	}
	public boolean getAuthentic(Login login) {
		
		Database d=new Database();
		return d.getAuthentic(login);
		
	}
}
