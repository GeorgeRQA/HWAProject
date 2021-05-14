'use strict'

const ITEMS = document.querySelector("#items");
const NAME = document.querySelector("#inputItemName");
const PRICE = document.querySelector("#inputPrice");
const QUANTITY = document.querySelector("#inputQuantity");
const NEW_ITEM = document.querySelector("#newItem")
const UPDATE_ITEM = document.querySelector("#updateModal");
const UPDATE_NAME = document.querySelector("#updateName");
const UPDATE_PRICE = document.querySelector("#updatePrice");
const UPDATE_QUANTITY = document.querySelector("#updateQuantity");

//Read all
axios.get("http://localhost:8080/getAll",{
    "header":{
        "Access-Control-Allow-Origin":"*"
    }
})
    .then((response)=>{
        console.log(response);
        for(let data of response.data){
            printToScreen(data);
        }
    })
    .catch((err) =>{
        console.log(err);
    });

const printToScreen = (data) =>{
const p = document.createElement("p");
const text = document.createTextNode(`Name: ${data.name} | Price: £${data.price} | Quantity: ${data.quantity}`);
p.appendChild(text);
ITEMS.appendChild(p);

const updateButton = document.createElement("a");
updateButton.innerHTML = "Update";
updateButton.className = "btn btn-warning";
updateButton.href="update.html?"+data.id;
ITEMS.appendChild(updateButton);


const deleteButton = document.createElement("button");
deleteButton.innerHTML = "Delete";
deleteButton.className = "btn btn-danger";
ITEMS.appendChild(deleteButton);
deleteButton.addEventListener("click", ()=>deleteItem(data.id));
}

//Delete
const deleteItem = (id) =>{
    const deleteURL = `http://localhost:8080/remove/${id}`
    axios 
    .delete(deleteURL)
    .then(function (a) {
        console.log(a);
        window.location.reload();
      })
      .catch(function (error) {
        console.log(error);
      });   
}

//Create
const createItem = () =>{
 const name = NAME.value;
 const price = PRICE.value;
 const quantity = QUANTITY.value;

let newItem = {
    "name":name,"price":price,"quantity":quantity
};
console.log(newItem);

axios
    .post('http://localhost:8080/create', newItem)
    .then(function (a) {
        console.log(a);
        window.location.reload();
      })
      .catch(function (error) {
        console.log(error);
      });   
}   
NEW_ITEM.addEventListener('submit', createItem);

