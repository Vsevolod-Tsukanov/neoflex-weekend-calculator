MERGE INTO weekend_dates wd
    USING (SELECT d
           FROM (SELECT DATEADD('DAY', ROWNUM - 1, '2023-01-01') AS d
                 FROM SYSTEM_RANGE(1, 365))
           WHERE DAY_OF_WEEK(d) IN (1, 7)) wu
ON (wd.date = wu.d)
WHEN NOT MATCHED THEN
    INSERT (date)
    VALUES (wu.d);