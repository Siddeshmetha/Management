package com.sid.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sid.models.Tasks;


@Repository
public interface TaskRepository extends JpaRepository<Tasks, Integer> {

}