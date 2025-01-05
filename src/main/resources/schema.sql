DROP TABLE if EXISTS employee;
CREATE TABLE if NOT EXISTS employee
(
    id
    serial
    PRIMARY
    KEY,
    NAME
    VARCHAR
(
    255
) NOT NULL,
    department VARCHAR
(
    48
) NOT NULL,
    salary INTEGER
    );
