# RssFeedTracker

This is a simple RSS feed reading application that fetches and displays RSS feeds in rest end points.

## Features

- Fetches RSS feeds from given sources.
- Displays the title, description, url and publication date of each feed entry.

## Technologies Used

- Java
- Spring Boot
- Rome RSS Parser Library
- H2 Data Source

## Getting Started

To get a local copy of the project up and running, follow these steps:

1. Clone the repository: `git clone https://github.com/your-username/rss-feed-reader.git`
2. Navigate to the project directory: `cd RSSFeedsTracker`
3. Build the project: `mvn package spring-boot:repackage`
4. Run the application: `java -jar RSSFeedsTracker-0.0.1-SNAPSHOT`
5. Access the service endpoints in your browser: `http://localhost:8080/items, http://localhost:8080/items?page=1&size=2&direction=asc&sort=publishedDate`

## Acknowledgments

- Special thanks to the creators of the RSS parser library used in this project.
