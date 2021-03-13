/**
 * 
 */
package com.revature.repository;

import java.util.List;

import com.revature.model.Role;


/**
 * @author Jinwei Xiong
 *
 */
public interface RoleDAO {
	Role findById(int roleId);
}
