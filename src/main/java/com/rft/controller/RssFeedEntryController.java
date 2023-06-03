package com.rft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rft.model.RssFeedEntry;
import com.rft.repository.RssFeedEntryRepository;
import com.rft.service.RssFeedEntryService;

/**
REST controller for handling RSS feed entries.
*/
@RestController
@RequestMapping("/items")
public class RssFeedEntryController {

    @Autowired
    private RssFeedEntryRepository rssFeedEntryRepository;
    
    private final RssFeedEntryService rssFeedEntryService;

    /**
    Constructs a new RssFeedEntryController with the given RssFeedEntryService.
    @param rssFeedEntryService The RssFeedEntryService to be used.
    */
    public RssFeedEntryController(RssFeedEntryService rssFeedEntryService) {
        this.rssFeedEntryService = rssFeedEntryService;
    }

    /**
    Retrieves the first 10 RSS feed entries.
    @return A list of the first 10 RSS feed entries.
    */
    @GetMapping
    public List<RssFeedEntry> getFirst10Entries() {
        return rssFeedEntryRepository.findTop10ByOrderByIdAsc();
    }
    
    /**
    Retrieves a paginated list of RSS feed entries.
    @param page The page number.
    @param size The page size.
    @param sort The field to sort by.
    @param direction The sort direction ("asc" or "desc").
    @return A {@link Page} containing the requested RSS feed entries.
    */
    @GetMapping(params = {"page", "size", "sortBy", "direction"})
    public Page<RssFeedEntry> getRssFeedEntries(@RequestParam(defaultValue = "0") int page,
                                               @RequestParam(defaultValue = "10") int size,
                                               @RequestParam(defaultValue = "id") String sort,
                                               @RequestParam(defaultValue = "asc") String direction) {
        Sort.Order sortOrder = new Sort.Order(Sort.Direction.fromString(direction), sort);
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortOrder));
        return rssFeedEntryService.getRssFeedEntries(pageable);
    }
}