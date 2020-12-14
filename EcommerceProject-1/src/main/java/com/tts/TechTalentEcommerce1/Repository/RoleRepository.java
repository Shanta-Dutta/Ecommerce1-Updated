package com.tts.TechTalentEcommerce1.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.TechTalentEcommerce1.model.Role;


@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByRole(String role);
}