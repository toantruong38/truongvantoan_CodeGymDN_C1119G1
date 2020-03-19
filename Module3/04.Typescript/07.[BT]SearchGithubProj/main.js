var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
function getData(url) {
    return __awaiter(this, void 0, void 0, function* () {
        return new Promise(resolve => {
            const http = new XMLHttpRequest();
            http.onload = () => {
                resolve(this.response);
            };
            http.open("GET", url);
            http.send();
        });
    });
}
function convertData(data) {
    try {
        return JSON.parse(data);
    }
    catch (error) {
        return data;
    }
}
const url = "https://api.github.com/search/repositories?q=angular";
function displayData() {
    return __awaiter(this, void 0, void 0, function* () {
        const data = convertData(yield getData(url));
        console.log(data);
    });
}
displayData();
