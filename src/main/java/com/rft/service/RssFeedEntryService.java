package com.rft.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.rft.model.RssFeedEntry;

/**
Service interface for retrieving RSS feed entries.
*/
public interface RssFeedEntryService {

/**
Retrieves a paginated list of RSS feed entries.
@param pageable The pagination and sorting information.
@return A {@link Page} containing the requested RSS feed entries.
*/
	Page<RssFeedEntry> getRssFeedEntries(Pageable pageable);
}
