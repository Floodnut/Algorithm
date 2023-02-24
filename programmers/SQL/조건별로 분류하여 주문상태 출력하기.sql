SELECT
    f.ORDER_ID as ORDER_ID,
    f.PRODUCT_ID as PRODUCT_ID,
    DATE_FORMAT(f.OUT_DATE, "%Y-%m-%d") as OUT_DATE,
    IF (f.OUT_DATE IS NULL, '출고미정', 
        IF (TIMESTAMPDIFF(DAY, DATE('2022-05-01'), f.OUT_DATE) <= 0, '출고완료', '출고대기')) as '출고여부'
FROM
    FOOD_ORDER as f
ORDER BY
    ORDER_ID