package com.codinglevel.repository;

import com.codinglevel.entities.StudentIdCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentIdCardRepository extends CrudRepository<StudentIdCard, Long> {



}
