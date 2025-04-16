// ジェネリッククラス
class Foo<T> {
  final T _value;
  Foo(this._value);

  T getValue() {
    return _value;
  }
}

// ジェネリック関数
T? firstOrNull<T>(List<T> list) {
  if (list.isEmpty) {
    return null;
  }
  return list[0];
}

void main() {
  // ジェネリクス
  final List<int> list1 = [0, 1, 2, 3];
  final stringList = <String>['a', 'b', 'c'];

  final intFoo = Foo(3);
  print(intFoo.getValue());

  final stringFoo = Foo('Hello');
  print(stringFoo.getValue());

  print(firstOrNull(list1));
  print(firstOrNull([]));
}
