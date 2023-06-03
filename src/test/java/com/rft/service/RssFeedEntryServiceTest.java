package com.rft.service;

import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageImpl;

import com.rft.model.RssFeedEntry;
import com.rft.repository.RssFeedEntryRepository;

@ExtendWith(MockitoExtension.class)
public class RssFeedEntryServiceTest {

    @Mock
    private RssFeedEntryRepository rssFeedEntryRepository;

    @InjectMocks
    private RssFeedEntryServiceImpl rssFeedEntryService;

    @Test
    public void testGetRssFeedEntries() {
        // Mock the repository behavior
        Pageable pageable = PageRequest.of(0, 10);
        List<RssFeedEntry> entries = new ArrayList<>();
        Page<RssFeedEntry> page = new PageImpl<>(entries);
        Mockito.when(rssFeedEntryRepository.findAll(pageable)).thenReturn(page);

        // Call the service method
        Page<RssFeedEntry> result = rssFeedEntryService.getRssFeedEntries(pageable);

        // Assertions
        assertEquals(page, result);
        Mockito.verify(rssFeedEntryRepository, Mockito.times(1)).findAll(pageable);
    }
}

