INSERT INTO user (id, username, password)
VALUES ('1', 'jose', 'password');
INSERT INTO authority (id, name, user_id)
VALUES ('1', 'READ', '1');

INSERT INTO client
    (id, client_id, secret, scope, rediect_uri)
VALUES ('1', 'myClientId', 'mySecret', 'read', 'http://localhost/profile');
INSERT INTO client_grant_types
    (id, client_id, grant_type)
VALUES ('1', '1', 'password');