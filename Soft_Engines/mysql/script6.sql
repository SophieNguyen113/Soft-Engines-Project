/* 
    Script 6:

    2.0. DATABASE SCHEMA DIAGRAM
      d. Create a benefits table to store information about the company's employee benefits
*/


use employeedata;

CREATE TABLE employee_benefits (
  empid INT NOT NULL,
  benefit_id INT NOT NULL,
  enroll_date date,
  termination_date date,
  PRIMARY KEY (empid),
  INDEX benefit_IDX (benefit_id),
  FOREIGN KEY (empid) REFERENCES employees(empid)
);

CREATE TABLE benefits (
  benefit_id INT,
  benefit_name VARCHAR(125) NOT NULL,
  benefit_type VARCHAR(125) not null,
  benefit_cost DECIMAL(8,2) not null,
  benefit_coverage DECIMAL(8,2) not null,
  PRIMARY KEY (benefit_id),
  FOREIGN KEY (benefit_id) REFERENCES employee_benefits(benefit_id)
);