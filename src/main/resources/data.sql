INSERT INTO `article` (`author`, `content`, `date`, `picture_path`, `publish_state`, `title`) VALUES ('Thomas Wild', NULL, '2020-01-30', 'img/art-circus-inside.jpg', 1, 'Notre nouveau spectacle');
INSERT INTO `article` (`author`, `content`, `date`, `picture_path`, `publish_state`, `title`) VALUES ('Thomas Wild', NULL, '2019-11-10', 'img/art-dance.jpg', 1, 'Des artistes réunionnais');
INSERT INTO `article` (`author`, `content`, `date`, `picture_path`, `publish_state`, `title`) VALUES ('Jade Wild', NULL, '2019-11-5', 'img/art-mongol.jpg', 1, 'Des éleveurs mongols');


UPDATE `article`
SET content = 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.' WHERE 1 = 1;
