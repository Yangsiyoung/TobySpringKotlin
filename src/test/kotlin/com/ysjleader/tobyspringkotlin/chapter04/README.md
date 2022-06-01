예외
==========

# 예외 블랙홀
```kotlin

try {
        // logic
    } catch (e: Exception) {
        // nothing
    }
```

```kotlin
try {
        // logic
    } catch (e: Exception) {
        println(e)
    }
```

```kotlin
try {
        // logic
    } catch (e: Exception) {
        e.printStackTrace()
    }
```

예외를 처리할 때 지켜야할 원칙은 하나다.  
모든 예외는 적절하게 복구되거나, 작업을 중단시키고 운영자 또는 개발자에게 통보되어야한다.  

# 무의미하고 무책임한 throws

```java
public void method01() throws Exception {
    method02();
    ...
}

public void method02() throws Exception {
    method03();
    ...
}

public void method03() throws Exception {
    ...
}
```

* Exception 이라는 건 어떤 예외가 발생하는지 명확하지 않다.  
* 모든 예외를 던져버리는 선언이기 때문.  
* 정말 실행 중 예외가 발생할 수 있다는 것인지,  
* 습관적으로 복사해서 붙여놓은것인지 알 수 없다.  
* 따라서 이 메서드를 사용하려면 사용하는 메서드에서도 throws Exception 을 따라서 붙이는 수 밖에,,,  

# 예외의 종류와 특징
자바에서 throw 를 통해 발생시킬 수 있는 예외는 크게 3가지.  

## Error
시스템에 뭔가 비정상적인 상황이 발생했을 경우에 사용.  
주로 자바 VM 에서 발생시키며, 로직단에서 잡으려고 하면 안된다.  
결국 이런 에러에 대한 처리는 신경 쓰지 않아두 댄다.  

## Exception 과 Checked 예외
Exception 클래스는 Checked Exception 과 Unchecked Exception 으로 구분된다.  
일반적으로 예외라고 하면 RuntimeException 을 상속하지 않은, Checked Exception 을 생각하면 된다.  
그래서 Checked Exception 은 반드시 예외를 처리하는 코드가 필요하다.  

## RuntimeException 과 Unchecked / Runtime 예외  
이 타입의 예외는 명시적인 예외처리를 강제하지 않는다.  
그래서 Unchecked Exception 으로 불리며, 대표적인 클래스 명인 RuntimeException 이름을 따서,
Runtime 예외라고 불리기도 한다.  

이 RuntimeException 은 프로그램의 오류가 있을때 발생하도록 의도된 것 이다.  
즉, NPE(NullPointerException) 나 허용되지 않는 값을 사용하여 메소드를 호출할때 발생하는,  
IllegalArgumentException 등이 있다.  

즉, 피할 수 있는 문제이지만 개발자가 부주의해서 발생할 수 있는 경우에 발생하도록 만든 것이 RuntimeException.  

# 예외처리 방법

## 예외 복구
문제를 해결해서 정상으로 돌려 놓는 것  
예를들어 사용자가 요청한 파일을 읽으려고 했는데, 파일이 없거나 문제가 있어 읽히지 않아 IOException 이 발생했다면,  
예외를 사용자에게 알려주고, 다른 파일을 이용하도록 안내하는 것.  
즉, 예외로 인해 의도된 작업이 불가능할때, 다른 작업 흐름으로 자연스럽게 유도함으로써 예외를 복구하는 것  

그냥 IOException 에러 메시지가 던져지는게 아니라, 다른 흐름을 통해 복구할 수 있도록 해야함.  

혹은 Network 가 불안정해서 다른 서버에 잠시 접근이 안되면,  
재시도를 통해서 해결하던지. (물론 정해진 횟수만큼 재시도해서 실패하면 복구 포기해야댄다리)  

`예외처리 코드를 강제하는 체크 예외는 이렇게 예외를 어떻게든 복구할 가능성이 있는 경우에 사용`    


## 예외처리 회피
예외를 자신이 담당하지 않고, 자신을 호출한 쪽으로 던져버리는 것.  
빈 catch 블록으로 잡는거말고,,, 예외처리를 회피한다는건 다른 오브젝트나 메소드가 예외를 대신 처리할 수 있도록  
던져주는것

## 예외 전환
1) 의미를 분명하게 해주는 예외로 바꿔주기 위해 사용  
DAO 에서 SQLException 정보를 분석해서 DuplicateUserIdException 등과 같은  
명확한 예외로 바꿔서 던져주는 등  

2) 예외를 처리하기 쉽고 단순하게 만들기 위해 래핑하는 것  
예외처리를 강제하는 체크 예외를 언체크 예외인 런타임 예외로 바꾸는 경우에 주로 사용  

* 어차피 복구하지 못할 예외라면 로직에서는 런타임 예외로 포장해서 던지고,  
  로그를 남기고 관리자에게 통보하고, 사용자에게는 친절한 안내메시지를 남기는게 바람직.
