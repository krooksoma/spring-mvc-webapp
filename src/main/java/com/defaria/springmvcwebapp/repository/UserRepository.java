package com.defaria.springmvcwebapp.repository;

import com.defaria.springmvcwebapp.beans.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
