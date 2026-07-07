DECLARE
    CURSOR c_customers IS
    SELECT c.CustomerID, c.Name, l.LoanID, l.InterestRate,
           FLOOR(MONTHS_BETWEEN(SYSDATE, c.DOB) / 12) AS Age
    FROM Customers c
    JOIN Loans l ON c.CustomerID = l.CustomerID;

BEGIN
    FOR rec IN c_customers LOOP
        IF rec.Age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE LoanID = rec.LoanID;

            DBMS_OUTPUT.PUT_LINE(rec.Name || ' received 1% interest discount.');
        END IF;
    END LOOP;

    COMMIT;
END;
/

DECLARE
    CURSOR c_customers IS
    SELECT CustomerID, Name, Balance
    FROM Customers;

BEGIN
    FOR rec IN c_customers LOOP
        IF rec.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = rec.CustomerID;

            DBMS_OUTPUT.PUT_LINE(rec.Name || ' promoted to VIP.');
        END IF;
    END LOOP;

    COMMIT;
END;
/

DECLARE
    CURSOR c_loans IS
    SELECT c.Name, l.EndDate
    FROM Customers c
    JOIN Loans l ON c.CustomerID = l.CustomerID
    WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30;

BEGIN
    FOR rec IN c_loans LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Loan of ' || rec.Name ||
                             ' is due on ' || TO_CHAR(rec.EndDate, 'DD-MON-YYYY'));
    END LOOP;
END;
/