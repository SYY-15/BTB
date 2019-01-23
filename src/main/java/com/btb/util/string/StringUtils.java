package com.btb.util.string;

public class StringUtils {
	
	/**
	 * 判断字符串是否为空
	 * @param string
	 * @return
	 * null true;
	 * ""	true;
	 * "  "	true;
	 */
	public static boolean isEmpty(String string) {
		boolean ret = true;
		if(string != null)
		{
			if (string.matches("[\\S]*")) {
				ret = false;
			}
		}
		return ret;
	}
}
