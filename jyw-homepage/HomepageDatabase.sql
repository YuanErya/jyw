CREATE DATABASE IF NOT EXISTS jyw;
USE jyw;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `recruitment`;
CREATE TABLE `recruitment`  (
                            `id` int UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '招聘id',
                            `type` int NOT NULL COMMENT '类型',
                            `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '标题',
                            `content` varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容',
                            `create_time` datetime NOT NULL COMMENT '发布时间',
                            PRIMARY KEY (`id`) USING BTREE,
                            INDEX `title`(`title`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '招聘实习表' ROW_FORMAT = DYNAMIC;

INSERT INTO `recruitment` VALUES (1,1001,'招聘岗位1','测试内容1','2020-01-02 19:06:51');
INSERT INTO `recruitment` VALUES (2,1003,'实习岗位1','测试内容2','2019-04-29 19:54:23');
INSERT INTO `recruitment` VALUES (3,1001,'招聘岗位2','测试内容3','2019-01-01 14:53:04');
INSERT INTO `recruitment` VALUES (4,1001,'招聘岗位3','测试内容4','2018-06-21 08:05:43');


DROP TABLE IF EXISTS `speech`;
CREATE TABLE `speech`  (
                            `id` int UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '宣讲会id',
                            `type` int NOT NULL COMMENT '类型',
                            `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '标题',
                            `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '地址',
                            `start_date` datetime NOT NULL COMMENT '开始日期',
                            `start_time` datetime NOT NULL COMMENT '开始时间',
                            `end_time` datetime NOT NULL COMMENT '结束时间',
                            `content` varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容',
                            `create_time` datetime NOT NULL COMMENT '发布时间',
                            PRIMARY KEY (`id`) USING BTREE,
                            INDEX `title`(`title`) USING BTREE,
                            INDEX `create_time`(`create_time`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '宣讲会表' ROW_FORMAT = DYNAMIC;

INSERT INTO `speech` VALUES (1,10021,'极氪汽车（宁波杭州湾新区）有限公司2022届春季校园招聘宣讲会','老图书馆学术报告厅','2022-10-13 19:00:00','2022-10-13 19:00:00','2022-10-13 21:00:00','测试内容1','2022-01-02 19:06:51');
INSERT INTO `speech` VALUES (2,10021,'xxxxx宣讲会','xxxx学术报告厅','2022-12-25 19:00:00','2022-12-25 19:00:00','2022-12-25 21:00:00','测试内容2','2022-07-05 19:06:51');
INSERT INTO `speech` VALUES (3,10022,'测试宣讲会1','测试内容3','2022-10-12 19:00:00','2022-10-12 19:00:00','2022-10-12 21:00:00','测试内容2','2022-09-05 19:06:51');
INSERT INTO `speech` VALUES (4,10022,'测试宣讲会2','测试内容4','2022-11-23 19:00:00','2022-11-23 19:00:00','2022-11-23 21:00:00','测试内容2','2022-08-05 19:06:51');
