DROP TABLE IF EXISTS CURRENCY_NAME_INFO;

CREATE TABLE CURRENCY_NAME_INFO
(
	CURRENCY_ID VARCHAR2(20),
	CURRENCY_NAME VARCHAR2(50),
	PRIMARY KEY(CURRENCY_ID)
);