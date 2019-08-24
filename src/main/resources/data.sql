DROP TABLE IF EXISTS parent_table;
DROP TABLE IF EXISTS child_table;

CREATE TABLE parent_table (
  id VARCHAR(255) PRIMARY KEY,
  ssn VARCHAR(10) NOT NULL,
  attr VARCHAR(250) NOT NULL,
  
);

CREATE TABLE child_table (
  cid VARCHAR(255) PRIMARY KEY,
  id VARCHAR(255) NOT NULL,
  cattr VARCHAR(10) NOT NULL,
  foreign key (id) references parent_table(id)
);
 
INSERT INTO parent_table (id, ssn, attr) VALUES
  ('1', '123456789', 'Y'),
  ('2', '987654321', 'N'),
  ('3', '987651234', 'Y');

INSERT INTO child_table (cid, id, cattr) VALUES
  ('100', '1', 'AZ'),
  ('101', '1', 'KT'),
  ('102', '2', 'NY'),
  ('103', '3', 'AL');
  
