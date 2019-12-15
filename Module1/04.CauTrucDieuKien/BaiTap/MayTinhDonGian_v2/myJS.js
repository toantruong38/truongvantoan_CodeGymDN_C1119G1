let numCount = 0; //Đếm số number đang tồn tại
let divide_Operator_Count = 0; //Đếm số phép chia đang tồn tại. chỉ được 0 hoặc 1
let Operators_Count = 0;
let subtract_Operator_Count = 0; // Đếm số phép trừ hiện có
function Add_Multiply(numCase)
{
    if (document.getElementById("inputTxtBox").value !== "" && Operators_Count === 0) //Blank input and Duplicate Operators Excep Handle
    {
        switch (numCase)
        {
            case '+':
                Operators_Count++;
                if (numCount >= 2 && Operators_Count === 1) //Custom feature
                {
                    Calculate();
                    document.getElementById("inputTxtBox").value += '+';
                } else
                {
                    document.getElementById("inputTxtBox").value += '+';
                }
                break;
            case 'X':
                Operators_Count++;
                if (numCount >= 2 && Operators_Count === 1) //Custom feature
                {
                    Calculate();
                    document.getElementById("inputTxtBox").value += '*';
                } else
                {
                    document.getElementById("inputTxtBox").value += '*';
                }
                break;
        }
    }
}

function Divide()
{
    if (document.getElementById("inputTxtBox").value !== "" && Operators_Count === 0) //Blank input and Duplicate Operators Excep Handle
    {
        divide_Operator_Count++;
        Operators_Count++;
        if (numCount >= 2 && Operators_Count === 1) //Custom feature
        {
            Calculate();
            document.getElementById("inputTxtBox").value += '/';
        } else
        {
            document.getElementById("inputTxtBox").value += '/';
        }

    }
}

function Subtract(numCase)
{
    if (document.getElementById("inputTxtBox").value === "" && numCase === '-') //First subtract operator of the wholetime
    {
        subtract_Operator_Count++;
        Operators_Count++;
        document.getElementById("inputTxtBox").value += '-';

    } else if (document.getElementById("inputTxtBox").value !== "" && Operators_Count === 0) //Blank input and Duplicate Operators Excep Handle
    {
        Operators_Count++; //subtract_Operator_Count++;
        if (numCount >= 2 && Operators_Count === 1) //Custom feature
        {
            Calculate();
            document.getElementById("inputTxtBox").value += '-';
        }

    }

}

function Calculate()
{
    document.getElementById("inputTxtBox").value =
        eval(document.getElementById("inputTxtBox").value);
    Operators_Count = 0;

}

function Reset()
{
    document.getElementById("inputTxtBox").value = '';
    numCount = divide_Operator_Count = Operators_Count = subtract_Operator_Count = 0;
}

function numBtn(numCase)
{
    switch (numCase)
    {
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        case 7:
        case 8:
        case 9:
            //alert('Hi');
            document.getElementById("inputTxtBox").value += numCase;
            subtract_Operator_Count = 0;
            Operators_Count = 0;
            numCount++;
            break;
        case 0:
            if (divide_Operator_Count === 1 && Operators_Count >= 2)
            {
                document.getElementById("inputTxtBox").value += numCase;
                subtract_Operator_Count = 0;
                Operators_Count = 0;
                numCount++;
            }
    }
}