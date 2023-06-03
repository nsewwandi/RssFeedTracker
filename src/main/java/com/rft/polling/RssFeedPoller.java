package com.rft.polling;

import com.rometools.rome.feed.synd.SyndEntry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.feed.inbound.FeedEntryMessageSource;
import org.springframework.messaging.MessageChannel;
import org.springframework.integration.channel.DirectChannel;

import java.net.MalformedURLException;
import java.net.URL;


/**
Configuration class for setting up the RSS feed polling functionality.
Uses {@link RssFeedMessageHandler} to handle the received feed entries.
*/
@SuppressWarnings("removal")
@Configuration
@ComponentScan("com.rft.polling")
public class RssFeedPoller {

    @Value("${rss.feed.url}")
    private String rssFeedUrl;

    @Autowired
    private RssFeedMessageHandler rssFeedMessageHandler;

    /**
    Creates a {@link MessageSource} bean to retrieve the RSS feed entries.
    @return the configured {@link MessageSource} bean
    @throws MalformedURLException if the specified feed URL is malformed
    */
    @Bean
    @InboundChannelAdapter(channel = "feedChannel", poller = @Poller(fixedRate = "5000"))
    public MessageSource<SyndEntry> feedMessageSource() throws MalformedURLException {
        FeedEntryMessageSource messageSource = new FeedEntryMessageSource(new URL(rssFeedUrl), "feed");
        return messageSource;
    }

    /**
    Creates a {@link MessageChannel} bean for routing the feed entries.
    @return the configured {@link MessageChannel} bean
    */
    @Bean
    public MessageChannel feedChannel() {
        return new DirectChannel();
    }

    /**
    Configures the integration flow for processing the feed entries.
    @return the configured {@link IntegrationFlow} bean
    @throws MalformedURLException if the specified feed URL is malformed
    */
    @Bean
    public IntegrationFlow feedChannelFlow() throws MalformedURLException {
        return IntegrationFlows.from(feedMessageSource(), configurer -> configurer.poller(Pollers.fixedRate(5000)))
                .channel(feedChannel())
                .handle(rssFeedMessageHandler)
                .get();
    }
}