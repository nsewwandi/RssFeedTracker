package com.rft.polling;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Date;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.messaging.MessageHeaders;

import com.rft.repository.RssFeedEntryRepository;
import com.rometools.rome.feed.synd.SyndContentImpl;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndEntryImpl;
import com.rft.model.RssFeedEntry;

@ExtendWith(MockitoExtension.class)
public class RssFeedMessageHandlerTest {

    @Mock
    private RssFeedEntryRepository rssFeedEntryRepository;

    @InjectMocks
    private RssFeedMessageHandler rssFeedMessageHandler;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testHandle() {
        SyndEntry entry = new SyndEntryImpl();
        entry.setTitle("Test Title");
        entry.setLink("https://example.com");
        entry.setDescription(new SyndContentImpl());
        entry.setPublishedDate(new Date());

        rssFeedMessageHandler.handle(entry, new MessageHeaders(new HashMap<>()));

        ArgumentCaptor<RssFeedEntry> captor = ArgumentCaptor.forClass(RssFeedEntry.class);
        verify(rssFeedEntryRepository).save(captor.capture());

        RssFeedEntry savedEntry = captor.getValue();
        assertEquals("Test Title", savedEntry.getTitle());
        assertEquals("https://example.com", savedEntry.getLink());
    }
}

