package com.rft.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

/**
Represents an RSS feed entry.
This class is annotated with {@code @Entity} to indicate that it is a persistent entity
mapped to a database table.
*/
@Entity
public class RssFeedEntry {

	/**
	The unique identifier of the RSS feed entry.
	*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
    The title of the RSS feed entry.
    */
    private String title;
    
    /**
    The description of the RSS feed entry.
    This field is annotated with {@code @Lob} and {@code @Column} to indicate that it should
    be stored as a CLOB (Character Large Object) in the database.
    */
    @Lob
    @Column(columnDefinition = "CLOB")
    private String description;
    
    /**
    The link associated with the RSS feed entry.
    */
    private String link;
    
    /**
    The published date of the RSS feed entry.
    */
    private String publishedDate;
    
    // getters and setters
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}