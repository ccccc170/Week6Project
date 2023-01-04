### Week 6 - APIs

### General Requirements

All projects:

- Must be run as Scrum projects
- Must apply SOLID & OO principles
- Must use the MVC pattern where there is a user interface
- Should use well-known design patterns where appropriate
- Must include comprehensive ```JUnit``` testing or equivalent
- Should begin with the creation of tests, in line with a test-driven development approach
- Must use ```log4j2``` for appropriate runtime logging or equivalent
- Must implement appropriate exception handling
- Must be hosted on GitHub and thoroughly documented, through a `README.md` file

#### Purpose

In addition to the general goals of projects, this project will give trainees an opportunity to:

- Explore the concepts of REST by implementing a service
- Implement multiple mapping types and parameter handling approaches
- Implement authentication for APIs
- Integrate a JPA/Hibernate back-end with a Spring REST API

#### Requirements

- Create an API to access the JPA entities created for the employees database in week 5
- Provide basic CRUD access for all relevant tables via the API
- Provide access to the additional analytical methods as well
- Implement appropriate error handling and reporting, including logging
- Implement the generation of API keys for users and allow multiple levels of user based on the API key (this will involve the creation of additional database resources to store the keys and access levels and a distribution mechanism)
  - Basic user (read-only access)
  - Update user (CRU access)
  - Admin user (full CRUD)
- Include testing using Jackson/JUnit, Postman and Spring Boot Test as appropriate

#### Groups

Please let Neil Weightman know who will be acting as Scrum Master and Git Manager for this project - this should be different from week 5

##### The Polymorphic Pirates

- Liam Gregory
- Hanibal Brhanu
- **Craig Wroe** Git
- Abdullah Nazeer
- Omari Grant
- **Cameron Higgins** Scrum
- Patryk Blakala

##### The Superclass Skirmishers

- David Bragadireanu
- **Ben Swenson** Scrum
- JB Lemard-Reid
- **Emre Ceyhan** Git
- Yash Jagani
- Ignas Stepura
- Rob Ciuches