INSERT INTO user (id, username, password) VALUES ('1', 'john', '555');
INSERT INTO authority (id, name, user) VALUES ('1', 'READ', '1');

INSERT INTO oauth_client_details
(client_id, client_secret, scope, authorized_grant_types,
 web_server_redirect_uri, authorities, access_token_validity,
 refresh_token_validity, additional_information, autoapprove)
VALUES
('myClientId', 'mySecret', 'foo,read,write',
    'password,authorization_code,refresh_token', null, null, 36000, 36000, null, true);