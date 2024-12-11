alter table hardware add active tinyint;
update hardware set active = 1;