CREATE TABLE `room` (
  `id`      BIGINT      NOT NULL,
  `name`    VARCHAR(45) NOT NULL,
  `seats`   INT         NOT NULL,
  `active`  TINYINT     NOT NULL,
  PRIMARY KEY (`id`));