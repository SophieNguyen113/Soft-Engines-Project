/* 
    Script 4:

    2.0. DATABASE SCHEMA DIAGRAM
      b. Modify the current payroll to have a health cost of 0.002% of the base salary
*/


USE employeedata;

update payroll 
set health_care = earnings * 0.00002;