function Express()
{
    let inputMonth = document.getElementById("inputTxtBox");
    let result = "";
    switch (inputMonth.value)
    {
        case '1':
        case '3':
        case '5':
        case '7':
        case '8':
        case '10':
        case '12':
            result = 31;
            break;
        case '4':
        case '6':
        case '9':
        case '11':
            result = 30;
            break;
        case '2':
            result = "28 or 29";
            break;
        default:
            result = "thang ko hop le";
    }
    document.getElementById("showResult").innerText = result;
}
