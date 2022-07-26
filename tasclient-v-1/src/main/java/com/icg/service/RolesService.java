package com.icg.service;

import java.util.List;

import com.icg.model.Role;

public interface RolesService {

	List<Role> getRoles(String userId);

}
