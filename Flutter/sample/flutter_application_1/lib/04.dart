void main() {
  // 演算子

  // 加減乗除
  print(2 + 3);
  print(2 - 3);
  print(2 * 3);
  print(5 / 2); // 2.5 (Cと違う)
  print(5 % 2);

  int a;
  int b;
  a = 0;
  b = ++a; // 加算してから代入
  print("$a, $b");

  a = 0;
  b = a++; // 代入してから加算
  print("$a, $b");

  a = 0;
  b = --a; // 減算してから代入
  print("$a, $b");

  a = 0;
  b = a--; // 代入してから減算
  print("$a, $b");

  // 比較
  print(2 == 3);
  print(2 != 3);
  print(2 > 3);
  print(2 < 3);
  print(5 >= 5);
  print(5 <= 5);
  // == は参照の比較 <= !! 注意
  // オーバーライドして同値性を比較することもできる

  // 3項演算子
  int x = 128;
  int y = 256;
  final max = x > y ? x : y;
  print(max);
}
