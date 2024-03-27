/* 
    THESE ARE FOR dBeaver usage, Not VS Code...
    Otherwise your system may give you unpredictable results. 	
*/


CREATE DATABASE employeeData;
USE employeeData;

/***********************************************************************/

CREATE TABLE employees (
  empid INT NOT NULL AUTO_INCREMENT,
  Fname VARCHAR(65) NOT NULL,
  Lname VARCHAR(65) NOT NULL,
  email VARCHAR(65) NOT NULL,
  HireDate DATE,
  Salary DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (empid)
);

/***********************************************************************/

CREATE TABLE payroll (
  payID INT,
  pay_date DATE,
  earnings DECIMAL(8,2),
  fed_tax DECIMAL(7,2),
  fed_med DECIMAL(7,2),
  fed_SS DECIMAL(7,2),
  state_tax DECIMAL(7,2),
  retire_401k DECIMAL(7,2),
  health_care DECIMAL(7,2),
  empid INT,
  INDEX payID_IDX (payID),
  INDEX emp_indx (empid),
  FOREIGN KEY (empid) REFERENCES employees(empid)
);

/***********************************************************************/ 

CREATE TABLE employee_job_titles (
  empid INT NOT NULL,
  job_title_id INT NOT NULL,
  PRIMARY KEY (empid),
  INDEX job_title_IDX (job_title_id),
  FOREIGN KEY (empid) REFERENCES employees(empid)
);

/***********************************************************************/ 

CREATE TABLE job_titles (
  job_title_id INT,
  job_title VARCHAR(125) NOT NULL,
  PRIMARY KEY (job_title_id),
  FOREIGN KEY (job_title_id) REFERENCES employee_job_titles(job_title_id)
);

/***********************************************************************/ 

CREATE TABLE employee_division (
  empid int NOT NULL,
  div_ID int NOT NULL,
  PRIMARY KEY (empid),
  INDEX div_ID_IDX (div_ID),
  FOREIGN KEY (empid) REFERENCES employees(empid)
) COMMENT='links employee to a division';

/***********************************************************************/


CREATE TABLE division (
  ID int NOT NULL,
  Name varchar(100) DEFAULT NULL,
  city varchar(50) NOT NULL,
  addressLine1 varchar(50) NOT NULL,
  addressLine2 varchar(50) DEFAULT NULL,
  state varchar(50) DEFAULT NULL,
  country varchar(50) NOT NULL,
  postalCode varchar(15) NOT NULL,
  INDEX ID_IDX (ID),
  FOREIGN KEY (ID) REFERENCES employee_division(div_ID)
) COMMENT='company divisions';

/***********************************************************************/ 
