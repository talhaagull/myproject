package com.patika.kitapyurdum.repository;

import com.patika.kitapyurdum.model.Magazine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MagazineRepository extends JpaRepository<Magazine, Long> {
}