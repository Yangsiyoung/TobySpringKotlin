package com.ysjleader.tobyspringkotlin.chapter03.conclusion

// 1. Template Method Pattern => 템플릿 메소드 패턴
// => Inheritance
// => is - a
// 변경이 잘 일어나지 않는 곳 / 잘 일어나는 곳
// 잘 일어나는 곳 => 추상 메서드
// 추상 메서드 => 서브 클래스에서 구현화

open class Animal {

}

class Dog: Animal() {

}

// 2. Composition => 합성
// has - a
// 상속이 아닌 객체간의 적절한 협력

// 역할 / 책임 / 협력