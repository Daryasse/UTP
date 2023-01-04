-- DROP SEQUENCE USERS_SEQ;
-- DROP SEQUENCE GROUPS_SEQ;
-- DROP SEQUENCE USERS_GROUPS_SEQ;
--
-- DROP TABLE USERS_GROUPS;
-- DROP TABLE USERS;
-- DROP TABLE GROUPS;

CREATE TABLE USERS
(
    USER_ID INTEGER NOT NULL
    , USER_LOGIN VARCHAR(20) NOT NULL
    , USER_PASSWORD VARCHAR(20) NOT NULL

    , CONSTRAINT USERS_PK PRIMARY KEY(USER_ID)
);
CREATE SEQUENCE USERS_SEQ;


CREATE TABLE GROUPS
(
    GROUP_ID INTEGER NOT NULL
    , GROUP_NAME VARCHAR(20) NOT NULL
    , GROUP_DESCRIPTION VARCHAR(255) NOT NULL

    , CONSTRAINT GROUPS_PK PRIMARY KEY(GROUP_ID)
);
CREATE SEQUENCE GROUPS_SEQ;


CREATE TABLE USERS_GROUPS
(
    USER_GROUP_ID INTEGER NOT NULL
    , USER_ID INTEGER NOT NULL
    , GROUP_ID INTEGER NOT NULL

    , CONSTRAINT USERS_GROUPS_PK PRIMARY KEY(USER_GROUP_ID)
    , CONSTRAINT USERS_GROUPS_USERS_FK FOREIGN KEY(USER_ID) REFERENCES USERS(USER_ID)
    , CONSTRAINT USERS_GROUPS_GROUPS_FK FOREIGN KEY(GROUP_ID) REFERENCES GROUPS(GROUP_ID)
);
CREATE SEQUENCE USERS_GROUPS_SEQ;