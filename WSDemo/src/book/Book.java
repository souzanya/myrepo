package book;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import pojo.BookInfo;

@Path("book")
public class Book {

	@GET
	//@Path("hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
		return "Hello World";
		//return "<?xml version='1.0'?><hello>Hello World</hello></xml>";
	}
	
	@GET
	@Path("{name}")
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHelloWithParams(@PathParam("name") String name) {
		return "Hello World "+name;
		//return "<?xml version='1.0'?><hello>Hello World</hello></xml>";
	}
	
	@GET
	@Path("bookInfo/{bookName}")
	@Produces(MediaType.APPLICATION_JSON)
	public BookInfo getBookInfo(@PathParam("bookName") String bookName) {
		BookInfo info = new BookInfo();
		if(bookName!=null && bookName.equals("HP")) {
			info.setBookCost(200);
			info.setBookName("HarryPotter");
			//return info;
		}
		return info;
	}
	
	@GET
	@Path("bookInfo")
	@Produces(MediaType.APPLICATION_JSON)
	public BookInfo getBookInfoQP(@QueryParam("bookName") String bookName) {
		BookInfo info = new BookInfo();
		if(bookName!=null && bookName.equals("HP")) {
			info.setBookCost(200);
			info.setBookName("HarryPotter");
			//return info;
		}
		return info;
	}
}
