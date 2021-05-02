package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryRepository extends JpaRepository <Note, Long> {

}
