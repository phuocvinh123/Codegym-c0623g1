var productList = [];

function addProduct() {
    let productName = document.getElementById('name').value;
    productList.push(productName);
    document.getElementById('name').value = '';
    displayProductList(productList);
}

function displayProductList(data) {
    let tbPoducts = '';
    for (let i = 0; i < data.length; i++) {
        tbPoducts += `
                <tr>
                    <td>${data[i]}</td>
                    <td>
                        <button>Edit</button>
                    </td>
                    <td>
                        <button onclick='remove("${data[i]}")'>Remove</button>
                    </td>
                </tr>`

    }
    document.getElementById('tbProduct').innerHTML = tbPoducts;
    console.log(tbPoducts);
}


function remove(productName) {
    let newProductList = []
    for (let i = 0; i < productList.length; i++) {
        if (productList[i] != productName) {
            newProductList.push(productList[i])
        }
    }
    productList = newProductList;
    displayProductList(productList);

    // let newProductList = productList.filter(function (value, index) {
    //     return value != productName;
    // })
    // productList = newProductList;
    // displayProductList(productList);
}


displayProductList(productList)