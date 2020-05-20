package com.example.portfolio.repository;

import com.example.portfolio.model.Categories;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ICategoryRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ICategoryRepository categoryRepository;

    @BeforeEach
    void init(){
        Categories categories = new Categories();
        categories.setCategoryId("1.1");
        categories.setName("Lập trình cơ bản");
        entityManager.persist(categories);
        entityManager.flush();
    }


    @Test
    @DisplayName("Find All")
    public void whenFindAll_thenReturlistNotNull(){
        assertThat(categoryRepository.findAll()).isNotNull();
    }
}