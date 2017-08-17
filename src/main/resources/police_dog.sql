DROP TABLE t_dog_base;

CREATE TABLE t_dog_base (
	id int NOT NULL AUTO_INCREMENT COMMENT 'id',
	dog_name varchar(128) COMMENT '犬名',
	chip_no varchar(128) COMMENT '芯片号',
	sex int(2) COMMENT '性别（1：公，2：母）',
	birthday date COMMENT '出生日期',
	breed varchar(64) COMMENT '犬品种',
	dog_source varchar(128) COMMENT '来源',
	dog_colour varchar(16) COMMENT '毛色',
	hair_type varchar(16) COMMENT '毛型',
	dog_type int(2) COMMENT '类型（1：工作犬，2：非工作犬）',
	dog_level int(2) COMMENT '犬种等级（1、2、3）',
	inbreeding varchar(16) COMMENT '近交系数',
	tutor varchar(32) COMMENT '训导员',
	train_score varchar(8) COMMENT '复训成绩（优秀、合格、不合格）',
	next_train_date date COMMENT '下次复训时间（yyyy-mm-dd）',
	work_place varchar(128) COMMENT '工作单位（与人员信息关联自动生成）',
	work_area varchar(128) COMMENT '所属片区',
	work_province varchar(128) COMMENT '省区市',
	file_no varchar(32) COMMENT '警犬档案号',
	create_doc_date date COMMENT '建档日期（YYYY-MM-dd）',
	dog_photo varchar(128) COMMENT '外貌特征（照片）',
	father_id varchar(255) COMMENT '父亲id_爷爷id_祖爷爷id',
	mother_id varchar(255) COMMENT '母亲id_',
	growth_stage int(2) COMMENT '成长阶段（1：幼犬，2：成犬）',
	work_stage int(2) COMMENT '工作状态（1：待申领，2：已被申领，3：被淘汰，4：死亡）',
	belonging varchar(255) COMMENT '淘汰/退休归属',
	creation_date date COMMENT '数据创建日期',
	last_update_date date COMMENT '最后修改日期',
	PRIMARY KEY (id)
) ENGINE = InnoDB CHARSET = utf8;

DROP TABLE t_dog_change;

CREATE TABLE t_dog_change (
	id int NOT NULL AUTO_INCREMENT COMMENT '	id	',
	dog_id int NOT NULL COMMENT '	警犬id	',
	change_date date COMMENT '	变动日期	',
	old_work_place varchar(128) COMMENT '	原工作单位	',
	new_work_place varchar(128) COMMENT '	变动后作单位	',
	old_dog_name varchar(128) COMMENT '	原犬名	',
	new_dog_name varchar(128) COMMENT '	变动后犬名	',
	old_police_id int COMMENT '	原带犬民警id	',
	old_police_name int COMMENT '	原带犬民警姓名	',
	new_police_id int COMMENT '	变动后带犬民警id	',
	new_police_name varchar(128) COMMENT '	变动后带犬民警姓名	',
	old_dog_type varchar(128) COMMENT '	原类别	',
	new_dog_type varchar(128) COMMENT '	变动后类别	',
	change_reason varchar(150) COMMENT '	变动原因	',
	apply_id int COMMENT '	申报人id	',
	apply_name varchar(128) COMMENT '	申报人姓名	',
	approver_id int COMMENT '	审批人id	',
	approver_name varchar(128) COMMENT '	审批人姓名	',
	leader_id int COMMENT '	主管领导	',
	leader_name varchar(128) COMMENT '	主管领导姓名	',
	agent_id int COMMENT '	经办人id	',
	agent_name varchar(128) COMMENT '	经办人姓名	',
	receiver_id int COMMENT '	接收人id	',
	reveiver_name varchar(128) COMMENT '	接收人姓名	',
	other_info varchar(255) COMMENT '	其他信息	',
	change_state int COMMENT '	变动状态：0：完成，1：待申报人处理，2：待审批人处理，3：待主管领导处理，4：待经办人处理，5：待接收人处理	',
	change_type int COMMENT '	变动类别：1：通过，2驳回	',
	approve_logs text COMMENT '	审批明细	',
	creation_date date COMMENT '	创建日期	',
	last_update_date date COMMENT '	最后修改日期	',
	PRIMARY KEY (id)
) ENGINE = InnoDB CHARSET = utf8;

DROP TABLE t_dog_honor;

