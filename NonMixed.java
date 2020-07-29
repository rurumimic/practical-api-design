package com.company.composition;

public class NonMixed {
	private int counter;
	private int sum;
	private final Provider impl;

	private NonMixed(Provider impl) { this.impl = impl; }

	public statis NonMixed create(Provider impl) {
		NonMixed api = new NonMixed(impl);
		Callback callback = new Callback(api);
		impl.initialize(callback);
		return api;
	}

	public final int apiForClients() {
		int subclass = impl.toBeImplementBySubclass();

		sum += subclass;
		int result = sum / counter;

		return result;
	}

	public interface Provider {
		public void initialize(Callback c);
		public int toBeImplementBySubclass();
	}

	public static final class Callback {
		NonMixed api;
		Callback(NonMixed api) { this.api = api; }
		public final void toBeCalledBySubclass() { api.counter++ }
	}
}
