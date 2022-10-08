start transaction; #開啟事務

update account set money = money-100 where name='A';
update account set money = money+100 where name='B';
# 必須提交才有效，才會扣錢
commit;
