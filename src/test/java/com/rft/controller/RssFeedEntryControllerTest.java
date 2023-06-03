package com.rft.controller;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageImpl;
import org.mockito.junit.jupiter.MockitoExtension;

import com.rft.model.RssFeedEntry;
import com.rft.repository.RssFeedEntryRepository;
import com.rft.service.RssFeedEntryService;

@ExtendWith(MockitoExtension.class)
public class RssFeedEntryControllerTest {

	@Mock
    private RssFeedEntryRepository rssFeedEntryRepository;

    @Mock
    private RssFeedEntryService rssFeedEntryService;

    @InjectMocks
    private RssFeedEntryController rssFeedEntryController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testGetFirst10Entries() {
        // Mock the repository behavior
        List<RssFeedEntry> entries = new ArrayList<>();
        Mockito.when(rssFeedEntryRepository.findTop10ByOrderByIdAsc()).thenReturn(entries);

        // Call the controller method
        rssFeedEntryController.getFirst10Entries();

    }

    @Test
    public void testGetRssFeedEntries() {
        rssFeedEntryController.getRssFeedEntries(0, 10, "id", "asc");
    }

}

