package com.example.pb.social_media.User.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pb.social_media.User.User;

@Repository
public interface UserRepository extends  JpaRepository<User, Long>{

}
