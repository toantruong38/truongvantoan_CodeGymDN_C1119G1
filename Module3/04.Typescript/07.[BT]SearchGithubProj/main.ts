async function getData(url: string): Promise<any> {
  return new Promise(resolve => {
    const http = new XMLHttpRequest();
    http.onload = () => {
      resolve(this.response);
    };
    http.open("GET", url);
    http.send();
  });
}
function convertData(data: string): string {
  try {
    return JSON.parse(data);
  } catch (error) {
    return data;
  }
}

const url = "https://api.github.com/search/repositories?q=angular";
async function displayData() {
  const data = convertData(await getData(url));
  console.log(data);
}
displayData();
