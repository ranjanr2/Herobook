package com.example.library3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VillanRepository extends JpaRepository<VillanEntity, Long> {
}
