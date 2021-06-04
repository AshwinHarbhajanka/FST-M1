select * from orders
where salesman_id = (
select salesman_id from customers where customer_id = 3007
);

select * from orders
where salesman_id in (
select salesman_id from salesman where salesman_city = 'New York'
);

select grade, count(*) from customers 
where grade > (select avg(grade) from customers where city = 'New York')
group by grade;

select * from orders where salesman_id in 
(select salesman_id from salesman where commission = 
(select max(commission) from salesman));