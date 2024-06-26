CREATE TABLE WASTE_MANAGER_ADDRESS(
    ID BIGINT NOT NULL  AUTO_INCREMENT,
    DIRECCION VARCHAR(100) NOT NULL,
    IS_ENABLED BOOLEAN DEFAULT (TRUE),
    VERSION BIGINT DEFAULT (0),
    CREATED_DATE DATETIME DEFAULT (NOW()),
    LAST_MODIFIED_DATE DATETIME,
    WASTE_MANAGER_ID BIGINT NOT NULL UNIQUE,
    PRIMARY KEY (ID)
);