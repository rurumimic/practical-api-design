package com.company.composition;

public class NonMixed {
  private int counter;
  private int sum;
  private final Provider impl; // API 사용자가 구현한 인터페이스

  // 팩토리 메서드로 생성자를 호출한다.
  // @param impl API를 호출한 곳에서 구현한 인터페이스를 주입한다.
  private NonMixed(Provider impl) { this.impl = impl; }

  // API를 생성하는 곳에서 호출한다.
  // @param impl API를 사용할 곳에서 구현한 인터페이스
  // @return 생성된 클래스를 반환한다.
  public static NonMixed create(Provider impl) {
    NonMixed api = new NonMixed(impl);
    Callback callback = new Callback(api);
    impl.initialize(callback);
    return api;
  }

  // 외부로 노출한 API 메서드
  public final int apiForClients() {
    int subclass = impl.toBeImplementBySubclass();

    // 필요한 로직 구현
    sum += subclass;
    int result = sum / counter;

    return result;
  }

  // API를 생성/호출하는 곳에서 구현해야 한다.
  // API 사용자는 인터페이스를 강제적으로 구현해야 한다.
  public interface Provider {
    public void initialize(Callback c); // 콜백 객체를 저장한다.
    public int toBeImplementBySubclass(); // API를 생성/호출하는 곳에서 구현해야 한다.
  }

  // 인터페이스 구현체는 콜백 객체의 메서드를 이용해서 상위 클래스와 상호작용할 수 있다.
  public static final class Callback {
    NonMixed api; // 상위 클래스를 가리킨다.
    Callback(NonMixed api) { this.api = api; } // 상위 클래스를 저장한다.
    // API 사용자의 인터페이스 구현체에서 호출할 수 있다.
    public final void toBeCalledBySubclass() { api.counter++; }
  }
}
