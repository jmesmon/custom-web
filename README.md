# custom-web
ALTER TABLE `t_notice`
	ADD COLUMN `process_link` VARCHAR(128) NULL DEFAULT NULL AFTER `notice_type`;