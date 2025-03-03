delete from Ingredient_Ref;
delete from Taco;
delete from Taco_Order;

delete from Ingredient;
insert into Ingredient (id, name, type)
values ('МУЛП', 'Мучная лепёшка', 'WRAP');
insert into Ingredient (id, name, type)
values ('КУКУ', 'Кукурузная лепешка', 'WRAP');
insert into Ingredient (id, name, type)
values ('ГВФШ', 'Говяжий фарш', 'PROTEIN');
insert into Ingredient (id, name, type)
values ('СВФШ', 'Свиной фарш', 'PROTEIN');
insert into Ingredient (id, name, type)
values ('ПМДР', 'Помидоры', 'VEGGIES');
insert into Ingredient (id, name, type)
values ('СЛАТ', 'Салат', 'VEGGIES');
insert into Ingredient (id, name, type)
values ('ЧЕДР', 'Чеддер', 'CHEESE');
insert into Ingredient (id, name, type)
values ('РОСС', 'Российский', 'CHEESE');
insert into Ingredient (id, name, type)
values ('СЛСА', 'Сальса', 'SAUCE');
insert into Ingredient (id, name, type)
values ('СМТН', 'Сметана', 'SAUCE');
