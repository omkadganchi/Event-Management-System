# Event Management System

This is a Spring Boot application designed to manage events, venues, and organizers. It provides features like creating, retrieving, updating, and deleting events, venues, and organizers, with relationships between entities. The application uses **Spring Data JPA** for database interaction, connected to a **MySQL** database.

## Features

- **Event Management:**
  - Create, update, delete, and retrieve events.
  - Retrieve events by venue and organizer.

- **Venue Management:**
  - Create, update, delete, and retrieve venue details.

- **Organizer Management:**
  - Create, update, delete, and retrieve organizer details.

- **Relationships:**
  - An event is linked to a venue and an organizer.
  
- **Error Handling:**
  - Handles cases for missing or invalid data, such as when an event, venue, or organizer is not found.

## Technologies Used

- **Spring Boot**: The core framework for the application.
- **Spring Data JPA**: Repository for database access and interaction.
- **MySQL**: Database to store event, venue, and organizer details.
- **Hibernate**: ORM (Object-Relational Mapping) for database interaction.
- **Maven**: Dependency management and build tool.
- **Java 17+**: The Java version used for the project.

## Setup and Installation

### Prerequisites

- **Java 17 or above**
- **Maven** (for dependency management and building the project)
- **IDE** (e.g., IntelliJ IDEA, Eclipse, or Spring Tool Suite)
- **MySQL** (for database interaction)

### Clone the Repository

Clone this repository to your local machine:

```bash
git clone https://github.com/omkadganchi/Event-Management-System.git
