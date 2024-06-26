/* 
    Script 2: Insert data to EmployeeData database with primary key and foreign key 
*/


SET FOREIGN_KEY_CHECKS=0;

INSERT INTO job_titles (job_title_id,job_title)
VALUES 
(100,'software manager'),
(101,'software architect'),
(102,'software engineer'),
(103,'software developer'),
(200,'marketing manager'),
(201,'marketing associate'),
(202,'marketing assistant'),
(900,'Chief Exec. Officer'),
(901,'Chief Finn. Officer'),
(902,'Chief Info. Officer');

INSERT INTO employees (Fname, Lname, email, HireDate, Salary)
VALUES 
('Snoopy', 'Beagle', 	'Snoopy@example.com', 	'2022-08-01', 45000.00),
('Charlie', 'Brown', 	'Charlie@example.com', 	'2022-07-01', 48000.00),
('Lucy', 'Doctor', 		'Lucy@example.com', 	'2022-07-03', 55000.00),
('Pepermint', 'Patti', 	'Peppermint@example.com', '2022-08-02', 98000.00),
('Linus', 'Blanket', 	'Linus@example.com', 	'2022-09-01', 43000.00),
('PigPin', 'Dusty', 	'PigPin@example.com', 	'2022-10-01', 33000.00),
('Scooby', 'Doo', 		'Scooby@example.com', 	'1973-07-03', 78000.00),
('Shaggy', 'Rodgers', 	'Shaggy@example.com', 	'1973-07-11', 77000.00),
('Velma', 'Dinkley', 	'Velma@example.com', 	'1973-07-21', 82000.00),
('Daphne', 'Blake', 	'Daphne@example.com', 	'1973-07-30', 59000.00),
('Bugs', 'Bunny', 		'Bugs@example.com', 	'1934-07-01', 18000.00),
('Daffy', 'Duck', 		'Daffy@example.com', 	'1935-04-01', 16000.00),
('Porky', 'Pig', 		'Porky@example.com', 	'1935-08-12', 16550.00),
('Elmer', 'Fudd', 		'Elmer@example.com', 	'1934-08-01', 15500.00),
('Marvin', 'Martian', 	'Marvin@example.com', 	'1937-05-01', 28000.00);

INSERT INTO payroll (payID, pay_date, empid, earnings, fed_tax, fed_med, fed_SS, state_tax, retire_401k, health_care)
SELECT 
	1,
	'2023-11-30', 
	empid, 
	salary/52.0, 
	(salary/52.0)*0.32, 
	(salary/52.0)*0.0145,
	(salary/52.0)*0.062,
	(salary/52.0)*0.12,
	(salary/52.0)*0.004,
	(salary/52.0)*0.031
FROM employees;

INSERT INTO payroll (payID, pay_date, empid, earnings, fed_tax, fed_med, fed_SS, state_tax, retire_401k, health_care)
SELECT 
	2,
	'2023-12-31', 
	empid, 
	salary/52.0, 
	(salary/52.0)*0.32, 
	(salary/52.0)*0.0145, 
	(salary/52.0)*0.062,
	(salary/52.0)*0.12,
	(salary/52.0)*0.004,
	(salary/52.0)*0.031 
FROM employees;

INSERT INTO employee_division (empid, div_ID)
VALUES(1,999),
      (2,999),
      (3,999),
      (7,1),
      (10,1);

INSERT INTO division (ID, Name, city, addressLine1, addressLine2, state, country, postalCode) 
VALUES(1,'Technology Engineering', 'Atlanta', '200 17th Street NW', '', 'GA', 'USA', '30363'),
		(2,'Marketing', 'Atlanta', '200 17th Street NW', '', 'GA', 'USA', '30363'),
		(3,'Human Resources','New York', '45 West 57th Street', '', 'NY', 'USA', '00034'),
		(999,'HQ','New York', '45 West 57th Street', '', 'NY', 'USA', '00034');
			
INSERT INTO employee_job_titles (empid, job_title_id)
VALUES(1,902),
(2,900),
(3,901),
(4,102),
(5,101),
(6,201),
(7,100),
(8,102),
(9,102),
(10,102),
(11,200),
(12,201),
(13,202),
(14,103),
(15, 103);



