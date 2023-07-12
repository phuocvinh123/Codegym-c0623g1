// let arr=[
//     [3,1,5,3],
//     [4,4,2,2],
//     [1,1,1,1],
//     [3,0,3,5],
// ];
// let total = 0;
// for(let i=0;i<arr.length;i++){
//     for(let j=0;j<arr[i].length;j++){
//         if(i == j || i + j == arr[i].length -1){
//             total += arr[i][j];
//         }
//     }
// }
// console.log("Tổng là: ", total);
// Bài 1: hiển thị các cột chẵn
// let arr = [
//     [3,1,5,3],
//     [4,4,2,2],
//     [1,1,1,1],
//     [3,0,3,5],
//  ]
//     for(let i=0; i<arr.length; i++){
//         let str="";
//         for(let j=0; j<arr [i].length; j++){
//             if(j % 2 == 0){
//                 str+=arr[i][j]+ "  ";
//             }
//         }console.log(str);
//     }
// Bài 2: Tính tổng các giá trị đường viền
// let arr = [
//    [3,1,5,3],
//    [4,4,2,2],
//    [1,1,1,1],
//    [3,0,3,5],
//    ]
//    let sum=0;
//    for(let i=0; i<arr.length; i++){
//     for(let j=0; j<arr[i].length; j++){
//         if((i==0) || (i==arr.length-1) || (j==0 )|| (j==arr[i].length-1)){
//          sum+=arr[i][j];
//         }
//     }
// }console.log(sum)
// Bài 3: Tìm ra vị trí [i,j] của số chẳng đầu tiên
// let arr = [
//   [3, 1, 5, 3],
//   [4, 4, 2, 2],
//   [1, 1, 1, 1],
//   [3, 0, 3, 5],
// ];
// let str = "";
// for (let i = 0; i < arr.length; i++) {
//   for (let j = 0; j < arr[i].length; j++) {
//     if (arr[i][j] % 2 == 0 && arr[i][j] > 0) {
//       str += `i: ${i} j: ${j}`;
//       break;
//     }
//   }
// }
// console.log(str);
//Bài 4: Tính tổng các số nguyên tố trong mảng 2 chiều
// let arr = [
//   [3, 1, 5, 3],
//   [4, 4, 2, 2],
//   [1, 1, 1, 1],
//   [3, 0, 3, 5],
// ];
// let sum = 0;
// for (let i = 0; i < arr.length; i++) {
//   for (let j = 0; j < arr[i].length; j++) {
//     let a = true;
//     if (arr[i][j] < 2) {
//       a = false;
//     }
//     for (let b = 2; arr[i][j] > b; b++) {
//       if (arr[i][j] % b == 0) {
//         a = false;
//         break;
//       }
//     }
//     if (a == true) {
//       sum += arr[i][j];
//     }
//   }
// }
// console.log(sum);

//  Bài 5: Tính tổng: tam giác trên trái, trên phải, dưới trái, dưới phải
// let arr = [
//   [3, 1, 5, 3],
//   [4, 4, 2, 2],
//   [1, 1, 1, 1],
//   [3, 0, 3, 5],
// ];
// var sumTg1 = 0;
// var sumTg2 = 0;
// var sumTg3 = 0;
// var sumTg4 = 0;
// for (let i = 0; i < arr.length; i++) {
//   for (let j = 0; j < arr[i].length; j++) {
//     if(i>=j){
//         sumTg1+=arr[i][j];
//     }if(i<=j){
//         sumTg4+= arr[i][j];
//     }if((i+j)>=3){
//         sumTg2+=arr[i][j];
//     }if((i+j)<=3){
//         sumTg3+=arr[i][j];
//     }
//   }
// }console.log("tổng của tam giác 1 là: "+sumTg1);
// console.log("tổng của tam giác 2 là: "+sumTg2);
// console.log("tổng của tam giác 3 là: "+sumTg3);
// console.log("tổng của tam giác 4 là: "+sumTg4);
//bài 6: tìm số chẳng thứ 2
let arr = [
  [3, 1, 5, 3],
  [4, 4, 2, 2],
  [1, 1, 1, 1],
  [3, 0, 3, 5],
];
let str = "";
let count = "";
for (let i = 0; i < arr.length; i++) {
  for (let j = 0; j < arr[i].length; j++) {
    if (arr[i][j] % 2 == 0 && arr[i][j] > 0) {
      str += `i: ${i} j: ${j}`;
      break;
    }
  }
}
console.log(str);
