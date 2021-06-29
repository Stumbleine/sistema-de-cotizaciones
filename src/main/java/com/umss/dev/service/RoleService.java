package com.umss.dev.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umss.dev.entity.Role;
import com.umss.dev.entity.SpendingUnit;
import com.umss.dev.entity.User;
import com.umss.dev.exception.DtoNotFoundException;
import com.umss.dev.output.RoleOutput;
import com.umss.dev.output.RoleOutputNormalAtributes;
import com.umss.dev.output.SpendingUnitOutput;
import com.umss.dev.output.UserOutputNormalAtributes;
import com.umss.dev.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;
	private ModelMapper modelMapper;

	public RoleService(RoleRepository roleRepository, ModelMapper modelMapper) {
	    this.roleRepository = roleRepository;
	    this.modelMapper = modelMapper;
	   
	}
	
	public Role getById(Integer roleId) {
		Role roleAct = roleRepository.findById(roleId).orElse(null);
	    if (null == roleAct) {
	    	
	        throw new DtoNotFoundException(RoleOutputNormalAtributes.class.toString(), roleId);
	    }
	  
	    return roleAct;
	}
	
	public Role save(Role role) {
	    Role persistedRole = roleRepository.save(role);
	     
	     return persistedRole;
	}
	
	public Iterable<RoleOutput>  getAllRoles(){
		List <Role> allRoles = roleRepository.findAll();
		List <RoleOutput> allRolesByOrder = new ArrayList<RoleOutput>();
		
		for (Role found: allRoles) {
					
					RoleOutput newRole = new RoleOutput();
					newRole.setIdRole(found.getIdRole());
					newRole.setRoleName(found.getRoleName());
					newRole.setPrivilegios(found.getPrivileges());
					allRolesByOrder.add(newRole);
			
		}
		
		Collections.reverse(allRolesByOrder);
		
		return allRolesByOrder;	
	}
}
