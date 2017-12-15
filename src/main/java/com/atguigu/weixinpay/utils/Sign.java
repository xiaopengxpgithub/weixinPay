package com.atguigu.weixinpay.utils;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

/**
 * 参数签名认证
 * 
 * @author xiaopeng
 */
public class Sign {

	public static String Sign(SortedMap<Object, Object> parameters, String Key) {

		StringBuffer sb = new StringBuffer();
		Set es = parameters.entrySet();
		Iterator<?> it = es.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			Object v = entry.getValue();
			if (null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {
				sb.append(k + "=" + v + "&");
			}
		}

		sb.append("key=" + Key);

		String sign = MD5.MD5Encode(sb.toString(), "UTF-8").toUpperCase();

		return sign;
	}
}
