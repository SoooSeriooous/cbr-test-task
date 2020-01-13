create table if not exists author
(
    id number auto_increment,
    name varchar(250) not null,
    surname varchar(250) not null,
    birth_date date,
    constraint author_pk
        primary key (id)
);

create table if not exists BOOK
(
    ID               NUMBER auto_increment,
    NAME             VARCHAR(250) not null,
    AUTHOR_ID        NUMBER       not null,
    PUBLICATION_DATE DATE,
    constraint BOOK_PK
        primary key (ID),
    constraint BOOK_AUTHOR_ID_FK
        foreign key (AUTHOR_ID) references AUTHOR (ID)
);

INSERT INTO AUTHOR (ID, NAME, SURNAME, BIRTH_DATE) VALUES (1,'Александр', 'Пушкин', '1799-06-06');
INSERT INTO AUTHOR (ID, NAME, SURNAME, BIRTH_DATE) VALUES (2, 'Михаил', 'Лермонтов', '1814-10-15');

INSERT INTO BOOK (ID, NAME, AUTHOR_ID, PUBLICATION_DATE) VALUES (1, 'Евгений Онегин', 1, '2012-06-01');
INSERT INTO BOOK (ID, NAME, AUTHOR_ID, PUBLICATION_DATE) VALUES (2, 'Мцыри', 2, '2016-05-09');



