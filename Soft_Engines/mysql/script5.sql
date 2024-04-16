/* 
    Script 5:

    2.0. DATABASE SCHEMA DIAGRAM
      c. Create a part-time employee payroll table to track hourly wage and taxes, but no 401K or health care cost
*/


use employeedata;

CREATE TABLE parttime_payroll (
  payID INT,
  pay_date DATE,
  hourly_wage DECIMAL(8,2),
  fed_tax DECIMAL(7,2),
  fed_med DECIMAL(7,2),
  fed_SS DECIMAL(7,2),
  state_tax DECIMAL(7,2),
  empid INT,
  INDEX payID_IDX (payID),
  INDEX emp_indx (empid),
  FOREIGN KEY (empid) REFERENCES employees(empid)
);

rename table payroll to salary_payroll;