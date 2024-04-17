CREATE TABLE WASTE_MANAGER(
    ID BIGINT NOT NULL  AUTO_INCREMENT,
    NOMBRE VARCHAR(100) NOT NULL,
    NIF VARCHAR(100) NOT NULL,
    IS_ENABLED BOOLEAN DEFAULT (TRUE),
    VERSION BIGINT DEFAULT (0),
    CREATED_DATE DATETIME DEFAULT (NOW()),
    LAST_MODIFIED_DATE DATETIME,
    PRIMARY KEY (ID)
);



CREATE TABLE WASTE_CENTER_AUTHORIZATION(
    ID BIGINT NOT NULL  AUTO_INCREMENT,
    AUTHORIZATION_NUMBER VARCHAR(100) NOT NULL,
    WASTE_MANAGER_ID BIGINT NOT NULL,
    PRIMARY KEY (ID),
    CONSTRAINT CENTER_AUTHORIZATION_WASTE_MANAGER_FK FOREIGN KEY (WASTE_MANAGER_ID) REFERENCES WASTE_MANAGER
);