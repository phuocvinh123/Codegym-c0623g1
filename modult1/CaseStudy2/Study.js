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
            new Product(1,'https://img4.thuthuatphanmem.vn/uploads/2021/02/10/anh-socola-valentine-trai-tim-dep-nhat_124254618.jpg','socola','ngon nhất thế giới',10,1000),
            new Product(),
            new Product(),
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
// thêm
// Khởi tạo checked_list


function checkbox1() {
    let checked_list = [];
  if (document.getElementById('checkbox1').checked) {
    // Xóa các giá trị cũ trong checked_list nếu có
    checked_list.length = 0;

    // Lặp qua các sản phẩm và thêm id của từng sản phẩm vào checked_list
    for (let i = 0; i < products.length; i++) {
      checked_list.push(products[i].id);
      document.getElementById(`checkbox${products[i].id}`).checked == true;
    }
  } else {
    // Lặp qua các sản phẩm và bỏ check các checkbox
    for (let i = 0; i < products.length; i++) {
      document.getElementById(`checkbox${products[i].id}`).checked == false;
    }

    // Xóa toàn bộ giá trị trong checked_list
    checked_list.length = 0;
  }

  console.log(checked_list);
}
function remove() {
    if (checked_list.length == 0) {
        alert('Please choose one to remove');
    }
    else {
        let confirmed = confirm('bạn có muốn xóa hết sản phẩm');
        if (confirmed) {
            for (let id of checked_list) {
                products = products.filter(function (product) {
                    return product.id != id;
                })
                localStorage.setItem(products_prd, JSON.stringify(products));
                renderTable();
                checked_list = [];
                document.querySelector('#checkbox1').checked = false;
            }
        } else {
            document.querySelectorAll('.check-box').checked = false;
        }
    }
}