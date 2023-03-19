package com.course.work.repositoriy;

import com.course.work.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TourRepository extends JpaRepository<Tour, Integer> {
    List<Tour> findAll();
}
