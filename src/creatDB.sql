create table ChoiceQuestion
(number char(10) primary key,content varchar(100),pic varchar(50),optionA varchar(50),optionB varchar(50),optionC varchar(50),optionD varchar(50),answer char(2) );
create table TFQuestion
(number char(10) primary key,content varchar(100),pic varchar(50),optionA char(6) default '正确',optionB char(6) default '错误',answer char(2) );
insert into TFQuestion(number,content,pic,answer) values('a001','驾驶机动车通过窄路、窄桥时的最高速度不能超过每小时30公里。','','正确')；
insert into TFQuestion(number,content,pic,answer) values('a002','机动车行驶中，车上少年儿童可不使用安全带。','','错误')；
insert into ChoiceQuestion(number,content,pic,optionA,optionB,optionC,optionD,answer) values('b001','年满20周岁，可以初次申请下列哪种准驾车型？','','大型货车','大型客车','中型客车','牵引车','A')；