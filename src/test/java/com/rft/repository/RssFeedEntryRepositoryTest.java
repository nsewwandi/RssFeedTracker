package com.rft.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.rft.service.RssFeedEntryServiceImpl;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class RssFeedEntryRepositoryTest {

    @Mock
    private RssFeedEntryRepository rssFeedEntryRepository;

    @InjectMocks
    private RssFeedEntryServiceImpl rssFeedEntryService;

    @Test
    public void testFindTop10ByOrderByIdAsc() {
        // Call the repository method
       rssFeedEntryRepository.findTop10ByOrderByIdAsc();

    }
}

