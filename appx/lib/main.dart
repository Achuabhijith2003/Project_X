import 'package:flutter/material.dart';
import 'package:flutter/src/widgets/framework.dart';
import 'package:flutter/src/widgets/placeholder.dart';

void main(List<String> args) {
  runApp(appx());
}

class appx extends StatelessWidget {
  const appx({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      theme: ThemeData(primaryColor: Color.fromARGB(5, 255, 255, 255)),
    );
  }
}
