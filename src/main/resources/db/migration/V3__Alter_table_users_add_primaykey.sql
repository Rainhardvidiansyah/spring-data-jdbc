ALTER TABLE users
ADD PRIMARY KEY (id),
MODIFY email VARCHAR(255) NOT NULL,
MODIFY password VARCHAR(255) NOT NULL;