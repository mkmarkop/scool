package com.hackakthon.education.scool.model.repository;

import com.hackakthon.education.scool.model.entity.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChapterRepository extends JpaRepository<Chapter, Long> {
}
