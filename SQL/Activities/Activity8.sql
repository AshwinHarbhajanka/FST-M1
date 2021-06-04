select * from orders;

select max(purchase_amount), customer_id from orders 
group by customer_id 
order by customer_id;

select max(purchase_amount), salesman_id, order_date from orders 
where order_date = to_date('2012-08-17','yyyy/mm/dd')
group by salesman_id, order_date
order by salesman_id;

select max(purchase_amount), customer_id, order_date from orders 
group by customer_id, order_date
having max(purchase_amount) in (2030,3450,5760,6000)
order by customer_id;