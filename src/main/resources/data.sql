DROP TABLE IF EXISTS parent_table;
DROP TABLE IF EXISTS child_table;
DROP TABLE IF EXISTS PARENT_TABLE_CHILD_TABLE;

CREATE TABLE parent_table (
  id VARCHAR(255) NOT NULL PRIMARY KEY,
  ssn VARCHAR(10) NOT NULL,
  attr VARCHAR(250) NOT NULL,
  end_date DATE NOT NULL
);

CREATE TABLE child_table (
  cid VARCHAR(255) NOT NULL PRIMARY KEY,
  id VARCHAR(255) NOT NULL,
  cattr VARCHAR(10) NOT NULL,
  end_date DATE NOT NULL,
  foreign key (id) references parent_table(id)
);
 
INSERT INTO parent_table (id, ssn, attr,end_date) VALUES
  ('1', '123456789', 'Y', '9999-12-12'),
  ('2', '987654321', 'N', '9999-12-12'),
  ('3', '987651234', 'Y', '9999-12-12');

INSERT INTO child_table (cid, id, cattr, end_date) VALUES
  ('100', '1', 'AZ', '9999-12-12'),
  ('101', '1', 'KT', '9999-12-12'),
  ('102', '2', 'NY', '9999-12-12'),
  ('103', '3', 'AL', '9999-12-12');
  
