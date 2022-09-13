package com.empresa.orders.apirest.auth;

public class JwtConfig {

	public static final String RSA_PRIVADA = "-----BEGIN RSA PRIVATE KEY-----\r\n"
			+ "MIIEowIBAAKCAQEAzh/dCnaUIGQY/AeVYV3iyoY++B6q+EgezCrcVSHsnAbUZ5Vl\r\n"
			+ "V9yeLA6K479JQYo2On/GNAcvsmBH6F7LXEgJHFZV2LZMHYachu9SYYhBJXAFrgwB\r\n"
			+ "oLR6TobkNjaKznC1BGIgfdev4N93izqFN158VrTT3DdqG0slKFo54NO9vgF/zB5e\r\n"
			+ "I+8CG26f9AJqU5zIsks9Pti3joVOLDHkHTf7yDfpUxLu6Yl+9AwlJBtFrYh+LkZH\r\n"
			+ "HJH84xUhlBv2DGXNyzgL4irNw/xDt+pSn/rWN1FewMi9Pad1RWRLf04SQMWmu1Hl\r\n"
			+ "OxqO+8PHjrY8n+uZRkqqzvVrnZEaYbLGeLR34wIDAQABAoIBAEk4KFy/In8fD4D3\r\n"
			+ "cKjVoOowJc4dlr37YHVGBF55XoNOKcVh3E4JoGYmBFBCctNFNV4yZUW2B8tlSCXT\r\n"
			+ "BooRTKs0P+prVz5lwtRrzue2bu3NjTb2LN3ZPlkGsapQVZ5fiu2zrbcGFwPaXayn\r\n"
			+ "bQruFVz3fwqK5LYtS1W6NzUWAiCr48+fOLafhRxxQIPQ8AlkgmqmtVyhr2xe+Gmn\r\n"
			+ "Mn6AntxBDe5RwBc0q7VpVnXwFZ4k0n5D4/yC+p+pLVadjv3BWqDh/9hGd00qq/91\r\n"
			+ "Vmr+seAmRDN1gyOVVXyBiCprmcmF7sQvrw42vXui8LzxSxjaJr87vykqA8gqrlOb\r\n"
			+ "wZ5N0YECgYEA+zIu4WFwrPHsNx73UAwIvpt2aW9nlTTjum7XgfBTQl+4rX2p3W7Q\r\n"
			+ "JZo8ltBDjpcYpg16fHDH26ZJBjG8wupG3OV/sSndPPKASlaWAkBogWwG0ORjRLbi\r\n"
			+ "vT7xSrHq+RWZ+C7bizLQyqH/hFdXldBONBAsSw/uKK7ha33CvfltZK0CgYEA0hEE\r\n"
			+ "VUimJKVOAueAamWdaRvVWuY8vvZqdCaSjWUpXy7JuO/7S8tuMD6o5Ll3haqky/Q2\r\n"
			+ "NrJmHVZxhz2nzaofYGwA1fHEglnR6RT0W/tnFUpo8d3fgQw3r+lXVBGcwxM+xMhM\r\n"
			+ "+A3aywKrUXgYXHNcpulhEyf3dcGpRxoEj7AyUM8CgYAo3cMuu5F/MWSCmzEU/sA1\r\n"
			+ "cklTYeJyLcaWwA2jgBurgrMi1nzaH3sRgwQ0bPFwszg5W5v/vsFlBKqArXrOIxsg\r\n"
			+ "ON4LTopFrhYdAfUprJzT4WVCesWDmlVNAH507nkRyOfhro3dGYlKTgyp1SPUpazz\r\n"
			+ "X2Y1WAQg7kKSIEWcboXTiQKBgQC0Jrvcl+1ESC/a9cZ/eJ3CYoha6FD4REOPUPUm\r\n"
			+ "JbeRVYLSA50zp0bcQSB+5z/Fdk7WSp2j0uMYDeZW4V1jV56JBpbA5BJu57DJf5sA\r\n"
			+ "t130OFg/9NOUzHGFf0vRYTlbYsnV4SGBKgCVUbiyqZfa0WSIEGWcFA55Api1zW5T\r\n"
			+ "+/tqqQKBgCFvnZoQNq9UZeZsKguEFDPRIAFa6srEtJadqHaoSUEiymmDVca5HYIN\r\n"
			+ "b1eoHe0xc0d5sIUPX4V2H4YP2NB4OyaIZh+Y8ySiwowAsb+N/BuU2rJqCsv4MgrZ\r\n"
			+ "23QGF7Z1axA1pc6Spa41ctBJzNLcx2sG+bai/7qgNdVwFUlBQsH/\r\n"
			+ "-----END RSA PRIVATE KEY-----";
	
	public static final String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\r\n"
			+ "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAzh/dCnaUIGQY/AeVYV3i\r\n"
			+ "yoY++B6q+EgezCrcVSHsnAbUZ5VlV9yeLA6K479JQYo2On/GNAcvsmBH6F7LXEgJ\r\n"
			+ "HFZV2LZMHYachu9SYYhBJXAFrgwBoLR6TobkNjaKznC1BGIgfdev4N93izqFN158\r\n"
			+ "VrTT3DdqG0slKFo54NO9vgF/zB5eI+8CG26f9AJqU5zIsks9Pti3joVOLDHkHTf7\r\n"
			+ "yDfpUxLu6Yl+9AwlJBtFrYh+LkZHHJH84xUhlBv2DGXNyzgL4irNw/xDt+pSn/rW\r\n"
			+ "N1FewMi9Pad1RWRLf04SQMWmu1HlOxqO+8PHjrY8n+uZRkqqzvVrnZEaYbLGeLR3\r\n"
			+ "4wIDAQAB\r\n"
			+ "-----END PUBLIC KEY-----";

	
}
