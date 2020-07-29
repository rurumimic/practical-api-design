package com.company;

import com.company.composition.NonMixed;
import com.company.inheritance.Mixed;
import com.company.inheritance.SubMixed;

public class Main {
  public static void inherit() {
    Mixed mixed = new SubMixed();
    assert 7 == mixed.apiForClients();
  }

	public static void compose() {
		class AddThreeMixedCounter implements NonMixed.Provider {
			private NonMixed.Callback callback;

			@Override
			public void initialize(NonMixed.Callback c) {
				callback = c;
			}
		
			@Override
			public int toBeImplementBySubclass() {
				callback.toBeCalledBySubclass();
				return 3;
			}
		}

    NonMixed add3 = NonMixed.create(new AddThreeMixedCounter());
    assert 3 == add3.apiForClients();
  }

	public static void main(String[] args) {
		inherit();
		compose();
	}
}
