package com.msansar.wordmemorization.repository;


import com.msansar.wordmemorization.model.WordGroup;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.awt.print.Pageable;

public interface WordGroupRepository extends JpaRepository<WordGroup, String> {

}
