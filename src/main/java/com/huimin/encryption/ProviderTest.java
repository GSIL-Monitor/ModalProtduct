package com.huimin.encryption;

import java.security.Provider;
import java.security.Security;

import org.junit.Test;

public class ProviderTest {

	@Test
	public void test01() {
		//Provider provider = SunP;
		Provider[] providers = Security.getProviders();
		for (Provider provider : providers) {
			System.out.println(provider);
			provider.entrySet().forEach(action -> {
				System.out.println(action.getKey() + " ---> " + action.getValue());
			});
		}
	}
}
