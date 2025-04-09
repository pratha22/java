package com.example.pb.social_media.User.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pb.social_media.User.UserPosts;

public interface UserPostsRepository extends JpaRepository<UserPosts,Long>{

}
