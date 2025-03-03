-- Создание таблицы Taco_Order
create table if not exists Taco_Order (
                                          id VARCHAR(255) PRIMARY KEY,
                                          delivery_Name varchar(50) not null,
                                          delivery_Street varchar(50) not null,
                                          delivery_City varchar(50) not null,
                                          cc_number varchar(16) not null,
                                          cc_expiration varchar(5) not null,
                                          cc_cvv varchar(3) not null,
                                          placed_at timestamp not null
);

-- Создание таблицы Taco
create table if not exists Taco (
                                    id VARCHAR(255) PRIMARY KEY,
                                    name varchar(50) not null,
                                    taco_order VARCHAR(255) not null, -- Исправлен тип данных для внешнего ключа
                                    created_at timestamp not null
);

-- Создание таблицы Ingredient
create table if not exists Ingredient (
                                          id varchar(4) PRIMARY KEY, -- Добавлен первичный ключ
                                          name varchar(25) not null,
                                          type varchar(10) not null
);

-- Создание таблицы Ingredient_Ref
create table if not exists Ingredient_Ref (
                                              ingredient varchar(4) not null, -- Тип данных совпадает с Ingredient.id
                                              taco VARCHAR(255) not null, -- Тип данных совпадает с Taco.id
                                              taco_key bigint not null
);

-- Добавление внешнего ключа в таблицу Taco
alter table Taco
    add foreign key (taco_order) references Taco_Order(id);

-- Добавление внешнего ключа в таблицу Ingredient_Ref
alter table Ingredient_Ref
    add foreign key (ingredient) references Ingredient(id);

-- Добавление внешнего ключа в таблицу Ingredient_Ref для связи с Taco
alter table Ingredient_Ref
    add foreign key (taco) references Taco(id);

-- Создание индексов для улучшения производительности
create index idx_taco_order on Taco(taco_order);
create index idx_ingredient_ref_ingredient on Ingredient_Ref(ingredient);
create index idx_ingredient_ref_taco on Ingredient_Ref(taco);