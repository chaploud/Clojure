late String globalVariable; // グローバル変数

void learn() {
  int age1 = 0; // 型
  var age2 = 0; // 型推論
  final int age3 = 0; // 定数
  const int age = 37; // コンパイル時定数
  // クラス変数はconst宣言できない

  final flag1 = DateTime.now().hour.isEven;

  final int number1; // 初期化なし

  if (flag1) {
    number1 = 0; // 初めて代入するならOK
  } else {
    number1 = 255;
  }

  print(number1);

  final userName = 'steve';

  // int number;
  // if (userName == 'joe') {
  //   number = 0;
  // } else if (userName == 'john') {
  //   number = 255;
  // }

  // print(number); //　nullになりエラー

  globalVariable = 'hello'; // グローバル変数に代入
  print(globalVariable); // hello
}

void main() {
  learn();
}
