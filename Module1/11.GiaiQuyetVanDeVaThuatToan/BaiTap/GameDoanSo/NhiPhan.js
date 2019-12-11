function timKiemNhiPhan(nums,search_number)
{
    nums.sort(
        function(a,b)
        {
            if(a-b>0) return 1;
            if(a-b<0) return -1;
        }
    );
    if(search_number===nums[Math.ceil(nums.length/2)])
    {
        return alert("Correct");
    }
    else if(search_number>nums[Math.ceil(nums.length/2)])
    {
        for(let i=Math.ceil(nums.length/2);i<nums.length;i++)
        {
            if(search_number===nums[i])
            {
                return alert("Correct");
            }
            else if(search_number>nums[i])
            {
                alert("Too high");
                return startTheGame();
            }
            else if(search_number<nums[i])
            {
                alert("Too low");
                return startTheGame();
            }
        }
    }
    else if(search_number<nums[Math.ceil(nums.length/2)])
    {
        for(let i=Math.ceil(nums.length/2);i>0;i--)
        {
            if(search_number===nums[i])
            {
                return alert("Correct");
            }
            else if(search_number>nums[i])
            {
                alert("Too high");
                return startTheGame();
            }
            else if(search_number<nums[i])
            {
                alert("Too low");
                return startTheGame();
            }
        }
    }
}
