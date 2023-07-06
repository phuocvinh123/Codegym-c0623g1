function ChangeMoney() {
  let Amount = document.getElementById("Amount").value;
  let FromCurrency = document.getElementById("From").value;
  let ToCurrency = document.getElementById("To").value;
  let Result;
  if (FromCurrency == "USD" && ToCurrency == "VNĐ") {
    Result = "Result:" + (Amount * 23000 )+ "Đ";
  } else if (FromCurrency == "VNĐ" && ToCurrency == "USD") {
    Result = "Result:" + (Amount / 23000 )+ "$";
  } else if (FromC == "VND") {
    Result = "Result: " + Amount + " Đ";
  } else {
    Result = "Result: " + Amount + " $";
  }
  document.getElementById("Result").innerHTML = Result;
}
