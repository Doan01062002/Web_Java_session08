create database ss08_java_web;

use ss08_java_web;

create table products(
  id int auto_increment primary key ,
  name varchar(100),
    description text,
    price decimal(10,2),
    stock int
);

-- Thêm sản phẩm
DELIMITER //
create procedure sp_add_product(
    in p_name varchar(100),
    in p_description text,
    in p_price decimal(10,2),
    in p_stock int
)

begin
    insert into products(name, description,price,stock)
        values (p_name,p_description,p_price,p_stock);
end //
DELIMITER ;

-- Cập nhật sản phẩm
DELIMITER //
create procedure sp_update_product(
    in p_id int,
    in p_name varchar(100),
    in p_description text,
    in p_price decimal(10,2),
    in p_stock int
)
begin
    update products
        set name = p_name,
            description = p_description,
            price = p_price,
            stock = p_stock
    where id = p_id;
end //
DELIMITER ;

-- Xóa sản phẩm
DELIMITER //
create procedure sp_delete_product(
    in p_id int
)
begin
    delete from products where id = p_id;
end //
DELIMITER ;

-- Lấy danh sách sản phẩm
DELIMITER //
create procedure sp_get_all_products()
begin
    select * from products;
end //
DELIMITER ;

-- Lấy sản phẩm theo id
DELIMITER //
create procedure sp_get_product_by_id(
    in p_id int
)
begin
    select * from products where id = p_id;
end //
DELIMITER ;

-- Tìm sản phẩm theo tên
DELIMITER //
create procedure sp_search_product_by_name(
    in p_name varchar(100)
)
begin
    select * from products where name like concat('%', p_name, '%');
end //
DELIMITER ;