class Product{
    constructor(id,pictures,name,description,quantity,price){
        this.id = id;
        this.pictures=pictures;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }
}
let KEY_PRODUCT = "products";
let products = [];


getProductFromStorage();

function getProductFromStorage(){
    if(localStorage.getItem(KEY_PRODUCT) == null){
        products = [
            new Product(1,'product_1.png','Fried shrimp with cheese','món ăn 1',10,120000),
            new Product(2,'product_2.png','Avocado and egg toast','món ăn 2',6,120000),
            new Product(3,'product_3.png','Green house salad','món ăn 3',5,220000),
            new Product(4,'product_4.png','Chicken burger','món ăn 4',9,123000),
            new Product(5,'product_5.png','Classic ceasar salad','món ăn 5',5,320000),
            new Product(6,'product_6.png','Grilled fish with orange sauce','món ăn 6',8,120000),
        ];
        localStorage.setItem(KEY_PRODUCT, JSON.stringify(products));
    }else{
        let jsonProduct = localStorage.getItem(KEY_PRODUCT);
        products = JSON.parse(jsonProduct);
    }
}

function saveProductToStorage(key, data){
    localStorage.setItem(key, JSON.stringify(data));
}

function renderData(products){
    let str = "";
    for(let i=0; i<products.length; i++){
        str += `
            <tr id=${products[i].id}>
                <td><input type="checkbox" onchange="checkbox1(${products[i].id})"></td>
                <td>${products[i].id}</td>
                <td><img src="${products[i].pictures}" alt="" width="70"></td>
                <td>${products[i].name}</td> 
                <td>${products[i].description}</td>
                <td>${products[i].quantity}</td>
                <td>${products[i].price}</td>
                <td class="last-col">
                    <button class="btn btn-danger" onclick="handleDelete(${products[i].id})">Delete</button>
                    <button class="btn btn-success" onclick="handleShowFrmEdit(${products[i].id})">Edit</button>
                </td>
            </tr>
        `
    }
    document.getElementById("tb-body").innerHTML = str;
}

renderData(products);

function handleShowFrmEdit(id){
    let productEdit = null;
    productEdit = findProductById(id);

    document.getElementById("txtName").value = productEdit.name;
    document.getElementById("txtPrice").value = productEdit.price;
    document.getElementById("txtDescription").value = productEdit.description;
    document.getElementById("txtQuantity").value = productEdit.quantity;
    document.getElementById("txtId").value = productEdit.id;
    document.getElementById("txtPictures").value=productEdit.pictures
    showBtnFromUpdateProduct();
}


function getProductFromForm(product){
    let name = document.getElementById("txtName").value;
    let description = document.getElementById("txtDescription").value;
    let price = document.getElementById("txtPrice").value;
    let quantity = document.getElementById("txtQuantity").value;
    let pictures =document .getElementById("txtPictures").value;
    product.price = price;
    product.name = name;
    product.description = description;
    product.quantity = quantity;
    product.pictures =pictures;
}

function resetFrmProduct(){
    document.getElementById("txtName").value = "";
    document.getElementById("txtPrice").value = "";
    document.getElementById("txtDescription").value = "";
    document.getElementById("txtQuantity").value = "";
    document.getElementById("txtPictures").value="";
}
function showBtnFormAddProduct(){
    document.getElementById("btnAdd").classList.remove("hide");
    document.getElementById("btnUpdate").classList.add("hide");
    document.getElementById("btnCancel").classList.add("hide");
}
function showBtnFromUpdateProduct(){
    document.getElementById("btnAdd").classList.add("hide");
    document.getElementById("btnUpdate").classList.remove("hide");
    document.getElementById("btnCancel").classList.remove("hide");
}

function getMaxProductId(products){
    if(products.length == 0){
        return -1;
    }else{
        let maxProductId = products[0].id;
        for(let i = 0 ; i< products.length ;i++){
            if(products[i].id > maxProductId){
                maxProductId = products[i].id;
            }
        }
        return maxProductId;
    }
    
}

function findProductById(productId){
    let productEdit = null;
    for(var i=0; i<products.length; i++){
        if(products[i].id == productId){
            productEdit = products[i];
        }
    }
    return productEdit;
}


let btnUpdate = document.getElementById("btnUpdate");
btnUpdate.addEventListener("click", function(e){
    let name = document.getElementById("txtName").value;
    let description = document.getElementById("txtDescription").value;
    let price = document.getElementById("txtPrice").value;
    let quantity = document.getElementById("txtQuantity").value;
    let id = document.getElementById("txtId").value;
    let pictures=document.getElementById("txtPictures").value;

    for(let i=0;i<products.length;i++){
        if(products[i].id == id){
            products[i].name = name;
            products[i].description = description;
            products[i].price = price;
            products[i].quantity = quantity;
            products[i].pictures=pictures;
        }
    }
    saveProductToStorage(KEY_PRODUCT, products);
    renderData(products);
    showBtnFormAddProduct();
    resetFrmProduct();

});

let btnCancel = document.getElementById("btnCancel");
btnCancel.addEventListener("click", function(e){
    resetFrmProduct();
    showBtnFormAddProduct();
    
})

let btnAdd = document.getElementById("btnAdd");
btnAdd.addEventListener("click", function(e){
    let product = new Product();
    getProductFromForm(product)

    let max = getMaxProductId(products);
    product.id = max + 1;
    products.push(product);

    saveProductToStorage(KEY_PRODUCT, products);
    renderData(products);
    resetFrmProduct();
})

function handleDelete(id){
    let productDelete = findProductById(id);
    let check = confirm(`Bạn có muốn xóa sản phẩm ${productDelete.name}`);
    if(check){
        deleteProduct(id);
        saveProductToStorage(KEY_PRODUCT, products);
        renderData(products);
    }
}
function deleteProduct(id){
    for(let i=0; i<products.length; i++){
        if(products[i].id == id){
            products.splice(i, 1);
        }
    }
}
