CREATE OR REPLACE FUNCTION CalculateAge(
    p_DOB DATE
)
RETURN NUMBER
IS
    v_Age NUMBER;
BEGIN
    v_Age := FLOOR(MONTHS_BETWEEN(SYSDATE, p_DOB) / 12);
    RETURN v_Age;
END;
/

CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
    p_LoanAmount NUMBER,
    p_InterestRate NUMBER,
    p_Years NUMBER
)
RETURN NUMBER
IS
    v_MonthlyRate NUMBER;
    v_Months NUMBER;
    v_Installment NUMBER;
BEGIN
    v_MonthlyRate := p_InterestRate / 12 / 100;
    v_Months := p_Years * 12;

    v_Installment := (p_LoanAmount * v_MonthlyRate * POWER(1 + v_MonthlyRate, v_Months)) /
                     (POWER(1 + v_MonthlyRate, v_Months) - 1);

    RETURN v_Installment;
END;
/

CREATE OR REPLACE FUNCTION HasSufficientBalance(
    p_AccountID NUMBER,
    p_Amount NUMBER
)
RETURN BOOLEAN
IS
    v_Balance NUMBER;
BEGIN
    SELECT Balance
    INTO v_Balance
    FROM Accounts
    WHERE AccountID = p_AccountID;

    RETURN v_Balance >= p_Amount;
END;
/