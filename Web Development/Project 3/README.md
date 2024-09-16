
# SQL Project: Gym Management Queries

## Overview

This project focuses on SQL queries to manage and retrieve data from a gym management database. The tasks include listing instructors for a specific class, identifying courses and their instructors, and displaying booking details for a specific user.

## SQL Queries

### 1. Instructors for 'Body Pump' Class

**Query**: Retrieves instructors and start times for 'Body Pump' classes, ordered by instructor name.

```sql
SELECT instructor, start_time
FROM Timeslot t JOIN Class c ON t.cid = c.cid 
WHERE course = 'Body Pump'
ORDER BY instructor;
```

### 2. Courses and Related Instructors

**Query**: Lists all courses and their instructors, ordered by course name.

```sql
SELECT course, instructor 
FROM Class c JOIN Timeslot t ON c.cid = t.cid   
ORDER BY course;
```

### 3. User Booking Details (User ID: U001)

#### a) Booking Information

**Query**: Shows class details and reservations for a specific user.

```sql
SELECT c.cid, course, instructor, start_time, reservation
FROM Booking b JOIN Timeslot t ON b.tid = t.tid 
JOIN Class c ON t.cid = c.cid          
WHERE uid = 'U001' AND reservation = 1;
```

#### b) Total Bookings by Class

**Query**: Counts total reservations per class for the user, if they are a student.

```sql
SELECT cid, SUM(reservation) AS Final 
FROM Booking b JOIN Timeslot t ON b.tid = t.tid
JOIN User u ON u.uid = b.uid	  
WHERE b.uid = 'U001' AND student = 'Y'
GROUP BY cid;
```

## Conclusion

These SQL queries effectively manage and retrieve key data from the gym's database, demonstrating the use of joins, filtering, and aggregation.
```
