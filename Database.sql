-- ------------------------------------------------------------------------------
-- - Reconstruction de la base de données                                     ---
-- ------------------------------------------------------------------------------
DROP DATABASE IF EXISTS WebStore;
CREATE DATABASE WebStore;
USE WebStore;

-- -----------------------------------------------------------------------------
-- - Construction de la table des utilisateurs                               ---
-- -----------------------------------------------------------------------------

CREATE TABLE T_Users (
    idUser              int         PRIMARY KEY AUTO_INCREMENT,
    login               varchar(20) NOT NULL,
    password            varchar(20) NOT NULL,
    connectionNumber    int         NOT NULL DEFAULT 0
);

INSERT INTO T_Users (login, password) 
VALUES ( 'Anderson',    'Neo' ),
       ( 'Skywalker',   'Luke' ),
       ( 'Plissken',    'Snake' ),
       ( 'Ripley',      'Ellen' ),
       ( 'Bond',        'James' );

SELECT * FROM T_Users;


-- -----------------------------------------------------------------------------
-- - Construction de la table des informations utilisateurs                  ---
-- -----------------------------------------------------------------------------

CREATE TABLE T_UserInformations (
    idInformations      int    PRIMARY KEY AUTO_INCREMENT,
    address             text,
    city                text,
    email               text,
    phoneNumber         text,
    idUser  			int    UNIQUE NOT NULL REFERENCES T_Users(idUser)
);

INSERT INTO T_UserInformations (address, city, email, phoneNumber, idUser) 
VALUES ( 'Inconnue', 'La matrice', 'neo@matrix.com', '1234567890', 1 ),
       ( 'rue du Faucon', 'L''étoile noire', 'luke@glaforce.wars', '0147258369', 2 ),
       ( '1997, Manhattan', 'New York', 'snake@carpenter.com', '9638527410', 3 ),
       ( 'Nostromo', 'La bas', 'ripley@nostromo.alien', '9876543210', 4 ),
       ( 'SIS Building', 'London', '007@mi6.uk', '7007007007', 5 );

SELECT * FROM T_UserInformations;

-- -----------------------------------------------------------------------------
-- - Construction de la table des rôles                                      ---
-- -----------------------------------------------------------------------------

CREATE TABLE T_Roles (
    idRole       int         PRIMARY KEY AUTO_INCREMENT,
    roleName     varchar(20) NOT NULL
);

INSERT INTO T_Roles (roleName)
VALUES ('client'), ('admin'), ('stockManager');

SELECT * FROM T_Roles;

-- -----------------------------------------------------------------------------
-- - Construction de la table d'association T_Users/T_Roles                  ---
-- -----------------------------------------------------------------------------

CREATE TABLE T_Users_Roles_Associations (
    idUser   int     NOT NULL REFERENCES T_Users(idUser),
    idRole   int     NOT NULL REFERENCES T_Roles(idRole)
);

INSERT INTO T_Users_Roles_Associations VALUES (1, 2), (1, 3), (1, 2), (4, 1), (5, 1);

SELECT * FROM T_Users_Roles_Associations;

-- -----------------------------------------------------------------------------
-- - Construction de la tables des articles en vente                         ---
-- -----------------------------------------------------------------------------
CREATE TABLE T_Articles (
    idArticle           int         PRIMARY KEY AUTO_INCREMENT,
    description         varchar(30) NOT NULL,
    brand               varchar(30) NOT NULL,
    unitaryPrice        double      NOT NULL
);

INSERT INTO T_Articles ( description, brand, unitaryPrice ) VALUES ( 'Souris',                  'Logitoch',             65 );
INSERT INTO T_Articles ( description, brand, unitaryPrice ) VALUES ( 'Clavier',                 'Microhard',            49.5 );
INSERT INTO T_Articles ( description, brand, unitaryPrice ) VALUES ( 'Systeme d''exploitation', 'Fenetres Vistouille',  150 );
INSERT INTO T_Articles ( description, brand, unitaryPrice ) VALUES ( 'Tapis souris',            'ATP Formation',        5 );
INSERT INTO T_Articles ( description, brand, unitaryPrice ) VALUES ( 'Cle USB 8 To',            'Syno',                 8 );
INSERT INTO T_Articles ( description, brand, unitaryPrice ) VALUES ( 'Laptop',                  'PH',                   1199 );
INSERT INTO T_Articles ( description, brand, unitaryPrice ) VALUES ( 'CD x 500',                'CETME',                250 );
INSERT INTO T_Articles ( description, brand, unitaryPrice ) VALUES ( 'DVD-R x 100',             'CETME',                99 );
INSERT INTO T_Articles ( description, brand, unitaryPrice ) VALUES ( 'DVD+R x 100',             'CETME',                105 );
INSERT INTO T_Articles ( description, brand, unitaryPrice ) VALUES ( 'Batterie Laptop',         'PH',                   80 );
INSERT INTO T_Articles ( description, brand, unitaryPrice ) VALUES ( 'Casque Audio',            'Syno',                 105 );
INSERT INTO T_Articles ( description, brand, unitaryPrice ) VALUES ( 'WebCam',                  'Logitoch',             755 );

SELECT * FROM T_Articles;

-- -----------------------------------------------------------------------------
-- - Construction de la table des commandes                                 ---
-- -----------------------------------------------------------------------------

CREATE TABLE T_Commands (
    idCommand       int         PRIMARY KEY AUTO_INCREMENT,
    idUser          int         NOT NULL REFERENCES T_Users(idUser),
    commandDate     datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO T_Commands (idUser)
VALUES (1), (2), (1);

SELECT * FROM T_Commands;



-- -----------------------------------------------------------------------------
-- - Construction de la table des paiements paypal                           ---
-- -----------------------------------------------------------------------------

CREATE TABLE T_PaypalPayments (
    idPayment           int          PRIMARY KEY,
    amount              double       NOT NULL,
    paymentDate         datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    accountNumber       varchar(30)
);

INSERT INTO T_PaypalPayments VALUES ( 1, 1295, now(), 'A fake paypal account' );

SELECT * FROM T_PaypalPayments;

-- -----------------------------------------------------------------------------
-- - Construction de la table des paiements par cartes bleues                ---
-- -----------------------------------------------------------------------------

CREATE TABLE T_CreditCardPayments (
    idPayment           int          PRIMARY KEY,
    amount              float        NOT NULL,
    paymentDate         datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    cardNumber          char(24),
    expirationDate      varchar(5)
);

INSERT INTO T_CreditCardPayments VALUES ( 2, 245, now(), '1234 5678 9012 3456', '06/19' );

SELECT * FROM T_CreditCardPayments;