INSERT INTO `users` (`username`, `password`)
    VALUE   ('admin', '$2a$12$LVvurJ8q5ZtkaKxKAQQ2d.GrLyhffZgci5dwOgfcEEZ99INJp37EK'),
        ('guest', '$2a$12$LVvurJ8q5ZtkaKxKAQQ2d.GrLyhffZgci5dwOgfcEEZ99INJp37EK');
GO

INSERT INTO `roles` (`name`)
VALUE ('ROLE_ADMIN'), ('ROLE_GUEST');
GO

INSERT INTO `users_roles`(`user_id`, `role_id`)
SELECT (SELECT id FROM `users` WHERE `username` = 'admin'), (SELECT id FROM `roles` WHERE `name` = 'ROLE_ADMIN')
UNION ALL
SELECT (SELECT id FROM `users` WHERE `username` = 'guest'), (SELECT id FROM `roles` WHERE `name` = 'ROLE_GUEST');
GO