create table customers (
    customer_id int primary key, 
    customer_name varchar(32),
    city varchar(20), 
    grade int, 
    salesman_id int);

insert all
into customers values(3002, 'Nick Rimando', 'New York', 100, 5001) 
into customers values(3007, 'Brad Davis', 'New York', 200, 5001)
into customers values(3005, 'Graham Zusi', 'California', 200, 5002) 
into customers values(3008, 'Julian Green', 'London', 300, 5002)
into customers values(3004, 'Fabian Johnson', 'Paris', 300, 5006) 
into customers values(3009, 'Geoff Cameron', 'Berlin', 100, 5003)
into customers values(3003, 'Jozy Altidor', 'Moscow', 200, 5007)
into customers values(3001, 'Brad Guzan', 'London', 300, 5005)
select 1 from dual;

select customer_name, salesman.salesman_name 
from customers
inner join salesman
on customers.salesman_id = salesman.salesman_id;

select customer_name, grade, salesman.salesman_name
from customers
inner join salesman
on customers.salesman_id = salesman.salesman_id
where grade<300
order by customer_name;

select customer_name, salesman_name, commission
from customers
inner join salesman
on customers.salesman_id = salesman.salesman_id
where commission>12
order by customer_name;

select order_no, purchase_amount, order_date, customer_name, salesman_name, commission
from orders
inner join customers on orders.customer_id = customers.customer_id
inner join salesman on orders.salesman_id = salesman.salesman_id
order by order_no;
