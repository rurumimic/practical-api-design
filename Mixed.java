package com.company.interitance;

public class Mixed {
	private int counter;
	private int sum;
	
  private Mixed() {
    super();
  }

	public final int apiForClients() {
		int subclass = impl.toBeImplementBySubclass();

		sum += subclass;
		int result = sum / counter;

		return result;
	}

	protected abstract int toBeImplementBySubclass();
	protected final void toBeCalledBySubclass() { counter++; }
}
