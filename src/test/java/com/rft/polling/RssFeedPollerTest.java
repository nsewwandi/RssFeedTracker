package com.rft.polling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.integration.feed.inbound.FeedEntryMessageSource;
import org.springframework.messaging.MessageChannel;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = RssFeedPoller.class)
@DirtiesContext
public class RssFeedPollerTest {

	@Mock
    private MessageChannel feedChannel;

	@Mock
    private RssFeedMessageHandler rssFeedMessageHandler;
	
	@InjectMocks
    private RssFeedPoller rssFeedPoller;
    
    @Mock
    private FeedEntryMessageSource messageSourceMock;
	
    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFeedChannel() {
        rssFeedPoller.feedChannel();
    }


}

