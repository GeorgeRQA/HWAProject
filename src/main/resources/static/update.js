`use strict`

const UPDATE_ITEM = document.querySelector("#updateItem");
const UPDATE_NAME = document.querySelector("#updateItemName");
const UPDATE_PRICE = document.querySelector("#updatePrice");
const UPDATE_QUANTITY = document.querySelector("#updateQuantity");
let id = 0;
const params = new URLSearchParams(window.location.search);
for (const param of params){
    id=param[0];
    console.log(id);
}
    const getInfo = ()=>{
        axios.get("http://localhost:8080/getOne/"+id,{
    "header":{
        "Access-Control-Allow-Origin":"*"
    }
})
    .then((response)=>{
        console.log("adwad",response);
        UPDATE_NAME.value = response.data.name;
        UPDATE_PRICE.value = response.data.price;
        UPDATE_QUANTITY.value = response.data.quantity;
    })
    .catch((err) =>{
        console.log(err);
    });
    }
    getInfo();
    const updateItem = ()=>{
        const name = UPDATE_NAME.value;
        const price = UPDATE_PRICE.value;
        const quantity = UPDATE_QUANTITY.value;
    
        const updatedItem = {
            "name":name, "price":price,"quantity":quantity
        };
        console.log(updatedItem);
    
        const updateURL = `http://localhost:8080/update/`+id;
        console.log(updateURL);
        axios
        .put(updateURL, updatedItem, {
            "header":{
                "Access-Control-Allow-Origin":"*"
            }
        })
        .then(function (a) {
            console.log(a);
          })
          .catch(function (error) {
            console.log(error);
          });   
    }
    UPDATE_ITEM.addEventListener("submit", updateItem);  
