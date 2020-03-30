var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
const projects = [];
var htmlTable = ``;
// const http = new XMLHttpRequest();
// http.addEventListener("load", () => {
//   console.log(http.responseText);
// });
// http.open("GET", "https://api.github.com/search/repositories?q=angular");
// http.send();
// async function getData(query) {}
// function onSearch(input: HTMLInputElement) {
//   let htmlTable = ``;
//   const result = new Promise(resolve => {
//     fetch(`https://api.github.com/search/repositories?q=${input.value}`).then(
//       (response: Response) => {
//         response.json().then(data => projects.push(...data.items));
//         resolve();
//       }
//     );
//   });
//   result.then(resolve => {
//     htmlTable += `
//         <table>
//             <tr>
//                 <th>#id</th>
//                 <th>name</th>
//                 <th>clone_url</th>
//                 <th>description</th>
//             </tr>
//     `;
//     projects.map(proj => {
//       htmlTable += `<tr>
//       <td>${proj.id}</td>
//       <td>${proj.name}</td>
//       <td>${proj.clone_url}</td>
//       <td>${proj.description}</td>
//       </tr>`;
//     }); //clone_url,description,name,id
//     htmlTable += `</table>`;
//     document.getElementById("result").innerHTML = htmlTable;
//   });
//   // getData(input.value).then(() => {});
// }
function getData(query) {
    return __awaiter(this, void 0, void 0, function* () {
        return new Promise(resolve => {
            fetch(`https://api.github.com/search/repositories?q=${query}`).then((response) => {
                response.json().then(data => projects.push(...data.items));
                resolve();
            });
        });
    });
}
function onSearch(input) {
    getData(input.value).then(resolve => {
        drawData().then(resolve => {
            document.getElementById("result").innerHTML = htmlTable;
        });
    });
}
function drawData() {
    return __awaiter(this, void 0, void 0, function* () {
        return new Promise(resolve => {
            htmlTable = `
        <table>
            <tr>
                <th>#id</th>
                <th>name</th>
                <th>clone_url</th>
                <th>description</th>
            </tr>
    `;
            projects.map(proj => {
                htmlTable += `<tr>
      <td>${proj.id}</td>
      <td>${proj.name}</td>
      <td>${proj.clone_url}</td>
      <td>${proj.description}</td>
      </tr>`;
            });
            htmlTable += `</table>`;
            console.log(projects);
            resolve();
        });
    });
}
