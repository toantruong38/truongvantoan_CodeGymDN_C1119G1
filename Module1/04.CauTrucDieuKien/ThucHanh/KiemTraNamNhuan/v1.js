function test() {
    document.write("Hello world");
}

function main() {
    let n;
    n = parseInt(prompt('Nhap nam de kiem tra'));
    let req1, neg_req2, req3;
    req1 = n % 4 === 0 && n % 100 !== 0; //chia het cho 4 va khong chia het cho 100
    // neg_req2 = n % 100 === 0 && n % 400 !== 0; //negative answer
    req3 = n % 100 === 0 && n % 400 === 0; //chia het cho 100 va chia het cho 400
    console.log(req1,req3,neg_req2);
    if (req1 === true  || req3 === true) {
        document.write('Phai la nam nhuan');
    } else document.write('K phai la nam nhuan');
}