package com.example.Validation.of.Attributes.repository;

import com.example.Validation.of.Attributes.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoy  extends CrudRepository<User, Long>{
}
