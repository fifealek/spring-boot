package com.alex.learnspringboot.repository;

import com.alex.learnspringboot.data.Chapter;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ChapterRepository extends ReactiveCrudRepository<Chapter, String> {

}
