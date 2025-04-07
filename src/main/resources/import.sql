INSERT INTO proffesors (id, proffesor_name, proffesor_last_name, proffesor_grouo_name, proffesor_email) VALUES (1, 'John', 'Doe', 'Mathematics', 'john.doe@example.com');
INSERT INTO proffesors (id, proffesor_name, proffesor_last_name, proffesor_grouo_name, proffesor_email) VALUES (2, 'Jane', 'Smith', 'Physics', 'jane.smith@example.com');
INSERT INTO proffesors (id, proffesor_name, proffesor_last_name, proffesor_grouo_name, proffesor_email) VALUES (3, 'Emily', 'Johnson', 'Chemistry', 'emily.johnson@example.com');
INSERT INTO proffesors (id, proffesor_name, proffesor_last_name, proffesor_grouo_name, proffesor_email) VALUES (4, 'Michael', 'Brown', 'Biology', 'michael.brown@example.com');
INSERT INTO proffesors (id, proffesor_name, proffesor_last_name, proffesor_grouo_name, proffesor_email) VALUES (5, 'Sarah', 'Davis', 'Computer Science', 'sarah.davis@example.com');


INSERT INTO roles (id, assigned_role) VALUES (1, 'COORDINATOR');
INSERT INTO roles (id, assigned_role) VALUES (2, 'COMMITTEE_MEMBER');


INSERT INTO historical_records (id, active, start_date, end_date, professorid, rolId) VALUES (1, true, '2023-01-01', '2023-12-31', 1, 1);
INSERT INTO historical_records (id, active, start_date, end_date, professorid, rolId) VALUES (2, true, '2023-01-01', '2023-12-31', 2, 2);
INSERT INTO historical_records (id, active, start_date, end_date, professorid, rolId) VALUES (3, true, '2023-01-01', '2023-12-31', 3, 1);
INSERT INTO historical_records (id, active, start_date, end_date, professorid, rolId) VALUES (4, true, '2023-01-01', '2023-12-31', 4, 2);
INSERT INTO historical_records (id, active, start_date, end_date, professorid, rolId) VALUES (5, true, '2023-01-01', '2023-12-31', 5, 1);