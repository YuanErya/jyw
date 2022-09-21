DROP DATABASE IF EXISTS jyw;
CREATE DATABASE IF NOT EXISTS jyw;
USE jyw;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `bulletin`;
CREATE TABLE `bulletin`  (
                            `id` int UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '公告id',
                            `type` int NOT NULL COMMENT '公告类型',
                            `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '标题',
                            `content` varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容',
                            `create_time` datetime NOT NULL COMMENT '发布时间',
                            PRIMARY KEY (`id`) USING BTREE,
                            INDEX `title`(`title`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '公告表' ROW_FORMAT = DYNAMIC;

INSERT INTO `bulletin` VALUES (1,3001,'重庆邮电大学2022年秋季学期用人单位线下校园招聘服务安排','测试内容1','2022-09-20 09:45:44');
INSERT INTO `bulletin` VALUES (2,3002,'2019年大学生志愿服务西部计划招募公告','测试内容2','2019-05-13 10:01:27');
INSERT INTO `bulletin` VALUES (3,3002,'重庆邮电大学2019年征兵公告','测试内容3','2019-05-13 09:22:56');
INSERT INTO `bulletin` VALUES (4,3001,'【用人单位邀请函】重庆邮电大学2023届毕业生秋季空中双选会(首场)','测试内容4','2022-09-02 16:31:52');
