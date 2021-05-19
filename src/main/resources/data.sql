INSERT INTO user (id, username, password)
VALUES ('1', 'jose', '$2a$10$M3tkPMmMBLMlcN.B.azyNukKKXAehBfcGNzHDjV6EBb1sV5L3cOXS');
INSERT INTO authority (id, name, user_id)
VALUES ('1', 'user', '1');

INSERT INTO user (id, username, password)
VALUES ('2', 'lukas', '$2a$10$M3tkPMmMBLMlcN.B.azyNukKKXAehBfcGNzHDjV6EBb1sV5L3cOXS');
INSERT INTO authority (id, name, user_id)
VALUES ('2', 'admin', '2');

INSERT INTO client
    (id, client_id, secret, scope, rediect_uri)
VALUES ('1', 'myClientId', '$2a$10$FpN62/zdCUvyRvyE47s5yOsFESxIzrXnjvJB75uHnDvXu5AWItY4a', 'read', 'http://localhost/profile');
INSERT INTO client_grant_types
    (id, client_id, grant_type)
VALUES ('1', '1', 'password');


INSERT INTO client
(id, client_id, secret, scope, rediect_uri)
VALUES ('2', 'advicegenerator', '$2a$10$FpN62/zdCUvyRvyE47s5yOsFESxIzrXnjvJB75uHnDvXu5AWItY4a', 'advice', 'http://localhost/profile');
INSERT INTO client_grant_types
(id, client_id, grant_type)
VALUES ('2', '2', 'client_credentials');