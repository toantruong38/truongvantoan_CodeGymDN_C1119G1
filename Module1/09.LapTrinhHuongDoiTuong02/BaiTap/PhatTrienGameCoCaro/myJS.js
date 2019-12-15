var myArrayX = [];
var myArrayY = [];
initiateArrayValue();

function initiateArrayValue()
{
    for (let j = 0; j < 20; j++)
    {
        myArrayY.push("");
    }
    for (let i = 0; i < 20; i++)
    {
        myArrayX.push(myArrayY);
    }
}

function drawTable()
{
    //id, onlick, style
    var div_print = '<div id="table">';
    let top = 0, left = 0;
    for (let i = 0; i < 20; i++)
    {
        for (let j = 0; j < 20; j++)
        {
            div_print += '<div id="cel_' + i + '_' + j + '"' + ' onclick="play(' + i + ',' + j + ')' + '"' +
                ' class="cell" style="position: absolute; width: 40px; height: 40px;' +
                'left: ' + left + 'px; top: ' + top + 'px; line-height: 40px;"' + '>' + '|' + '</div>';
            left += 40;
        }
        left = 0;
        top += 40;
    }
    div_print += '</div>';
    return div_print;
}

var default_X = true;

function play(x, y)
{

    if (default_X)
    {
        if (myArrayX[x][y] === "")
        {
            myArrayX[x][y] = "X";
            default_X = false;
        }
    } else
    {
        if (myArrayX[x][y] === "")
        {
            myArrayX[x][y] = "O";
            default_X = true;
        }
    }
    document.getElementById("cel_" + x + "_" + y).innerText = myArrayX[x][y];
}

function win(x, y)
{
    for (let i = 1; i <= 5; i++)
    {

    }
}

function Cells_old()
{
    this.true_is_X_false_is_O = true;
    this.setValue = function ()
    {
        if (this.true_is_X_false_is_O)
        {
            this.value = "X";
            this.true_is_X_false_is_O = false;
        } else
        {
            this.value = "O";
            this.true_is_X_false_is_O = true;
        }
    }
}

document.write(drawTable());