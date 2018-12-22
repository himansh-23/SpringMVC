package com.api.services;

import com.api.models.*;

public class RegistrationServiceImpl implements RegistationService {
	
	
	public RegistrationServiceImpl()
	{
		
	}
	@Override
	public void save(User user) {
		Database database=new Database();
		database.add(user);
		
	}
	

}
