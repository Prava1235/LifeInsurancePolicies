package com.employee.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.insurance.entity.SalientFeature;

@Repository
public interface SalientFeatureRepository extends JpaRepository<SalientFeature, Long> {


}