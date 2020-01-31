/*ARTICLE*/
INSERT INTO `article` (`author`, `content`, `date`, `picture_path`, `publish_state`, `title`) VALUES ('Thomas Wild', NULL, '2020-01-30', 'img/art-circus-inside.jpg', 1, 'Notre nouveau spectacle');
INSERT INTO `article` (`author`, `content`, `date`, `picture_path`, `publish_state`, `title`) VALUES ('Thomas Wild', NULL, '2019-11-10', 'img/art-dance.jpg', 1, 'Des artistes réunionnais');
INSERT INTO `article` (`author`, `content`, `date`, `picture_path`, `publish_state`, `title`) VALUES ('Jade Wild', NULL, '2019-11-5', 'img/art-mongol.jpg', 1, 'Des éleveurs mongols');

UPDATE `article`
SET content = 'At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat.' WHERE 1 = 1;

/*COMMENT*/
INSERT INTO `comment` (`author`, `content`, `date`, `email`, `article_id`) VALUES ('Jean', 'De toute beauté !', '2020-01-30', 'jean@hotmail.fr', '1');
INSERT INTO `comment` (`author`, `content`, `date`, `email`, `article_id`) VALUES ('Aymeric', 'Bof, ils avaient pas de technique, ils y allaient à la zob', '2020-01-30', 'aymeric@hotmail.fr', '1');

/*GALLERY_PICTURE*/
INSERT INTO `gallery_picture` (`date`, `description`, `name`, `picture_path`) VALUES 
	('2020-01-30', 'Kapi, notre tigre du Bengale', 'Kapi', 'img/g-tigre.jpg'),
	('2020-01-30', 'De grands espaces pour nos éléphants', 'Basil et Tha', 'img/g-elephants.jpg'),
	('2020-01-30', 'Le spectable le plus drôle', 'Clown', 'img/g-clown.jpg'),
	('2020-01-30', 'Le parc de nos chevaux', 'Nos chevaux', 'img/g-horses.jpg'),
	('2020-01-30', NULL, 'Cirque', 'img/g-circus-outside.jpg'),
	('2020-01-30', NULL, 'Singe', 'img/g-monkey.jpg'),
	('2020-01-30', NULL, 'Parapluie', 'img/g-umbrella.jpg'),
	('2020-01-30', NULL, 'Ours', 'img/g-bear.jpg'),
	('2020-01-30', NULL, 'Lions', 'img/g-lions.jpg'),
	('2020-01-30', NULL, 'Chevaux', 'img/g-horses2.jpg'),
	('2020-01-30', NULL, 'Lions blancs', 'img/g-white-lions.jpg'),
	('2020-01-30', NULL, 'Spectacle', 'img/g-circus.jpg');

UPDATE `gallery_picture`
SET description = 'At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident.' WHERE 1 = 1;


