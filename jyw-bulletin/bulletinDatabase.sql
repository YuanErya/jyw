DROP DATABASE IF EXISTS jyw;
CREATE DATABASE IF NOT EXISTS jyw;
USE jyw;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `bulletin`;
CREATE TABLE `bulletin`  (
                            `id` int UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '公告id',
                            `type` int NOT NULL COMMENT '公告类型',
                            `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '标题',
                            `content` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容',
                            `create_time` datetime NOT NULL COMMENT '发布时间',
                            PRIMARY KEY (`id`) USING BTREE,
                            INDEX `title`(`title`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '公告表' ROW_FORMAT = DYNAMIC;

INSERT INTO `bulletin` VALUES (1,0,'测试标题1','测试内容1','2022-09-20 15:25:59');
INSERT INTO `bulletin` VALUES (2,1,'测试标题2','测试内容2','2022-09-20 15:29:48');
INSERT INTO `bulletin` VALUES (3,1,'测试标题3','测试内容3','2022-09-20 16:33:34');
INSERT INTO `bulletin` VALUES (4,0,'测试标题4','测试内容4','2022-09-20 17:27:38');
