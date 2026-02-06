# Doctors Appointment Backend

This is the Spring Boot backend for the Doctors Appointment Booking System using H2 database.

## Technologies

- Spring Boot 3.1.5
- Spring Data JPA
- H2 Database (In-memory)
- Maven
- Java 17

## Prerequisites

- Java 17 or higher
- Maven 3.6+

## Installation & Setup

1. Navigate to backend directory:
```bash
cd backend
```

2. Build the project:
```bash
mvn clean install
```

3. Run the application:
```bash
mvn spring-boot:run
```

The backend will start on [http://localhost:8080](http://localhost:8080)

## Database

The application uses H2 in-memory database. Access the H2 console at:
```
http://localhost:8080/h2-console
```

**H2 Console Credentials:**
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: (leave empty)

## API Endpoints

### Get all appointments
```
GET /api/appointments
```

### Get appointment by ID
```
GET /api/appointments/{id}
```

### Create new appointment
```
POST /api/appointments
Content-Type: application/json

{
  "patientName": "John Doe",
  "patientEmail": "john@example.com",
  "patientPhone": "1234567890",
  "doctorName": "Dr. Smith",
  "appointmentDate": "2026-02-15",
  "appointmentTime": "10:30:00",
  "reason": "General Checkup"
}
```

### Update appointment
```
PUT /api/appointments/{id}
Content-Type: application/json

{
  "patientName": "Jane Doe",
  "appointmentDate": "2026-02-20"
}
```

### Delete appointment
```
DELETE /api/appointments/{id}
```

### Get appointments by patient email
```
GET /api/appointments/email/{email}
```

### Get appointments by doctor name
```
GET /api/appointments/doctor/{doctorName}
```

### Get appointments by date
```
GET /api/appointments/date/{date}
```

## Project Structure

```
backend/
├── src/
│   ├── main/
│   │   ├── java/com/doctorsappointment/
│   │   │   ├── entity/
│   │   │   │   └── Appointment.java
│   │   │   ├── repository/
│   │   │   │   └── AppointmentRepository.java
│   │   │   ├── service/
│   │   │   │   └── AppointmentService.java
│   │   │   ├── controller/
│   │   │   │   └── AppointmentController.java
│   │   │   └── DoctorsAppointmentApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── pom.xml
└── README.md
```

## CORS Configuration

The API is configured to accept requests from `http://localhost:3000` (React frontend).

## Notes

- All appointment dates should be in format: `YYYY-MM-DD`
- All appointment times should be in format: `HH:mm:ss`
- The H2 database is in-memory, so data will be cleared on application restart
- Use H2 console to view and manage the database directly
