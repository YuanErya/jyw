
CREATE DATABASE IF NOT EXISTS jyw;
USE jyw;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `job_guide`;
CREATE TABLE `job_guide`  (
                            `id` int UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '就业指导id',
                            `type` int NOT NULL COMMENT '类型',
                            `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '标题',
                            `content` varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容',
                            `create_time` datetime NOT NULL COMMENT '发布时间',
                            PRIMARY KEY (`id`) USING BTREE,
                            INDEX `title`(`title`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '就业指导表' ROW_FORMAT = DYNAMIC;

INSERT INTO `job_guide` VALUES (1,2000,'就业直通车第51期','测试内容1','2020-01-02 19:06:51');
INSERT INTO `job_guide` VALUES (2,2000,'就业直通车第50期','测试内容2','2019-04-29 19:54:23');
INSERT INTO `job_guide` VALUES (3,2000,'就业直通车第49期','测试内容3','2019-01-01 14:53:04');
INSERT INTO `job_guide` VALUES (4,2000,'就业直通车第48期','测试内容4','2018-06-21 08:05:43');



DROP TABLE IF EXISTS `workplace_activity`;
CREATE TABLE `workplace_activity`  (
                            `id` int UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '职场活动id',
                            `type` int NOT NULL COMMENT '类型',
                            `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '标题',
                            `content` varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容',
                            `create_time` datetime NOT NULL COMMENT '发布时间',
                            PRIMARY KEY (`id`) USING BTREE,
                            INDEX `title`(`title`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '职场活动表' ROW_FORMAT = DYNAMIC;

INSERT INTO `workplace_activity` VALUES (1,4000,'重庆邮电大学“走进职场”系列讲座（总第76期）——面试礼仪讲座','测试内容1','2019-05-16 10:46:57');
INSERT INTO `workplace_activity` VALUES (2,4000,'重庆邮电大学“走进职场”系列讲座（总第75期）——无领导小组面试技巧讲座','测试内容2','2019-05-10 19:21:35');
INSERT INTO `workplace_activity` VALUES (3,4000,'重庆邮电大学“走进职场”系列讲座（总第74期）——简历撰写技巧讲座','测试内容3','2019-04-30 11:35:47');
INSERT INTO `workplace_activity` VALUES (4,4000,'重庆邮电大学“走进职场”系列讲座（总第73期）——公务员（选调生）考试备考讲座','测试内容4','2019-03-19 16:08:14');



DROP TABLE IF EXISTS `news_trends`;
CREATE TABLE `news_trends`  (
                            `id` int UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '新闻动态id',
                            `type` int NOT NULL COMMENT '类型',
                            `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '标题',
                            `content` varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容',
                            `create_time` datetime NOT NULL COMMENT '发布时间',
                            PRIMARY KEY (`id`) USING BTREE,
                            INDEX `title`(`title`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '新闻动态表' ROW_FORMAT = DYNAMIC;

INSERT INTO `news_trends` VALUES (1,5000,'重庆邮电大学第76期“走进职场”系列讲座——面试礼仪专场讲座成功举办','测试内容1','2019-05-23 17:37:32');
INSERT INTO `news_trends` VALUES (2,5000,'重庆邮电大学2019年就业服务月系列活动开幕式顺利举行','测试内容2','2019-05-10 19:20:17');
INSERT INTO `news_trends` VALUES (3,5000,'重庆邮电大学第74期“走进职场”系列讲座——简历撰写技巧讲座成功举办','测试内容3','2019-05-09 17:59:33');
INSERT INTO `news_trends` VALUES (4,5000,'重庆邮电大学第73期“走进职场”系列讲座——公务员（选调生）考试备考讲座成功举办','测试内容4','2019-03-26 08:59:11');