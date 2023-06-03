package com.rft.polling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.core.GenericHandler;
import org.springframework.transaction.annotation.Transactional;

import com.rft.repository.RssFeedEntryRepository;
import com.rometools.rome.feed.synd.SyndEntry;

import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

import com.rft.model.RssFeedEntry;

/**
Custom message handler for processing RSS feed entries.
This class is annotated with {@code @Component} to indicate that it is a Spring component
and should be automatically detected and registered in the application context.
*/
@Component
public class RssFeedMessageHandler implements GenericHandler<SyndEntry> {

	/**
	The repository for persisting RSS feed entries.
	*/
    @Autowired
    private RssFeedEntryRepository rssFeedEntryRepository;

    /**
    Handles the processing of an RSS feed entry.
    @param entry The RSS feed entry to be processed.
    @param headers The headers associated with the message.
    @return Always returns {@code null} since this handler doesn't produce any output.
    */
    @Override
    @Transactional
    public Object handle(SyndEntry entry, MessageHeaders headers) {
        RssFeedEntry rssFeedEntry = new RssFeedEntry();
        rssFeedEntry.setTitle(entry.getTitle());
        rssFeedEntry.setLink(entry.getLink());
        rssFeedEntry.setDescription(entry.getDescription().getValue());
        rssFeedEntry.setPublishedDate(entry.getPublishedDate().toString());
        rssFeedEntryRepository.save(rssFeedEntry);        
        return null;
    }
}
