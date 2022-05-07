
INSERT INTO generic.Oauth2ClientEntity (accessTokenValiditySeconds,client,password,refreshTokenValiditySeconds) VALUES
	 (3600,'client_id','Y2JmY2M3NGItMDdjZC00YWJiLTkwNmItYWJkZGQ4ZmExYmVj',7200);
	

INSERT INTO generic.RoleEntity (description,name) VALUES
	 ('Admin Role','ROLE_ADMIN'),
	 ('User Role','ROLE_USER'),
	 ('Operator Role','ROLE_OPERATOR'),
	 ('Tester Role','ROLE_TESTER'),
	 ('Sys Role','ROLE_SYS'),
	 ('Moderator Role','ROLE_MODERATOR'),
	 ('Client Role','ROLE_CLIENT');


INSERT INTO generic.OperatorEntity (password,`role`,username) VALUES
	 ('1234567890',1,'OAUTH2DEMO_ADMIN'),
	 ('1234567890',2,'OAUTH2DEMO_USER'),
	 ('1234567890',7,'OAUTH2DEMO_CLIENT');


