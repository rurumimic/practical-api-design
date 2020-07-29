package com.company.interitance;

public class Mixed {
  private int counter;
  private int sum;
	
  private Mixed() {
    super();
  }

  // 외부로 노출한 API 메서드
  public final int apiForClients() {
    int subclass = impl.toBeImplementBySubclass();

    // 필요한 로직 구현
    sum += subclass;
    int result = sum / counter;

    return result;
  }

  // 하위 클래스에서 구현해야 한다.
  protected abstract int toBeImplementBySubclass();

  // 하위 클래스는 이 메서드를 호출할 수 있다.
  protected final void toBeCalledBySubclass() { counter++; }
}
