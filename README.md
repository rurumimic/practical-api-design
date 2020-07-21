# Practical API Design

- [Practical API Design: Confessions of a Java Framework Architect](https://www.apress.com/gp/book/9781430209737)
- [자바 API 디자인](https://wikibook.co.kr/practical-api-design/)

1. 이론과 정당성
1. 실제 설계
1. 일상 생활

---

## 들어가기

- 프레임워크, 공유 라이브러리 설계
- 하위 호환성을 보장하는 설계

API는 별과 같아서 한번 도입되고 나면 영원히 그 자리에 존재한다.

**왜 API를 만드는 것인가?**  
**API란 무엇인가?**

**API 설계를 배워야 하는 이유:**  
서로 이해한 바를 공유하게 되어  
의사소통이 단순해지고  
의사 결정을 따로 설명할 필요가 없어진다.

팀원 간의 협동이 향상되고,  
결과적으로 **좋은 품질의 소프트웨어**로 이어진다.

---

## 1. 이론과 정당성

**API 설계는 공학적인 체계가 필요하다.**  
API를 개발할 때 저마다 창의성을 드러낸다면 일관성이 떨어진다.  
API 아키텍트는 팀원 사이에서 조율하기 힘들어진다.  
팀원들과 비전을 공유해야 하고,  
비전을 표현하는 어휘, 비전 달성을 할 수 있는 방법론도 필요하다.

API를 설계할 때는 개인적인 선호뿐 아니라 문화적인 차이도 고려해야 한다.

### Chapter 1. 현대 소프트웨어 구축의 예술

선택적 무지: selective cluelessness

소프트웨어 개발에서 목표는 안정적으로 출시하는 것이다.  
시스템의 동작과정을 전부 이해하지 않아도 된다.  
실용적으로 기존 라이브러리, 프레임워크를 조합하여 시스템을 완성한다.  

마찬가지로 API는 복잡한 것을 감추는 역할을 한다.

### Chapter 2. API를 만드는 이유

API는 컴포넌트의 기능과 내부 구현을 추상화한 것이다.  
때로는 추상화 너머 실제 구현이 누출될 수 있다.  
우리는 이때 컴포넌트의 내부를 알면 도움이 된다.

애플리케이션 개발에서 첫 단계는 무지한 상태에서 라이브러리를 사용하는 것이다.  
따라서 컴포넌트를 재사용하기 위해서는 API 설계가 훌륭해야 한다.

컴포넌트를 이해하지 못해도 수 많은 컴포넌트를 조립할 수 있는 능력이 필요하다.

1. 컴포넌트는 적절한 이름을 가진다.
1. 컴포넌트는 필요한 환경 정보를 전달해야 한다.
1. 컴포넌트 의존성은 자동으로 처리되어야 한다.
1. 컴포넌트의 하위 호환성은 유지되어야 한다.

의사소통 채널:
1. API 자체
1. API의 문서

모듈화된 애플리케이션에게 필요한 API:
1. 명확하다.
1. 이해하기 쉽다.
1. 스스로 설명한다.
1. 문서화가 잘 되어 있다.

신뢰할 수 있는 API:
1. 일어날 만한 실수를 미리 방지한다.
1. 진화할 준비가 갖추어져 있다.

각 컴포넌트는 독립적으로 진화하기 때문에 안정적인 계약이 필요하다.

호환성 단절은 신뢰를 저버리는 것이다.

첫 번째 버전은 늘 쉽다.

### Chapter 3. 훌륭한 API를 결정하는 요소

관점: 다른 사람들이 무슨 일을 했는지 알아보는 시간 낭비를 하지 않아야 한다.

- 메서드와 필드 시그너처
- 파일과 파일의 내용
- 환경변수와 명령줄 옵션
- 프로토콜: 적절한 핸드셰이크 필요
- 동작방식: 컴포넌트 추상화 누출과 같은 사용자의 이해 필요
- I18N 지원과 L10N 메시지
- 넓은 의미의 API: DB, XML 스키마, WDDL, REST, IDL

API 품질 검사 방법:
- 이해도
- 일관성
- 발견 가능성: API 적용을 시작할 수 있는 진입점 표시
- 단순한 작업은 쉬워야 한다: 사용자 그룹에 따른 API 설계
- 투자 보전: API 사용자들이 투자한 시간, 연구, 노력, 돈을 보전해야 한다. API를 사용하는 사람들을 행복하게 만들어야 한다.

애플리케이션은 가장 부하가 심한 조건에서 테스트하는 것이 좋다.  
WWW는 최고의 오픈소스 프로젝트이다.

### Chapter 4. 시시각각 변하는 표적

훌륭한 API는 시간이 흐른 뒤에도 살아남는다.

첫 번째 버전은 결코 완벽하지 않다.

모든 API 제작자는 진화 계쇡을 마련해 둬야 한다.  
향후 릴리스에서 API에 어떤 일이 발생할지  
전략적인 차원에서 알고 있어야 한다.

#### 하위 호환성

- 소스 호환성: 컴파일 할 수 있는가? 어렵다.
- 바이너리 호환성: 이전 버전으로 컴파일된 프로그램이 새 API와 링크될 수 있는가?
  1. 한 번 컴파일하여 여러 버전으로 사용할 수 있다.
  1. 이전 버전 빌드 사용자가 새 라이브러리로 마이그레이션 할 수 있다.
  - 자바 특성: 자바 소스 코드와 바이트 코드는 다르다
    - jasm, BCEL, classfile 등으로 분석, 변경 가능
- 기능적 호환성: 동일한 결과를 보이는가?
  - 아메바 효과: 명세와 실제 구현이 차이난다.

API 설계자는 잘못된 동작 방식, 사용 방식까지 책임을 져야 한다.

#### 유스 케이스 지향

API 명세와 실제 구현 간의 차이를 작게 만들어야 한다.

- 유스 케이스: 어떻게 이렇게 하는가?
  - API에서 의도하는 사용법을 설명한 것.
  - 잠재 사용자가 겪을 문제를 보여준다.
- 시나리오: 유스 케이스의 답변
  - 실제 단계를 설명한 것.
- (자바독)

명세를 작성하여 차이를 측정해야 유지보수를 할 수 있다.

#### API 검토

규칙:
1. 유스 케이스 기반 API 설계
1. 일관성 있는 API 설계
1. 단순하고 깔끔한 API 설계
1. 더 적은 것이 더 많다
1. 진화 대비

#### API의 생명 주기

API를 만드는 과정은 의사소통에 관한 것이다.

#### 점진적 향상

API의 변화가 필요할 때 두 가지 대응 방법:

1. 빅뱅 방식: 새로운 버전을 만든다.
   - 장점: 비호환성 문제를 방지한다.
   - 단점: 
     - 클라이언트는 번경하기 쉽지 않다.
     - 변경 후에도 빅뱅 방식이 또 필요할 수 있다.
   - 설계와 개발, 테스트 방벚에 문제가 있을 것이다.
1. 점진적 진화 방식
   - 장점:
     - 클라이언트 피해가 적다.
     - 클라이언트 수정 없이 버그 수정과 성능 향상 및 룩앤필 개선이 가능하다.
   - 단점:
     - 하위 호환성에 잠재적인 위험성이 존재한다.
     - 버그 하나가 두 개로 늘어날 수 있다.

중요한 것은 컴포넌트의 신뢰성과  
해당 컴포넌트를 설계한 사람의 책임감이다.

---

## 2. 실제 설계

### Chapter 5. 필요 이상으로 노출하지 마라
