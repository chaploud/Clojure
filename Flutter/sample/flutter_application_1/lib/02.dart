void main() {
  // 昨今は64bitが主流
  // int
  final x = 1;
  final hex = 0xFF;

  // double
  final exponent = 1e5;
  final y = 1.1;
  final expo = 1.1e5;

  // String
  final str1 = 'Hello Dart';
  final str2 = "hello dart";

  final name = 'dart';
  final str3 = 'Helli, $name';
  print(str3);

  final str4 = 'Hello, ${name.toUpperCase()}';
  print(str4);

  final str5 =
      'Hello, '
      'Dart!';
  print(str5);

  final str6 = 'Helll' + 'lo, Dart!';
  print(str6);

  final message1 = "<div>\n <p>hello</p>\n</div>";
  final message2 = """
<div>
  <p>hello</p>
</div>
  """;
  final message3 = '''
  <div>
    <p>hello</p>
  </div>
  ''';
  print(message1);
  print(message2);
  print(message3);

  final message4 = r'Hello\nworld';
  print(message4);

  // bool
  final flag1 = true;
  final flag2 = false;
  print(flag1);

  // List(可変長)
  final list1 = [0, 1, 2, 3];
  final list2 = [0, 1, 2, 3];
  print(list1);

  list1.add(4);
  // list1.add('abc'); // 型違い挿入エラー

  final list3 = <int>[4, 5];

  // 固定長リスト
  final list4 = List.unmodifiable([0, 1, 2, 3]);
  // list4.add(7); // 実行時エラー

  // Set
  final set1 = {'Apple', 'Banana', 'Orange'};
  final set2 = <String>{'Apple', 'Banana', 'Orange'};
  print(set1);
  set2.add('value1');
  print(set2);
  // map2.add(2); // 型違い挿入エラー

  // Map
  final map1 = {200: 'OK', 403: 'Forbidden', 404: 'Not Found'};
  print(map1);

  map1[204] = 'No Content';
  print(map1);
  // map1['204'] = 'No Content'; // 型違い挿入エラー
  // map1[204] = 3; // 型違い挿入エラー

  final map2 = <int, String>{200: 'OK', 403: 'Forbidden', 404: 'Not Found'};
  final setOrMap = {}; // これはMap
  print(setOrMap is Map); // true
}
