package com.stepan.myebay.repositories;

import com.stepan.myebay.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}