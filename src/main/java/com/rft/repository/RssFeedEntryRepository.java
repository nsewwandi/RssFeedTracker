package com.rft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rft.model.RssFeedEntry;

/**
Repository interface for managing RSS feed entries.
*/
@Repository
public interface RssFeedEntryRepository extends JpaRepository<RssFeedEntry, Long> {
	/**
	Retrieves the top 10 RSS feed entries ordered by ID in ascending order.
	@return A list of the top 10 RSS feed entries.
	*/
    List<RssFeedEntry> findTop10ByOrderByIdAsc();
}
