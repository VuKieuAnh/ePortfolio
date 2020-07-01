package com.example.portfolio.service.outcomes;

import com.example.portfolio.model.Outcomes;
import com.example.portfolio.repository.IOutcomesRepository;
import com.example.portfolio.service.categories.CategoryService;
import com.example.portfolio.service.categories.ICategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OutComesServiceTest {

    private IOutcomesRepository outcomesRepository = Mockito.mock(IOutcomesRepository.class);
    private IOutComesService outComesService = new OutComesService(outcomesRepository);

    private static Outcomes outcomes;
    private static List<Outcomes> emptyOutComes;
    private static List<Outcomes> outcomesList;

    @BeforeEach
    void init(){
        outcomes = new Outcomes();
        outcomes.setTitle("Phần 1: Lập trình căn bản");
        when(outcomesRepository.save(outcomes)).thenReturn(outcomes);

    }

    @Test
    void remove() {
        outcomesRepository.deleteById(1L);
        verify(outcomesRepository, times(1)).deleteById(1L);
    }

    @Test
    @DisplayName("save outcome call outcomeRepo 1")
    void whensave_thenCallOutcomRepo(){
        outComesService.save(outcomes);
        verify(outcomesRepository, times(1)).save(outcomes);
    }

    @DisplayName("findAll can return list has 0 outcomes")
    @Test
    void whenFindAll_thenReturn0Outcomes() {
        when(outComesService.findAll()).thenReturn(emptyOutComes);
        List<Outcomes> result = (List<Outcomes>) outComesService.findAll();
        verify(outcomesRepository).findAll();
        assertEquals(emptyOutComes, result);
    }

    @DisplayName("find All can return 1 outcomes")
    @Test
    void whenFindAll_thenReturn1Element(){
        when(outcomesRepository.findAll()).thenReturn(outcomesList);
        List<Outcomes> result = (List<Outcomes>) outComesService.findAll();
        verify(outcomesRepository).findAll();
        assertEquals(outcomesList, result);
    }



    @Test
    void findById() {
    }

    @Test
    void save() {
    }

//    @Test
//    void remove() {
//        outcomesRepository.deleteById(1L);
//        verify(outcomesRepository, times(1)).deleteById(1L);
//    }


    @Test
    void findByTitle() {
    }
}