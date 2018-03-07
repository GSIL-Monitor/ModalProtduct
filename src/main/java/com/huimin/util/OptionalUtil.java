package com.huimin.util;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class OptionalUtil {
	
	private static Logger logger = LoggerFactory.getLogger(OptionalUtil.class);

	public static Optional<Integer> string2Int(String str){
		try {
			return Optional.of(Integer.parseInt(str));
		} catch (NumberFormatException e) {
			logger.error("string to int happen excetion", e);
			return Optional.empty();
		}
	}
}
