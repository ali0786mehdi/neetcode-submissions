SELECT seller_name
FROM seller
WHERE seller_id NOT IN (
    SELECT seller_id
    FROM orders
    WHERE sale_date BETWEEN '2020-01-01' AND '2020-12-31'
)
ORDER BY seller_name;