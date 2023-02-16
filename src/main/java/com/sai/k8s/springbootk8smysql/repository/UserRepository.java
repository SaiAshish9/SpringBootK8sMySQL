package com.sai.k8s.springbootk8smysql.repository;

import com.sai.k8s.springbootk8smysql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
