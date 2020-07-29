package com.company.interitance;

public class SubMixed extends Mixed {
  private SubMixed() {
    super();
  }

  // 하위 클래스에서 구현해야 한다.
	@Override
	protected int toBeImplementBySubclass() {
		toBeCalledBySubclass(); // 상위 클래스의 메서드를 호출할 수 있다.
		return 7;
  }
}
