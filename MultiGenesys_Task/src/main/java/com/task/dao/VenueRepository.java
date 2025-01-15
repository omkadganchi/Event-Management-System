package com.task.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.entity.Venue;

@Repository 
public interface VenueRepository extends JpaRepository<Venue, Integer> {

}
