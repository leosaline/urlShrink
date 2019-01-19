package com.saline.url.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saline.url.entity.Url;

public interface UrlRepository extends JpaRepository<Url, String> {

}
