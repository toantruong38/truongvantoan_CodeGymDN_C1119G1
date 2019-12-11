function timKiemTuyenTinh(nums,search_value)
{
    for(let i=0;i<nums.length;i++)
    {
        if(search_value<nums[i])
        {
            alert("Too low!");
            return startTheGame();
        }
        else if(search_value>nums[i])
        {
            alert("Too hight!");
            return startTheGame();
        }
        else if(nums[i]===search_value)
        {
            return alert("Correct");
        }
    }
}