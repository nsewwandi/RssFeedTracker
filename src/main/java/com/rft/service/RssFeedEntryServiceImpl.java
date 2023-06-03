package com.rft.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rft.model.RssFeedEntry;
import com.rft.repository.RssFeedEntryRepository;

/**
Implementation of the {@link RssFeedEntryService} interface.
Provides methods to retrieve RSS feed entries.
*/
@Service
public class RssFeedEntryServiceImpl implements RssFeedEntryService {

    private final RssFeedEntryRepository rssFeedEntryRepository;

    /**
    Constructs a new {@link RssFeedEntryServiceImpl} with the specified repository.
    @param rssFeedEntryRepository the repository to be used for data access
    */
    public RssFeedEntryServiceImpl(RssFeedEntryRepository rssFeedEntryRepository) {
        this.rssFeedEntryRepository = rssFeedEntryRepository;
    }

    /**
    Retrieves a page of RSS feed entries.
    @param pageable, the pageable object specifying the page number, size, and sorting criteria
    @return a {@link Page} of {@link RssFeedEntry} objects
    */
    @Override
    public Page<RssFeedEntry> getRssFeedEntries(Pageable pageable) {
        return rssFeedEntryRepository.findAll(pageable);
    }
}