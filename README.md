Technologies Used:

Backend: Spring Boot
Frontend: Angular
Email Protocol: SMTP (Simple Mail Transfer Protocol)
Key Features:

User Interface:

A user-friendly Angular frontend allows users to compose and send emails.
Input fields for recipient email address, subject, and message body.
Backend Services:

Spring Boot application handles the email sending functionality.
RESTful API endpoints for processing email requests from the frontend.
Integration with an SMTP server for sending emails.
Email Sending Process:

Users fill out the email form on the Angular frontend.
The form data is sent to the Spring Boot backend via a RESTful API call.
The backend processes the request and sends the email using the configured SMTP server.
Configuration:

SMTP server details (host, port, username, password) are configured in the Spring Boot application properties file.
Secure handling of sensitive information such as email credentials.
Usage:

To send an email, navigate to the email form on the application.
Enter the recipient's email address, the subject of the email, and the message content.
Click the 'Send' button to dispatch the email.
Benefits:

Streamlined email sending process through a web interface.
Separation of concerns with Angular handling the frontend and Spring Boot managing the backend.
Scalable and maintainable codebase leveraging the power of Java and JavaScript frameworks.
