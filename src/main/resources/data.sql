create table if not exists author
(
    id         IDENTITY auto_increment,
    name       varchar(250) not null,
    surname    varchar(250) not null,
    birth_date date,
    constraint author_pk
        primary key (id)
);

create table if not exists BOOK
(
    ID               IDENTITY auto_increment,
    NAME             VARCHAR(250) not null,
    DESCRIPTION      VARCHAR(1000),
    PUBLICATION_DATE DATE,
    constraint BOOK_PK
        primary key (ID)
);

create table if not exists AUTHOR_BOOK
(
    AUTHOR_ID NUMBER not null,
    BOOK_ID   NUMBER not null,
    constraint AUTHOR_BOOK_PK
        primary key (BOOK_ID, AUTHOR_ID),
    constraint AUTHOR_BOOK_AUTHOR_ID_FK
        foreign key (AUTHOR_ID) references AUTHOR (ID),
    constraint AUTHOR_BOOK_BOOK_ID_FK
        foreign key (BOOK_ID) references BOOK (ID)
);

INSERT INTO AUTHOR (NAME, SURNAME, BIRTH_DATE)
VALUES ('Александр', 'Пушкин', '1799-06-06');
INSERT INTO AUTHOR (NAME, SURNAME, BIRTH_DATE)
VALUES ('Михаил', 'Лермонтов', '1814-10-15');

INSERT INTO BOOK (NAME, DESCRIPTION, PUBLICATION_DATE)
VALUES ('Евгений Онегин', 'КЛАССИКА - КЛАССИКА', '2012-06-01');
INSERT INTO BOOK (NAME, DESCRIPTION, PUBLICATION_DATE)
VALUES ('Мцыри', 'ВААЩЕ АГОНЬ', '2016-05-09');
INSERT INTO BOOK (NAME, DESCRIPTION, PUBLICATION_DATE)
VALUES ('Анталогия произведений', 'ШТОЗАФИГНЯ', '2018-04-01');

INSERT INTO AUTHOR_BOOK (AUTHOR_ID, BOOK_ID)
VALUES (1, 1);
INSERT INTO AUTHOR_BOOK (AUTHOR_ID, BOOK_ID)
values (2, 2);
INSERT INTO AUTHOR_BOOK (AUTHOR_ID, BOOK_ID)
values (1, 3);
INSERT INTO AUTHOR_BOOK (AUTHOR_ID, BOOK_ID)
VALUES (2, 3);