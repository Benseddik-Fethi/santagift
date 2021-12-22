INSERT INTO pere_noel(nom,prenom)
VALUES ('Dupont','Jean'),
       ('Perez','Juan'),
       ('Dupont','Paul'),
       ('Dupont','Pierre'),
       ('Dupont','Jacques');

INSERT INTO cadeau(nom_cadeau,url_cadeau,image_cadeau)
VALUES ('Cadeau 1','http://www.google.fr','http://www.google.fr/images/logo.png'),
       ('Cadeau 2','http://www.google.fr','http://www.google.fr/images/logo.png'),
       ('Cadeau 3','http://www.google.fr','http://www.google.fr/images/logo.png'),
       ('Cadeau 4','http://www.google.fr','http://www.google.fr/images/logo.png'),
       ('Cadeau 5','http://www.google.fr','http://www.google.fr/images/logo.png');


INSERT INTO enfant(nom, prenom)
VALUES ('test', 'test'),
       ('test2', 'test2'),
       ('test3', 'test3');

INSERT INTO enfant_cadeau_list(enfant_id_enfant, cadeau_list_id_cadeau)
VALUES (1,1),
       (2,2),
       (3,3);

INSERT INTO enfant_souhait_list(enfant_id_enfant, souhait_list_id)
VALUES (1,1),
       (2,2),
       (3,3);
INSERT INTO souhait(status, cadeau_id_cadeau)
VALUES('1',1),
       ('1',2),
       ('1',3);