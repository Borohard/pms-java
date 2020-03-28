INSERT INTO pms_api.claim_position_types VALUES (1, 'Прямые расходы');
INSERT INTO pms_api.claim_position_types VALUES (2, 'Корпоративные расходы');

INSERT INTO pms_api.roles VALUES (1, 'Администратор');
INSERT INTO pms_api.roles VALUES (2, 'Сотрудник');

INSERT INTO pms_api.departments VALUES (1, 'Департамент информационных систем', null);
INSERT INTO pms_api.departments VALUES (2, 'Департамент ведомственных систем', null);

INSERT INTO pms_api.users VALUES (1, 'admin', MD5('123'), 1, 1,'Иван Иванов');
INSERT INTO pms_api.users VALUES (2, 'sunnybs', MD5('123'), 2, 2, 'Александр Нохрин');