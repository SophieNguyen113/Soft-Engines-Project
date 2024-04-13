/* 
    Script 3: Deliverable item 1
*/


USE employeeData;

CREATE TABLE address (
  empid INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  gender VARCHAR(65) NOT NULL,
  pronouns VARCHAR(65) NOT NULL,
  IdentifiedRace VARCHAR(65) NOT NULL,
  DOB DATE,
  phone INT NOT NULL,
  city_id INT NOT NULL,
  state_id INT NOT NULL,
  FOREIGN KEY (empid) REFERENCES employees(empid),
  INDEX (city_id),
  INDEX (state_id)
);

CREATE TABLE city (
  city_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  city_name VARCHAR(65)
);

CREATE TABLE state (
  state_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  state_name VARCHAR(65)
);

ALTER TABLE city
ADD CONSTRAINT fk_address_city FOREIGN KEY (city_id) REFERENCES address(city_id);

ALTER TABLE state
ADD CONSTRAINT fk_address_state FOREIGN KEY (state_id) REFERENCES address(state_id);

ALTER TABLE employees
ADD SSN INT NOT NULL;
