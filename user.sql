-- Active: 1702599767360@@127.0.0.1@3306@board

create user `brand13`@`localhost` IDENTIFIED by 'kind0314';

grant all on `board`.* to `brand13`@`localhost` with grant OPTION;

show grant for `brand13`@`localhost`;

create user `brand13`@`172.27.0.1` IDENTIFIED by 'kind0314';

grant all on `board`.* to `brand13`@`172.27.0.1` with grant OPTION;

show grant for `brand13`@`172.27.0.1`;
