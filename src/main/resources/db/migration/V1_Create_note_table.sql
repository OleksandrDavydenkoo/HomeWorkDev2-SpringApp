CREATE TABLE note (
                      id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
                      title VARCHAR(255) NOT NULL,
                      content TEXT
);