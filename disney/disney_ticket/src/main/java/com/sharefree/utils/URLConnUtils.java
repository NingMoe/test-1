package com.sharefree.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.Properties;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import org.apache.log4j.Logger;

public class URLConnUtils {

	private static Logger log = Logger.getLogger(URLConnUtils.class);

	/**
	 * 向指定URL发送GET方法的请求
	 * 
	 * @param url
	 *            发送请求的URL
	 * @param paratg5m
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return URL 所代表远程资源的响应结果
	 */
	public static String sendGet(String url, String param) {
		String result = "";
		BufferedReader in = null;
		try {
			if (StringUtil.isNotEmpty(param))
				url = url + "?" + param;
			log.info("GET请求URL: " + url);
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			connection.setRequestProperty("Access-Control-Allow-Origin", "*");
			// 建立实际的连接
			connection.connect();
			// // 获取所有响应头字段
			// Map<String, List<String>> map = connection.getHeaderFields();
			// // 遍历所有的响应头字段
			// for (String key : map.keySet()) {
			// System.out.println(key + "--->" + map.get(key));
			// }

			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			log.error("HTTP发送GET请求出现异常: {}", e);
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 向指定URL发送GET方法的请求
	 * 
	 * @param url
	 *            发送请求的URL
	 * @param paratg5m
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @param connectOutTime
	 * @param readOutTime
	 *            超时时间
	 * @return URL 所代表远程资源的响应结果
	 */
	public static String sendGet(String url, String param, Integer connectOutTime, Integer readOutTime, Boolean isProxy, String proxyUrl, Integer proxyPort,
			String username, String password) {
		String result = "";
		BufferedReader in = null;
		try {
			String urlNameString = url + "?" + param;
			log.info("GET请求URL: " + urlNameString);
			URL realUrl = new URL(urlNameString);

			// 设置代理
			if (isProxy) {
				Properties prop = System.getProperties();
				// 设置http访问要使用的代理服务器的地址
				prop.setProperty("http.proxyHost", proxyUrl);
				// 设置http访问要使用的代理服务器的端口
				prop.setProperty("http.proxyPort", proxyPort + "");
				// 设置http访问要使用的代理服务器的用户名
				prop.setProperty("http.proxyUser", username);
				// 设置http访问要使用的代理服务器的密码
				prop.setProperty("http.proxyPassword", password);
			}

			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();

			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 设置超时时间
			if (null != connectOutTime) {
				connection.setConnectTimeout(connectOutTime);
			}
			if (null != readOutTime) {
				connection.setReadTimeout(readOutTime);
			}
			// 建立实际的连接
			connection.connect();
			// // 获取所有响应头字段
			// Map<String, List<String>> map = connection.getHeaderFields();
			// // 遍历所有的响应头字段
			// for (String key : map.keySet()) {
			// System.out.println(key + "--->" + map.get(key));
			// }

			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			log.error("HTTP发送GET请求出现异常: {}", e);
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 向指定URL发送GET方法的请求
	 * 
	 * @param url
	 *            发送请求的URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return URL 所代表远程资源的响应结果
	 */
	public static String sendGetHttps(String url, String param) {
		String result = "";
		BufferedReader in = null;
		try {
			String urlNameString = url + "?" + param;
			log.info("GET请求URL: " + urlNameString);

			// String urlNameString =
			// "https://api.test.lohoo.com/rest?timestamp=1430978778&format=json&method=hotel.order.create&signature=599c97c8e609d2cb90c06a3a14a316b7&user=Agent1420012550&data=%7B%22Version%22%3A%221.1%22%2C%22Local%22%3A%22zh_CN%22%2C%22Request%22%3A%7B%22AffiliateConfirmationId%22%3A%223100006171%22%2C%22HotelId%22%3A%2210101129%22%2C%22RoomTypeId%22%3A%220006%22%2C%22RatePlanId%22%3A%22103794%22%2C%22CustomerType%22%3A%22Chinese%22%2C%22PaymentType%22%3A%22SelfPay%22%2C%22EarliestArrivalTime%22%3A%222015-05-08+16%3A00%22%2C%22LatestArrivalTime%22%3A%222015-05-08+18%3A00%22%2C%22CurrencyCode%22%3A%22RMB%22%2C%22TotalPrice%22%3A%22900.0%22%2C%22CustomerIPAddress%22%3A%2210.0.1.16%22%2C%22ConfirmationType%22%3A%22NotAllowedConfirm%22%2C%22NumberOfRooms%22%3A%221%22%2C%22NumberOfCustomers%22%3A%221%22%2C%22ArrivalDate%22%3A%2205%5C%2F08%5C%2F2015%22%2C%22DepartureDate%22%3A%2205%5C%2F09%5C%2F2015%22%2C%22Contact%22%3A%7B%22Name%22%3A%22%5Cu674e%5Cu654f%22%2C%22Email%22%3A%22%22%2C%22Mobile%22%3A%2218862116681%22%2C%22Gender%22%3A%22Maile%22%7D%2C%22OrderRooms%22%3A%5B%7B%22Customers%22%3A%5B%7B%22Name%22%3A%22%5Cu674e%5Cu654f%22%2C%22Nationality%22%3A%22%22%7D%5D%7D%5D%7D%7D";
			// 代理
			// Proxy proxy= new Proxy(Proxy.Type.HTTP, new
			// InetSocketAddress("180.97.80.177", 8818));
			// 艺龙证书
			trustAllHttpsCertificates();
			HttpsURLConnection.setDefaultHostnameVerifier(hv);

			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连接
			HttpsURLConnection connection = (HttpsURLConnection) realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

			connection.setConnectTimeout(45000);
			connection.setReadTimeout(45000);

			// 建立实际的连接
			connection.connect();
			// 获取所有响应头字段
			// Map<String, List<String>> map = connection.getHeaderFields();
			// 遍历所有的响应头字段
			// for (String key : map.keySet()) {
			// System.out.println(key + "--->" + map.get(key));
			// }
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			log.error("HTTPS发送GET请求出现异常: {}", e);
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 向指定URL发送GET方法的请求
	 * 
	 * @param url
	 *            发送请求的URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return URL 所代表远程资源的响应结果
	 */
	public static String sendGetHttp(String url, String param) {
		String result = "";
		BufferedReader in = null;
		try {
			String urlNameString = url + "?" + param;
			log.info("GET请求URL: " + urlNameString);

			// String urlNameString =
			// "https://api.test.lohoo.com/rest?timestamp=1430978778&format=json&method=hotel.order.create&signature=599c97c8e609d2cb90c06a3a14a316b7&user=Agent1420012550&data=%7B%22Version%22%3A%221.1%22%2C%22Local%22%3A%22zh_CN%22%2C%22Request%22%3A%7B%22AffiliateConfirmationId%22%3A%223100006171%22%2C%22HotelId%22%3A%2210101129%22%2C%22RoomTypeId%22%3A%220006%22%2C%22RatePlanId%22%3A%22103794%22%2C%22CustomerType%22%3A%22Chinese%22%2C%22PaymentType%22%3A%22SelfPay%22%2C%22EarliestArrivalTime%22%3A%222015-05-08+16%3A00%22%2C%22LatestArrivalTime%22%3A%222015-05-08+18%3A00%22%2C%22CurrencyCode%22%3A%22RMB%22%2C%22TotalPrice%22%3A%22900.0%22%2C%22CustomerIPAddress%22%3A%2210.0.1.16%22%2C%22ConfirmationType%22%3A%22NotAllowedConfirm%22%2C%22NumberOfRooms%22%3A%221%22%2C%22NumberOfCustomers%22%3A%221%22%2C%22ArrivalDate%22%3A%2205%5C%2F08%5C%2F2015%22%2C%22DepartureDate%22%3A%2205%5C%2F09%5C%2F2015%22%2C%22Contact%22%3A%7B%22Name%22%3A%22%5Cu674e%5Cu654f%22%2C%22Email%22%3A%22%22%2C%22Mobile%22%3A%2218862116681%22%2C%22Gender%22%3A%22Maile%22%7D%2C%22OrderRooms%22%3A%5B%7B%22Customers%22%3A%5B%7B%22Name%22%3A%22%5Cu674e%5Cu654f%22%2C%22Nationality%22%3A%22%22%7D%5D%7D%5D%7D%7D";
			// 代理
			// Proxy proxy= new Proxy(Proxy.Type.HTTP, new
			// InetSocketAddress("180.97.80.177", 8818));
			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连接
			HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			connection.setConnectTimeout(45000);
			// connection.addRequestProperty("Accept-Encoding","gzip");
			// 建立实际的连接
			connection.connect();
			// 获取所有响应头字段
			// Map<String, List<String>> map = connection.getHeaderFields();
			// 遍历所有的响应头字段
			// for (String key : map.keySet()) {
			// System.out.println(key + "--->" + map.get(key));
			// }
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			log.error("HTTP发送GET请求出现异常: {}", e);
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	static HostnameVerifier hv = new HostnameVerifier() {
		@Override
		public boolean verify(String urlHostName, SSLSession session) {
			System.out.println("Warning: URL Host: " + urlHostName + " vs. " + session.getPeerHost());
			return true;
		}
	};

	/**
	 * 发送POST请求
	 * 
	 * @param url
	 *            目的地址
	 * @param parameters
	 *            请求参数，Map类型。
	 * @param encoding
	 *            参数编码
	 * 
	 * @return 远程响应结果
	 */
	public static String sendPost(String url, Map<String, String> parameters, String encoding) {
		String result = "";// 返回的结果
		BufferedReader in = null;// 读取响应输入流
		PrintWriter out = null;
		StringBuffer sb = new StringBuffer();// 处理请求参数
		String encode = "UTF-8"; // 默认编码
		if (StringUtil.isNotEmpty(encoding))
			encode = encoding;
		String params = "";// 编码之后的参数
		try {
			// 编码请求参数
			if (parameters.size() == 1) {
				for (String name : parameters.keySet()) {
					sb.append(name).append("=").append(java.net.URLEncoder.encode(parameters.get(name), encode));
				}
				params = sb.toString();
			} else {
				for (String name : parameters.keySet()) {
					sb.append(name).append("=").append(java.net.URLEncoder.encode(parameters.get(name), encode)).append("&");
				}
				String temp_params = sb.toString();
				params = temp_params.substring(0, temp_params.length() - 1);
			}
			// 创建URL对象
			java.net.URL connURL = new java.net.URL(url);
			// 打开URL连接
			java.net.HttpURLConnection httpConn = (java.net.HttpURLConnection) connURL.openConnection();
			// 设置通用属性
			httpConn.setRequestProperty("Accept", "*/*");
			httpConn.setRequestProperty("Connection", "Keep-Alive");
			httpConn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1)");
			// 设置POST方式
			httpConn.setDoInput(true);
			httpConn.setDoOutput(true);
			// 获取HttpURLConnection对象对应的输出流
			out = new PrintWriter(httpConn.getOutputStream());
			// 发送请求参数
			out.write(params);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应，设置编码方式
			in = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "UTF-8"));
			String line;
			// 读取返回的内容
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 向指定 URL 发送POST方法的请求
	 * 
	 * @param url
	 *            发送请求的 URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return 所代表远程资源的响应结果
	 */
	public static String sendPost(String url, String param, String contentType) {
		PrintWriter out = null;
		BufferedReader in = null;
		StringBuffer result = new StringBuffer();
		String rtn = null;
		try {
			URL realUrl = new URL(url);
			log.info("POST请求URL: " + url);
			log.info("POST请求参数: " + param);
			// 打开和URL之间的连接
			HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
			// 设置通用的请求属性
			if (null != contentType) {
				conn.setRequestProperty("Content-Type", contentType);
			}
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

			conn.setRequestProperty("Accept-Charset", "utf-8");

			conn.setUseCaches(false);

			// 发送POST请求必须设置如下两行
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setDoInput(true);

			// 设置连接超时时间
			conn.setConnectTimeout(40000);
			// 设置返回数据超时时间
			conn.setReadTimeout(10000);

			conn.connect();

			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(new OutputStreamWriter(conn.getOutputStream(), "UTF-8"));
			// out = new PrintWriter(conn.getOutputStream());
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String line;
			while ((line = in.readLine()) != null) {
				line = line.replaceAll("\\s", "");
				if (line.trim().matches("<td>([0-9]|-)+</td>"))
					System.out.println(line);
				result.append(line);
			}
			// 乱码转换
			rtn = result.toString();
		} catch (Exception e) {
			log.error("HTTP 发送 POST 请求出现异常！", e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return rtn;
	}

	/**
	 * 向指定 URL 发送POST方法的请求(无超时)
	 * 
	 * @param url
	 *            发送请求的 URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return 所代表远程资源的响应结果
	 */
	public static String sendPostWCS(String url, String param, String contentType) {
		PrintWriter out = null;
		BufferedReader in = null;
		StringBuffer result = new StringBuffer();
		String rtn = null;
		try {
			URL realUrl = new URL(url);
			log.info("POST请求URL: " + url);
			log.info("POST请求参数: " + param);
			// 打开和URL之间的连接
			HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
			// 设置通用的请求属性
			if (null != contentType) {
				conn.setRequestProperty("Content-Type", contentType);
			}
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

			conn.setRequestProperty("Accept-Charset", "utf-8");

			conn.setUseCaches(false);

			// 发送POST请求必须设置如下两行
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setDoInput(true);

			// 设置连接超时时间
			// conn.setConnectTimeout(4000);
			// 设置返回数据超时时间
			// conn.setReadTimeout(4000);

			conn.connect();

			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(new OutputStreamWriter(conn.getOutputStream(), "UTF-8"));
			// out = new PrintWriter(conn.getOutputStream());
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result.append(line);
			}
			// 乱码转换
			rtn = result.toString();
		} catch (Exception e) {
			log.error("HTTP 发送 POST 请求出现异常！", e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return rtn;
	}

	/**
	 * 向指定 URL 发送POST方法的请求
	 * 
	 * @param url
	 *            发送请求的 URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @param connectOutTime
	 * @param readOutTime
	 *            超时时间
	 * @return 所代表远程资源的响应结果
	 */
	public static String sendPost(String url, String param, String contentType, Integer connectOutTime, Integer readOutTime, Boolean isProxy, String proxyUrl,
			Integer proxyPort, String username, String password) {
		PrintWriter out = null;
		BufferedReader in = null;
		StringBuffer result = new StringBuffer();
		String rtn = null;
		try {
			URL realUrl = new URL(url);
			log.info("POST请求URL: " + url);
			log.info("POST请求参数: " + param);

			// 设置代理
			if (isProxy) {
				Properties prop = System.getProperties();
				// 设置http访问要使用的代理服务器的地址
				prop.setProperty("http.proxyHost", proxyUrl);
				// 设置http访问要使用的代理服务器的端口
				prop.setProperty("http.proxyPort", proxyPort + "");
				// 设置http访问要使用的代理服务器的用户名
				prop.setProperty("http.proxyUser", username);
				// 设置http访问要使用的代理服务器的密码
				prop.setProperty("http.proxyPassword", password);
			}

			// 打开和URL之间的连接
			HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
			// 设置通用的请求属性
			if (null != contentType) {
				conn.setRequestProperty("Content-Type", contentType);
			}

			// 设置超时时间
			if (null != connectOutTime) {
				conn.setConnectTimeout(connectOutTime);
			}
			if (null != readOutTime) {
				conn.setReadTimeout(readOutTime);
			}

			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

			conn.setRequestProperty("Accept-Charset", "utf-8");

			conn.setUseCaches(false);

			// 发送POST请求必须设置如下两行
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setDoInput(true);

			conn.connect();

			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(new OutputStreamWriter(conn.getOutputStream(), "UTF-8"));
			// out = new PrintWriter(conn.getOutputStream());
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result.append(line);
			}
			// 乱码转换
			rtn = result.toString();
		} catch (Exception e) {
			log.error("HTTP 发送 POST 请求出现异常！", e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return rtn;
	}

	/**
	 * 默认是json格式
	 * 
	 * @param url
	 * @param param
	 * @return
	 */
	public static String sendPost(String url, String param) {
		return sendPost(url, param, "application/json");
	}

	/**
	 * 默认是json格式
	 * 
	 * @param url
	 * @param param
	 * @param connectOutTime
	 * @param readOutTime
	 * @return
	 */
	public static String sendPost(String url, String param, Integer connectOutTime, Integer readOutTime) {
		return sendPost(url, param, "application/json", connectOutTime, readOutTime, false, null, null, null, null);
	}

	/**
	 * 自定义contentType
	 * 
	 * @param url
	 * @param contentType
	 * @param param
	 * @param connectOutTime
	 * @param readOutTime
	 * @return
	 */
	public static String sendPost(String url, String contentType, String param, Integer connectOutTime, Integer readOutTime) {
		if (StringUtil.isEmpty(contentType))
			contentType = "application/x-www-form-urlencoded";
		return sendPost(url, param, contentType, connectOutTime, readOutTime, false, null, null, null, null);
	}

	public static String sendPost(String url, String param, Integer connectOutTime, Integer readOutTime, Boolean isProxy, String proxyUrl, Integer proxyPort,
			String username, String password) {
		return sendPost(url, param, "application/json", connectOutTime, readOutTime, isProxy, proxyUrl, proxyPort, username, password);
	}

	private static void trustAllHttpsCertificates() throws Exception {
		javax.net.ssl.TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[1];
		javax.net.ssl.TrustManager tm = new miTM();
		trustAllCerts[0] = tm;
		javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext.getInstance("SSL");
		sc.init(null, trustAllCerts, null);
		javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
	}

	static class miTM implements javax.net.ssl.TrustManager, javax.net.ssl.X509TrustManager {
		public java.security.cert.X509Certificate[] getAcceptedIssuers() {
			return null;
		}

		public boolean isServerTrusted(java.security.cert.X509Certificate[] certs) {
			return true;
		}

		public boolean isClientTrusted(java.security.cert.X509Certificate[] certs) {
			return true;
		}

		public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) throws java.security.cert.CertificateException {
			return;
		}

		public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) throws java.security.cert.CertificateException {
			return;
		}
	}

	public static void main(String[] args) throws UnsupportedEncodingException {

	}
}
