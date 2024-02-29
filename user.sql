-- Active: 1702599767360@@127.0.0.1@3306@board

create user `brand13`@`localhost` IDENTIFIED by 'kind0314';

grant all on `board`.* to `brand13`@`localhost` with grant OPTION;

show grants for `brand13`@`localhost`;

create user `brand13`@`211.45.170.81` IDENTIFIED by 'kind0314';

grant all on `board`.* to `brand13`@`211.45.170.81` with grant OPTION;

show grants for `brand13`@`211.45.170.81`;
