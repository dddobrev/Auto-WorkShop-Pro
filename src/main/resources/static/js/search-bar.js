const clientList = document.getElementById('clientList')
const searchBar = document.getElementById('searchInput')

const allClients = [];

fetch("http://localhost:8080/clients/search/all/api")
    .then(response => response.json())
    .then(data => {
        for (let client of data) {
            clientList.push(client);
        }
    })

console.log(clientList);

searchBar.addEventListener('keyup', (e) => {
    const searchingCharacters = searchBar.value.toLowerCase();
    let filteredClients = allClients.filter(client => {
        return client.firstName.toLowerCase().includes(searchingCharacters)
            || client.telephone.toLowerCase().includes(searchingCharacters);
    });
    displayClient(filteredClients);
})


const displayClient = (clients) => {
    clientList.innerHTML = clients
        .map((cl) => {
            return `<table className="table text-white">

                <p class="card-text border-bottom ">Name: ${cl.firstName}</p>
                <thead>
                <tr className="my-main text-white">
                    <th scope="col">First name</th>
                    <th scope="col">Last name</th>
                    <th scope="col">Telephone number</th>
                </tr>
                </thead>
                <tbody class="text-white">
                <tr class="my-main text-white">
                    <td class="text-white">${cl.firstName}</td>
                    <td class="text-white">${cl.secondName}</td>
                    <td class="text-white">${cl.telephone}</td>
                </tr>
                </tbody>
            </table>`
        }).join('');
}