CREATE TABLE t_dog_honor (
	id int NOT NULL AUTO_INCREMENT COMMENT '	id	',
	honor_no varchar(64) COMMENT '	证件编号	',
	honor_name varchar(32) COMMENT '	奖励名称	',
	reward_unit varchar(128) COMMENT '	颁奖单位	',
	reward_detail varchar(255) COMMENT '	奖励原因	',
	reward_date date COMMENT '	奖励日期	',
	creation_date date,
	last_update_date date,
	PRIMARY KEY (id)
) ENGINE = InnoDB CHARSET = utf8;

DROP TABLE t_dog_pro;

CREATE TABLE t_dog_pro (
	id int NOT NULL AUTO_INCREMENT COMMENT 'id',
	dog_id int COMMENT '警犬ID	',
	prof_id int COMMENT '专业ID	',
	prof_name varchar(16) COMMENT '专业名称',
	PRIMARY KEY (id)
) ENGINE = InnoDB CHARSET = utf8;

DROP TABLE t_dog_pro_base;

CREATE TABLE t_dog_pro_base (
	id int NOT NULL AUTO_INCREMENT COMMENT '	id	',
	prof_name varchar(16) COMMENT '	专业名称	',
	creation_date date,
	last_update_date date,
	PRIMARY KEY (id)
) ENGINE = InnoDB CHARSET = utf8;

DROP TABLE t_dog_work;

CREATE TABLE t_dog_work (
	id int NOT NULL DEFAULT '0' COMMENT '	id	',
	work_start_date date COMMENT '	日期	',
	work_end_time date COMMENT '	时间	',
	work_unit varchar(2) COMMENT '	用犬单位	',
	att_person varchar(255) COMMENT '	出勤人员	',
	dog_id int COMMENT '	警犬id	',
	dog_name varchar(128) COMMENT '	派出警犬	',
	case_property varchar(128) COMMENT '	案件性质	',
	case_no varchar(128) COMMENT '	案件编号	',
	case_level varchar(8) COMMENT '	案件等级	',
	main_task varchar(255) COMMENT '	主要任务	',
	work_result varchar(255) COMMENT '	使用结果	',
	creation_date date,
	last_update_date date,
	PRIMARY KEY (id)
) ENGINE = InnoDB CHARSET = utf8;

DROP TABLE t_police_user;

CREATE TABLE t_police_user (
	id int NOT NULL AUTO_INCREMENT COMMENT '	id	',
	police_id varchar(64) COMMENT '	警号	',
	police_name varchar(16) COMMENT '	姓名	',
	sex varchar(2) COMMENT '	性别	',
	police_photo varchar(128) COMMENT '	照片	',
	national varchar(16) COMMENT '	民族	',
	id_nun varchar(32) COMMENT '	身份证号	',
	birthday varchar(16) COMMENT '	出生日期	',
	on_face varchar(16) COMMENT '	政治面貌	',
	education varchar(8) COMMENT '	学历	',
	degree varchar(8) COMMENT '	学位	',
	gradu_from varchar(32) COMMENT '	毕业院校	',
	major varchar(64) COMMENT '	专业	',
	contact_info varchar(32) COMMENT '	联系方式	',
	work_unit varchar(128) COMMENT '	工作单位	',
	work_type varchar(16) COMMENT '	身份类别	',
	dept varchar(32) COMMENT '	部门	',
	job_title varchar(16) COMMENT '	职称	',
	job varchar(16) COMMENT '	职务	',
	cert_quali varchar(16) COMMENT '	证书资格	',
	cert_num varchar(32) COMMENT '	证书编号	',
	reward_info text COMMENT '	立功授奖信息	',
	creation_date date,
	last_update_date date,
	PRIMARY KEY (id)
) ENGINE = InnoDB CHARSET = utf8;

DROP TABLE t_priv;

CREATE TABLE t_priv (
	id int NOT NULL AUTO_INCREMENT COMMENT '	id	',
	priv_name varchar(16) COMMENT '	权限点名称	',
	priv_code varchar(32) COMMENT '	权限点编码	',
	PRIMARY KEY (id)
) ENGINE = InnoDB CHARSET = utf8;

DROP TABLE t_role_priv;

CREATE TABLE t_role_priv (
	id int NOT NULL AUTO_INCREMENT COMMENT '	id	',
	role_id int COMMENT '	角色id	',
	role_name varchar(8) COMMENT '	角色名称	',
	priv_id int COMMENT '	权限id	',
	PRIMARY KEY (id)
) ENGINE = InnoDB CHARSET = utf8;

DROP TABLE t_user_rule;

CREATE TABLE t_user_rule (
	id int NOT NULL AUTO_INCREMENT COMMENT '	id	',
	police_id int COMMENT '	日期	',
	rule_id int COMMENT '	时间	',
	rule_name varchar(16) COMMENT '	角色名称	',
	PRIMARY KEY (id)
) ENGINE = InnoDB CHARSET = utf8;