package com.task.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.entity.Organizer;

@Repository
public interface OrganizerRepository extends JpaRepository<Organizer, Integer> {

}
